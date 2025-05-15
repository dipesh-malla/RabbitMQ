package malla.dipesh.rabbitmq.controller;

import malla.dipesh.rabbitmq.dto.User;
import malla.dipesh.rabbitmq.producer.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class JsonMessageController {

    private final RabbitMQJsonProducer rabbitMQProducer;

    public JsonMessageController(RabbitMQJsonProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }


    @GetMapping("/publishJson")
    public ResponseEntity<User> publishJson(
            @RequestBody User user
    ) {
        rabbitMQProducer.sendJsonMessage(user);
        return ResponseEntity.ok(user);
    }

}
