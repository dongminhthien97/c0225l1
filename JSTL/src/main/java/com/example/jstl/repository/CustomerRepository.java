package com.example.jstl.repository;

import com.example.jstl.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();
    static{
        customerList.add(new Customer("Mai Van Hoan","1983-08-20","Ha Noi"));
        customerList.add(new Customer("Nguyen Van Nam","1983-08-21","Bac Giang"));
        customerList.add(new Customer(" Nguyen Thai Hoa","1983-08-22","Nam Dinh"));
        customerList.add(new Customer("Tran Dang Khoa","1983-08-17","Ha Tay"));
        customerList.add(new Customer("Nguyen Dinh Thi","1983-08-11","Ha Noi"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }
}
