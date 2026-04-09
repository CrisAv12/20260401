package principal.Configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import principalcomunes.OrdenEvent;

@Component
public class KafkaOrdenEventConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaOrdenEventConsumer.class);
    @KafkaListener(topics = "orden-event", groupId = "producto-group")
    public void consumeOrdenEvent(OrdenEvent ordenEvent) {
        System.out.println("Recibiendo Orden Event del broker de Kafka: " + ordenEvent);

        logger.info("Recibiendo orden event de Kafka: "+ordenEvent);
        // La lógica principal del "qué hacer con cada objeto" se podría acá.

    }
}
