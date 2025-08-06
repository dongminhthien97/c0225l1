package com.example.jstl.service;

import com.example.jstl.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
