package malla.dipesh.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import malla.dipesh.rabbitmq.dto.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQConsumer {

    @RabbitListener(queues = "${rabbitmq.queues.name}")
    public void consumeMessage(String message) {
        log.info("Message received from RabbitMQ: {}", message);
    }

//    @RabbitListener(queues = "${rabbitmq.queues.json.name}")
//    public void consumeJsonMessage(User user) {
//        log.info("JSON Message received from RabbitMQ: {}", user);
//    }
}
