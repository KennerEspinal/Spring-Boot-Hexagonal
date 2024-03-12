package com.microservicio.hexagonal.infraestructure.inputadapter.http;

import com.microservicio.hexagonal.domain.Customer;
import com.microservicio.hexagonal.infraestructure.inputport.CustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "customer")
public class CustomerAPI {

    @Autowired
    CustomerInputPort customerInputPort;

    @PostMapping(value = "create", produces= MediaType.APPLICATION_JSON_VALUE)
    public Customer create(@RequestParam String name, @RequestParam String country ) {
        return customerInputPort.createCustomer(name, country);
    }

    @PostMapping(value = "get", produces=MediaType.APPLICATION_JSON_VALUE)
    public Customer get( @RequestParam String customerId ) {
        return customerInputPort.getCustomerById(customerId);
    }

    @PostMapping(value = "getall", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getAll() {
        return customerInputPort.getAllCustomers();
    }
}
