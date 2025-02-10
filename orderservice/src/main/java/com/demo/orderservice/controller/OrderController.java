package com.demo.orderservice.controller;


import com.demo.commons.model.Order;
import com.demo.commons.model.OrderEvent;
import com.demo.orderservice.kafka.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderProducer orderProducer;

    @PostMapping("/place")
    public String placeOrder(@RequestBody Order order){

        String orderID = UUID.randomUUID().toString();
        order.setOrderId(orderID);

        OrderEvent event = new OrderEvent(
                "Order is pending",
                "PENDING",
                order);
        orderProducer.sendMessage(event);
        return String.format("Order %s has been created successfully",orderID);
    }


}
