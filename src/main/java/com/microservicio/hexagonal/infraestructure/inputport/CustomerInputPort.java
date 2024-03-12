package com.microservicio.hexagonal.infraestructure.inputport;

import com.microservicio.hexagonal.domain.Customer;

import java.util.List;

public interface CustomerInputPort {
    public Customer createCustomer(String name, String country);
    public Customer getCustomerById(String customerId);
    public List<Customer> getAllCustomers();
}
