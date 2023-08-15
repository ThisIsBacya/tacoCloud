package com.example.tacocloud.controller;

import com.example.tacocloud.model.Taco;
import com.example.tacocloud.model.TacoOrder;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@Slf4j
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    @GetMapping("/current")
    public String showOrderForm() {
        return "orderForm";
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder, SessionStatus sessionStatus,
                               Errors errors) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        log.info("Order submitted: {}", tacoOrder);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
