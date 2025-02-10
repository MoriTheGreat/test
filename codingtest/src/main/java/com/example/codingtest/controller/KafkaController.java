package com.example.codingtest.controller;

import com.example.codingtest.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/send")
    public String sendMessage(@RequestParam String key, @RequestParam String message) {
        kafkaProducerService.sendMessage(key, message);
        return "Message sent to Kafka topic";
    }
}
