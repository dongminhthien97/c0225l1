package com.example.jstl.repository;

import com.example.jstl.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
}
