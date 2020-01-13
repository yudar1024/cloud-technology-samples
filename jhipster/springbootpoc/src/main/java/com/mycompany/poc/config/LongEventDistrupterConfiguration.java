package com.mycompany.poc.config;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.LiteTimeoutBlockingWaitStrategy;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.mycompany.poc.events.LongEvent;
import com.mycompany.poc.events.LongEventFactory;
import com.mycompany.poc.events.LongEventHandler;
import org.hibernate.boot.model.relational.QualifiedName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Configuration
public class LongEventDistrupterConfiguration {

    @Bean(name = "LongEventDistruptor")
    public Disruptor<LongEvent> getLongEventDistruptor(){
        YieldingWaitStrategy yieldingWaitStrategy = new YieldingWaitStrategy();
        LiteTimeoutBlockingWaitStrategy liteTimeoutBlockingWaitStrategy = new LiteTimeoutBlockingWaitStrategy(1000, TimeUnit.MILLISECONDS);
        EventFactory<LongEvent> eventFactory = new LongEventFactory();
        BlockingWaitStrategy blockingWaitStrategy = new BlockingWaitStrategy();
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory,16, Executors.defaultThreadFactory(), ProducerType.SINGLE,blockingWaitStrategy);
        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.start();
        return disruptor;
    }
}
