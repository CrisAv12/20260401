package principal.Configs;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import principalcomunes.OrdenEvent;

//import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class KafkaOrdenEventProducer {
    private final KafkaTemplate<String, OrdenEvent> kafkaTemplate;

    private static final Logger logger = LoggerFactory.getLogger(KafkaOrdenEventProducer.class);
    public void enviarOrdenEvent(OrdenEvent ordenEvent) {
        kafkaTemplate.send("orden-event", ordenEvent);
        System.out.println("Enviando Orden Event a Kafka: " + ordenEvent);

        logger.info("Enviando orden event a Kafka: "+ordenEvent);
    }
}
