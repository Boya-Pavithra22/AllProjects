package com.kafkaservices;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
/*
 * @KafkaListener listens to the test-topic and consumes messages.

The received message is printed to the console.
 */
@Service
public class KafkaConsumerService {
/*
 * KafkaListener annotation registers the method as a Kafka message listener.

topics = "test-topic" means it listens to messages from the Kafka topic named "test-topic".
groupId = "my-group" means this listener belongs to the consumer group "my-group".

Kafka ensures that messages from the topic are distributed among consumers in the same group 
(for load balancing).
If you have multiple instances of this consumer with the same groupId, they will share the topic partitions.
 */
    @KafkaListener(topics = "test-topic", groupId = "my-group")
    
    /*
     * This method is triggered whenever a message is published to the topic "test-topic".

The message parameter is automatically filled with the incoming Kafka message value (String in this case).

Each time a new message arrives, it calls listen() and prints it out.
     */
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
