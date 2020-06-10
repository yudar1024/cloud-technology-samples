package com.mycompany.myapp.config;

import com.google.common.base.Preconditions;
import io.seata.config.FileConfiguration;
import io.seata.core.context.RootContext;
import io.seata.core.rpc.netty.RmRpcClient;
import io.seata.core.rpc.netty.TmRpcClient;
import io.seata.rm.RMClient;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.tm.TMClient;
import io.seata.tm.api.GlobalTransaction;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.SneakyThrows;
import org.apache.shardingsphere.spi.database.type.DatabaseType;
import org.apache.shardingsphere.transaction.core.ResourceDataSource;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.spi.ShardingTransactionManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class MySeataATShardingTransactionManager implements ShardingTransactionManager {

    private final Map<String, DataSource> dataSourceMap = new HashMap<>();

    private final String applicationId;

    private final String transactionServiceGroup;

    private final boolean enableSeataAT;

    public MySeataATShardingTransactionManager() {
        FileConfiguration configuration = new FileConfiguration("seata.conf");
        enableSeataAT = configuration.getBoolean("sharding.transaction.seata.at.enable", true);
        applicationId = configuration.getConfig("client.application.id");
        transactionServiceGroup = configuration.getConfig("client.transaction.service.group", "default");
    }

    @Override
    public void init(final DatabaseType databaseType, final Collection<ResourceDataSource> resourceDataSources) {
        if (enableSeataAT) {
//            initSeataRPCClient();
            for (ResourceDataSource each : resourceDataSources) {
                dataSourceMap.put(each.getOriginalName(), new DataSourceProxy(each.getDataSource()));
            }
        }
    }


    @Override
    public TransactionType getTransactionType() {
        return TransactionType.BASE;
    }

    @Override
    public boolean isInTransaction() {
        Preconditions.checkState(enableSeataAT, "sharding seata-at transaction has been disabled.");
        return null != RootContext.getXID();
    }

    @Override
    public Connection getConnection(final String dataSourceName) throws SQLException {
        Preconditions.checkState(enableSeataAT, "sharding seata-at transaction has been disabled.");
        return dataSourceMap.get(dataSourceName).getConnection();
    }

    @Override
    @SneakyThrows
    public void begin() {
        Preconditions.checkState(enableSeataAT, "sharding seata-at transaction has been disabled.");
        GlobalTransaction globalTransaction = GlobalTransactionContext.getCurrentOrCreate();
        globalTransaction.begin();
        SeataTransactionHolder.set(globalTransaction);
    }

    @Override
    @SneakyThrows
    public void commit() {
        Preconditions.checkState(enableSeataAT, "sharding seata-at transaction has been disabled.");
        try {
            SeataTransactionHolder.get().commit();
        } finally {
            SeataTransactionHolder.clear();
            RootContext.unbind();
        }
    }

    @Override
    @SneakyThrows
    public void rollback() {
        Preconditions.checkState(enableSeataAT, "sharding seata-at transaction has been disabled.");
        try {
            SeataTransactionHolder.get().rollback();
        } finally {
            SeataTransactionHolder.clear();
            RootContext.unbind();
        }
    }

    @Override
    public void close() {
        dataSourceMap.clear();
        SeataTransactionHolder.clear();
        TmRpcClient.getInstance().destroy();
        RmRpcClient.getInstance().destroy();
    }
}
