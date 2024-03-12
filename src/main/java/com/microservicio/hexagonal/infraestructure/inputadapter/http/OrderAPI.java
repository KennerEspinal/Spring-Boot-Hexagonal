package com.microservicio.hexagonal.infraestructure.inputadapter.http;

import com.microservicio.hexagonal.domain.Orders;
import com.microservicio.hexagonal.infraestructure.inputport.OrdersInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "orders")
public class OrderAPI {
    @Autowired
    OrdersInputPort ordersInputPort;

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Orders create(@RequestParam String customerId, @RequestParam BigDecimal total){
        return ordersInputPort.createOrder(customerId, total);
    }
}
