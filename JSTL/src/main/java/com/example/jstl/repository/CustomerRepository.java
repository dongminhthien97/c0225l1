package com.example.jstl.repository;

import com.example.jstl.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();
    static{
        customerList.add(new Customer("Mai Van Hoan","1983-08-20","Ha Noi","images/1.jpg"));
        customerList.add(new Customer("Nguyen Van Nam","1983-08-21","Bac Giang","images/2.jpg"));
        customerList.add(new Customer(" Nguyen Thai Hoa","1983-08-22","Nam Dinh","images/3.jpg"));
        customerList.add(new Customer("Tran Dang Khoa","1983-08-17","Ha Tay","images/4.jpg"));
        customerList.add(new Customer("Nguyen Dinh Thi","1983-08-11","Ha Noi","images/5.jpg"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }
}
