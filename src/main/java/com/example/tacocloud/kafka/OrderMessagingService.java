package com.example.tacocloud.kafka;

import com.example.tacocloud.model.TacoOrder;

public interface OrderMessagingService {
    void sendOrder(TacoOrder order);
}
