package com.spring.demo.sringjpajunitdemo.service.impl;

import com.spring.demo.sringjpajunitdemo.model.Customer;
import com.spring.demo.sringjpajunitdemo.repository.CustomerRepo;
import com.spring.demo.sringjpajunitdemo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public List<Customer> fetchAllCustomers() {
        log.info("Started fetchAllCustomers");
        List<Customer> all = customerRepo.findAll();
        log.info("Customers: {}", all);
        return all;
    }

    @Override
    public List<Customer> fetchCustomerByLastName(String lastName) {
        log.info("Started fetchCustomerByLastName. Finding Customer details with last name : {}", lastName);
        List<Customer> details = customerRepo.findByLastName(lastName);
        log.info("Customer Details: {}", details);
        return details;
    }

    @Override
    public Customer fetchCustomerById(Long id) {
        log.info("Started fetchCustomerById. Finding Customer details with id: {}", id);
        Customer details = customerRepo.findById(id.longValue());
        log.info("Customer Details: {}", details);
        return details;
    }

    @Transactional
    @Override
    public List<String> addCustomer(List<Customer> customers) {
        log.info("Started addCustomer.");
        List<Customer> savedCustomers = customerRepo.saveAll(customers);
        log.info("Ids : {}", savedCustomers.stream().map(Customer::getId).collect(Collectors.toList()));
        List<String> names = savedCustomers
                .stream()
                .map(customer -> customer.getFirstName() + " " + customer.getLastName())
                .collect(Collectors.toList());
        log.info("Customer Details: {}", names);
        return names;
    }
}
