package com.mycompany.poc.web.rest;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.mycompany.poc.events.LongEvent;
import com.mycompany.poc.events.LongEventFactory;
import com.mycompany.poc.events.LongEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
@RequestMapping("/api")
public class DisruptorController {

    @Autowired
    @Qualifier(value="LongEventDistruptor")
    private Disruptor<LongEvent> longEventDisruptor;


    @GetMapping("/msg")
    public String sendMessage() throws InterruptedException {

        try {

            sendMsg2(longEventDisruptor);
//            TimeUnit.SECONDS.sleep(3);
        }finally {

        }



        return "test complete";


    }

    private void sendMsg2(Disruptor<LongEvent> disruptor){

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

            for (int i =0;i<10;i++){
                long index=ringBuffer.next();

                    try {
                        LongEvent longEvent = ringBuffer.get(index);
                        longEvent.setValue(i);

                    }finally {
                        ringBuffer.publish(index);
                    }



            }


    }

    private Disruptor<LongEvent> getDisruptor() {

        YieldingWaitStrategy yieldingWaitStrategy = new YieldingWaitStrategy();
        LiteTimeoutBlockingWaitStrategy liteTimeoutBlockingWaitStrategy = new LiteTimeoutBlockingWaitStrategy(1000, TimeUnit.MILLISECONDS);
        EventFactory<LongEvent> eventFactory = new LongEventFactory();
        BlockingWaitStrategy blockingWaitStrategy = new BlockingWaitStrategy();
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory,16,Executors.defaultThreadFactory(),ProducerType.SINGLE,blockingWaitStrategy);
        disruptor.handleEventsWith(new LongEventHandler());

        return disruptor;
    }

    private void sendMsg(Disruptor<LongEvent> disruptor) {
        try {
            disruptor.start();
            RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
            Translator translator = new Translator();
            long start = System.currentTimeMillis();
            for (long i = 0; i < 10; i++) {
                long index=disruptor.getCursor();
                if(index > 4){
                    System.out.println(index);
                    break;
                }
                ringBuffer.publishEvent(translator, i);

            }
            long end = System.currentTimeMillis();
        }finally {
            disruptor.shutdown();
        }






    }

    private class Translator implements EventTranslatorVararg<LongEvent> {
        @Override
        public void translateTo(LongEvent longEvent, long l, Object... objects) {
            longEvent.setValue((long) objects[0]);
        }
    }
}
