package com.adelmo.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by znb on 17-7-16.
 */
public class KafkaConsumerDemo {

    Properties properties;

    public KafkaConsumerDemo(Properties properties) {
        super();
        this.properties = properties;
    }

    public KafkaConsumerDemo() {
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String receive() {

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Arrays.asList(properties.getProperty("topic")));

        String message = "";
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> consumerRecord : records) {
                message += consumerRecord.value();
            }
            consumer.close();
            return message;
        }
    }
}
