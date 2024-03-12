package com.microservicio.hexagonal.application;

import java.util.List;
import java.util.UUID;

import com.microservicio.hexagonal.domain.Customer;
import com.microservicio.hexagonal.infraestructure.inputport.CustomerInputPort;
import com.microservicio.hexagonal.infraestructure.outputport.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CustomerUseCase implements CustomerInputPort {

    @Autowired
    EntityRepository entityRepository;

    @Override
    public Customer createCustomer(String name, String country) {
        Customer customer = Customer.builder()
                .id( UUID.randomUUID().toString() )
                .name( name )
                .country( country )
                .build();

        return entityRepository.save( customer );
    }

    @Override
    public Customer getCustomerById(String customerId) {
        return entityRepository.getById( customerId, Customer.class );
    }

    @Override
    public List<Customer> getAllCustomers() {
        return entityRepository.getAll( Customer.class );
    }

}