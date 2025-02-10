package com.example.codingtest.service;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class KafkaProducerService {
    private final Producer<String, String> producer;
    private final String topic = "kafka-test";

    public KafkaProducerService(
            @Value("${kafka.bootstrap-servers}") String bootstrapServers,
            @Value("${kafka.username}") String username,
            @Value("${kafka.password}") String password) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.mechanism", "PLAIN");
        props.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"" + username + "\" password=\"" + password + "\";");
        props.put("basic.auth.credentials.source", "USER_INFO");

        this.producer = new KafkaProducer<>(props);
    }

    public void sendMessage(String key, String message) {
        producer.send(new ProducerRecord<>(topic, key, message));
    }
}
