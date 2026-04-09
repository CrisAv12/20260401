package principal.Configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import principalcomunes.OrdenEvent;

@Component
public class OrdenEventListener {
    private static final Logger logger = LoggerFactory.getLogger(OrdenEventListener.class);
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void handleOrdenEvent(OrdenEvent event){
        System.out.println("Orden recibida por RabbitMQ: "+event);

        logger.info("Orden recibida por Rabbit MQ: "+event);
        //Acá se implementa la lógica para utilizar al objeto de tipo OrdenEvent como se necesite
    }
}
