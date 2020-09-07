package com.spring.demo.sringjpajunitdemo.service;

import com.spring.demo.sringjpajunitdemo.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> fetchAllCustomers();
    List<Customer> fetchCustomerByLastName(String lastName);
    Customer fetchCustomerById(Long id);
    List<String> addCustomer(List<Customer> customers);

}
