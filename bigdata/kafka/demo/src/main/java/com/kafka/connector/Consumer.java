package com.kafka.connector;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer {

    public static void main(String[] args){
        cosumeTopic();
    }
    
    public static void cosumeTopic(){
        //setup configuation
        Properties properties= new Properties();
        properties.put("bootstrap.servers", "localhost:9092");

        // ➢ acks=0表示生产者不需要来自服务器端的确认。➢ acks=1表示服务器端将消息保存后即可发送ack，不需要等到其他follower角色都收到该消息。➢ acks=all（或acks=-1）意味着服务器端将等待所有副本都被接收后才发送确认。
        properties.put("acks", "all");
        properties.put("group.id", "mygroup");
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", 1000);
        properties.put("buffer.memory", 33554432);
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String,String> kafkaConsumer = new KafkaConsumer<>(properties);
        kafkaConsumer.subscribe(Arrays.asList("mytopic1"));
        while(true){
            ConsumerRecords<String,String> records= kafkaConsumer.poll(Duration.ofMillis(1000));
            for(ConsumerRecord<String,String> record : records){
                    System.out.println("receive msg : "+record.key()+" = "+record.value());
            }
        }
        
    }
}
