package com.adelmo.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Created by znb on 17-7-16.
 */
public class KafkaProducerDemo {

    Logger logger = LoggerFactory.getLogger(KafkaProducerDemo.class);

    Properties properties;

    public KafkaProducerDemo(Properties properties) {
        super();
        this.properties = properties;
    }

    public KafkaProducerDemo() {
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void sendMessage(String message) {
        logger.info("KafkaProducerDemo sendMessage()");
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(properties.getProperty("topic"), message);
        producer.send(record);
        producer.close();
    }
}
