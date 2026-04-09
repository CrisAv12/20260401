package com.pepe.inventario.Configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import principalcomunes.OrdenEvent;

@Component
public class KafkaOrdenEventConsumidor {
    private static final Logger logger = LoggerFactory.getLogger(KafkaOrdenEventConsumidor.class);
    //El topic debe ser el mismo, pero el groupId no, porque se repartirian los mensajes entre producto
    // e invemntatio
    //línea que suscribe al  brojker de Kafka
    @KafkaListener(topics = "orden-event", groupId = "inventario-group")
    public void consumeOrdenEvent(OrdenEvent ordenEvent) {
        System.out.println("Recibiendo Orden Event al igual que producto del broker de Kafka: " + ordenEvent);

        logger.info("Recibiendo orden event de Kafka: "+ordenEvent);
        // La lógica principal del "qué hacer con cada objeto" se podría acá.

    }

}
