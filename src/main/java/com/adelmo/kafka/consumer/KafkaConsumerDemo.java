package com.adelmo.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by znb on 17-7-16.
 */
public class KafkaConsumerDemo {

    Logger logger = LoggerFactory.getLogger(KafkaConsumerDemo.class);

    private Properties props;

    public KafkaConsumerDemo(Properties props) {
        super();
        this.props = props;
    }

    public KafkaConsumerDemo() {
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public String receive() {

        logger.info("KafkaConsumerDemo receive()");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList(props.getProperty("topic")));

        String msg = "";
        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                msg += consumerRecord.value();
            }
            consumer.close();
            return msg;
        }
    }
}
