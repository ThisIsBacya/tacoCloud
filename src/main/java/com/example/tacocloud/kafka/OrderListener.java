package com.example.tacocloud.kafka;

import com.example.tacocloud.kafka.KitchenUI;
import com.example.tacocloud.model.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderListener {
    private KitchenUI kitchenUI;

    @Autowired
    public OrderListener(KitchenUI kitchenUI) {
        this.kitchenUI = kitchenUI;
    }
//
//    @KafkaListener(topics = "tacocloud.order.topic")
//    public void handle(TacoOrder order) {
//        kitchenUI.displayOrder(order);
//    }

    @KafkaListener(topics = "tacocloud.order.topic")
    public void handle(TacoOrder order, ConsumerRecord<String, TacoOrder> record) {
        log.info("Received from partition {} with timestamp {}", record.partition(),
                record.timestamp());
        kitchenUI.displayOrder(order);
    }
}
