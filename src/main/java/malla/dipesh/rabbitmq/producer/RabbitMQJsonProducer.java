package malla.dipesh.rabbitmq.producer;

import lombok.extern.slf4j.Slf4j;
import malla.dipesh.rabbitmq.dto.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchanges.name}")
    private String exchangeName;

    @Value("${rabbitmq.json.routing.key}")
    private String routingJsonKey;

    private final RabbitTemplate rabbitTemplate;


    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user ) {
        rabbitTemplate.convertAndSend(exchangeName, routingJsonKey, user);
        log.info("Message sent to exchange for json {}", exchangeName);
    }

}
