package com.kafka.connector;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Hello world!
 */
public final class App {


    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        //setup configuation
        Properties properties= new Properties();
        properties.put("bootstrap.servers", "localhost:9092");

        // ➢ acks=0表示生产者不需要来自服务器端的确认。➢ acks=1表示服务器端将消息保存后即可发送ack，不需要等到其他follower角色都收到该消息。➢ acks=all（或acks=-1）意味着服务器端将等待所有副本都被接收后才发送确认。
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String,String> producer = new KafkaProducer<>(properties);
        for (int i=0; i< 10; i++) {
            producer.send(new ProducerRecord<String,String>("mytopic1", "key"+1, "value"+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        producer.close();
    }
}
