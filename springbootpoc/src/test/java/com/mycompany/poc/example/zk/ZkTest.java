package com.mycompany.poc.example.zk;


import lombok.Cleanup;
import lombok.SneakyThrows;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.jupiter.api.Test;

public class ZkTest {

    @Test
    public void ZkDistributedLock(){
        final String connectString = "localhost:2181,localhost:2182,localhost:2183";

        // 重试策略，初始化每次重试之间需要等待的时间，基准等待时间为1秒。
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

        // 使用默认的会话时间（60秒）和连接超时时间（15秒）来创建 Zookeeper 客户端
        @Cleanup CuratorFramework client = CuratorFrameworkFactory.builder().
            connectString(connectString).
            connectionTimeoutMs(15 * 1000).
            sessionTimeoutMs(60 * 100).
            retryPolicy(retryPolicy).
            build();
        client.start();

    }
}
