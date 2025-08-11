package com.kafkaservices;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
 * KafkaTemplate is used to send messages to Kafka.

sendMessage method sends the message to the test-topic.
 */
@Service
public class KafkaProducerService {

	//KafkaTemplate is Spring Kafka’s helper class to send messages to Kafka topics.
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /*
     * The Kafka topic name where messages will be sent.

It’s a constant because you want all messages to go to this specific topic.
     */
    private static final String TOPIC = "test-topic";

    //When you call sendMessage("hello"), it publishes "hello" to Kafka topic "test-topic".
    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
