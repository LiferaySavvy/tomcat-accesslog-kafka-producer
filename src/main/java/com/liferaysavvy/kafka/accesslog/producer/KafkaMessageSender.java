
package com.liferaysavvy.kafka.accesslog.producer;

import com.liferaysavvy.kafka.accesslog.config.KafkaConfig;
import com.liferaysavvy.kafka.accesslog.constants.KafkaConstants;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaMessageSender {
    public void sendMessage(String message) {
        final Producer<String, String> kafkaProducer = KafkaConfig.getProducer();
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(KafkaConstants.TOPIC, message);
        kafkaProducer.send(record);
        kafkaProducer.flush();
        kafkaProducer.close();
    }
}
