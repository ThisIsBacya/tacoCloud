package com.example.tacocloud.controller;

import com.example.tacocloud.model.TacoOrder;
import com.example.tacocloud.rabbitmq.RabbitOrderMessagingService;
import com.example.tacocloud.repository.OrderRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/orders", produces = "application/json")
@CrossOrigin(origins = "http://tacocloud:8000")
public class OrderApiController {

    private OrderRepository orderRepository;
    private RabbitOrderMessagingService rabbitOrderMessagingService;

    public OrderApiController(OrderRepository orderRepository, RabbitOrderMessagingService rabbitOrderMessagingService) {
        this.orderRepository = orderRepository;
        this.rabbitOrderMessagingService = rabbitOrderMessagingService;
    }

    @GetMapping(produces = "application/json")
    public Iterable<TacoOrder> allOrders() {
        return orderRepository.findAll();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TacoOrder postTaco(@RequestBody TacoOrder tacoOrder) {
        rabbitOrderMessagingService.sendOrder(tacoOrder);
        return orderRepository.save(tacoOrder);
    }

    @PutMapping(path = "/{OrderId}", consumes = "application/json")
    public TacoOrder putOrder(
            @PathVariable("orderId") Long orderId,
            @RequestBody TacoOrder tacoOrder) {
        tacoOrder.setId(orderId);
        return orderRepository.save(tacoOrder);
    }

    @PatchMapping(path = "/{OrderId}", consumes = "application/json")
    public TacoOrder patchOrder(@PathVariable("orderId") Long orderId,
                                @RequestBody TacoOrder patch) {
        TacoOrder tacoOrder = orderRepository.findById(String.valueOf(orderId)).get();

        if (patch.getDeliveryName() != null) {
            tacoOrder.setDeliveryName(patch.getDeliveryName());
        }
        if (patch.getDeliveryStreet() != null) {
            tacoOrder.setDeliveryCity(patch.getDeliveryCity());
        }
        if (patch.getDeliveryCity() != null) {
            tacoOrder.setDeliveryCity(patch.getDeliveryCity());
        }
        if (patch.getDeliveryState() != null) {
            tacoOrder.setDeliveryState(patch.getDeliveryState());
        }
        if (patch.getDeliveryZip() != null) {
            tacoOrder.setDeliveryZip(patch.getDeliveryZip());
        }
        if (patch.getCcNumber() != null) {
            tacoOrder.setCcNumber(patch.getCcNumber());
        }
        if (patch.getCcExpiration() != null) {
            tacoOrder.setCcExpiration(patch.getCcExpiration());
        }
        if (patch.getCcCVV() != null) {
            tacoOrder.setCcCVV(patch.getCcCVV());
        }


        return orderRepository.save(tacoOrder);

    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable ("orderId") Long orderId) {
        try {
            orderRepository.deleteById(String.valueOf(orderId));

        }
        catch (EmptyResultDataAccessException e) {}
    }
}
