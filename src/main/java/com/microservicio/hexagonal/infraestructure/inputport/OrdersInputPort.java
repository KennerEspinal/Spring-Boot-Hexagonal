package com.microservicio.hexagonal.infraestructure.inputport;

import com.microservicio.hexagonal.domain.Orders;

import java.math.BigDecimal;

public interface OrdersInputPort {
    public Orders createOrder(String customerId, BigDecimal total);
}
