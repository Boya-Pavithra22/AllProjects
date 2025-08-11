package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaservices.KafkaProducerService;
///send endpoint takes a query parameter (message) and sends it to Kafka using the KafkaProducerService.
@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        kafkaProducerService.sendMessage(message);// forwards the message to Kafka asynchronously via KafkaProducerService.
        return "Message sent to Kafka: " + message;
    }
}
