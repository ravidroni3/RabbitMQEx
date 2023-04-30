package com.spring.controller;

import com.spring.dto.Employee;
import com.spring.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class JsonController {

    private RabbitMQJsonProducer rabbitMQJsonProducer;

    public JsonController(RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Employee employee) {
        rabbitMQJsonProducer.sendJsonMessage(employee);
        return ResponseEntity.ok("Json message sent to RabbitMQ");
    }
}
