package com.qjj.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class CostomProducer {

    public static void main(String[] args) {
        Properties props = new Properties();

        //kafka服务端的主机名和商品号
        props.put("bootstrap.servers","hadoop102:9092");
        //等待所有副本节点的内容
        props.put("acks","all");
        //消息发送最大尝试次数
        props.put("retries",0);
        //一批消息处理大小
        props.put("batch.size",16384);
        //请求延时
        props.put("linger.ms",1);
        //发送缓存区内存大小
        props.put("buffer.memory",22554432);
        //key 序列化
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //value序列化
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        
        KafkaProducer<String,String> producerv = new KafkaProducer<String, String>(props);
        for (int i = 0 ; i<50 ;i++){
        	producerv.send(new ProducerRecord<String, String>("test1", Integer.toString(i)," hello word - " + i));
        }

        producerv.close();

    }


}
