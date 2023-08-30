package com.example.tacocloud.kafka;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import com.example.tacocloud.model.TacoOrder;

@Component
@Slf4j
public class KitchenUI {

    public void displayOrder(TacoOrder order) {
        log.info("RECEIVED ORDER:  " + order);
    }

}