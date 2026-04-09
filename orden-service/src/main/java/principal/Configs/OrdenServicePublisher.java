package principal.Configs;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import principalcomunes.OrdenEvent;

//import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class OrdenServicePublisher {
    private final RabbitTemplate rabbitTemplate;

    private static final Logger logger = LoggerFactory.getLogger(OrdenServicePublisher.class);

    public  void publicarOrdenEvent(OrdenEvent event){
        System.out.println("OrdenEvent a ser publicado: "+event);
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ROUTING_KEY,
                event
        );

        logger.info("Orden event a ser publicado en RabbitMQ "+event);
    }
}
