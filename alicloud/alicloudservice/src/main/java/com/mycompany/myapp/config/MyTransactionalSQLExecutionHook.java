package com.mycompany.myapp.config;

import io.seata.core.context.RootContext;
import org.apache.shardingsphere.spi.database.metadata.DataSourceMetaData;
import org.apache.shardingsphere.underlying.executor.engine.ExecutorDataMap;
import org.apache.shardingsphere.underlying.executor.hook.SQLExecutionHook;

import java.util.List;
import java.util.Map;

public class MyTransactionalSQLExecutionHook implements SQLExecutionHook {
    private static final String SEATA_TX_XID = "SEATA_TX_XID";
    private boolean seataBranch;

    public MyTransactionalSQLExecutionHook() {
    }

    public void start(String dataSourceName, String sql, List<Object> parameters, DataSourceMetaData dataSourceMetaData, boolean isTrunkThread, Map<String, Object> shardingExecuteDataMap) {
        if (isTrunkThread) {
            if (RootContext.inGlobalTransaction()) {
                ExecutorDataMap.getValue().put("SEATA_TX_XID", RootContext.getXID());
            }
        } else if (!RootContext.inGlobalTransaction() && shardingExecuteDataMap.containsKey("SEATA_TX_XID")) {
            RootContext.bind((String)shardingExecuteDataMap.get("SEATA_TX_XID"));
            this.seataBranch = true;
        }

    }

    public void finishSuccess() {
        if (this.seataBranch) {
            RootContext.unbind();
        }

    }

    public void finishFailure(Exception cause) {
        if (this.seataBranch) {
            RootContext.unbind();
        }

    }
}
