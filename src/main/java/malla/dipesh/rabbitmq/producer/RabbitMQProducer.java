package malla.dipesh.rabbitmq.producer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQProducer {


    private  final RabbitTemplate rabbitTemplate;



    @Value("${rabbitmq.exchanges.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;


    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void sendMessage(String message) {
        log.info("Sending message: {}", message);
         rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }
}
