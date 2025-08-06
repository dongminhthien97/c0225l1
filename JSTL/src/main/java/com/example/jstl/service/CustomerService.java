package com.example.jstl.service;

import com.example.jstl.model.Customer;
import com.example.jstl.repository.CustomerRepository;
import com.example.jstl.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
