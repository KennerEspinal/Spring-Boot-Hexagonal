package com.microservicio.hexagonal.application;

import java.math.BigDecimal;
import java.util.UUID;

import com.microservicio.hexagonal.domain.Orders;
import com.microservicio.hexagonal.infraestructure.inputport.OrdersInputPort;
import com.microservicio.hexagonal.infraestructure.outputport.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderUseCase implements OrdersInputPort {

    @Autowired
    EntityRepository entityRepository;

    @Override
    public Orders createOrder(String customerId, BigDecimal total) {
        Orders order = Orders.builder()
                .id( UUID.randomUUID().toString() )
                .customerId( customerId )
                .total( total )
                .build();

        return entityRepository.save( order );
    }

}
