package com.spring.demo.sringjpajunitdemo.controller;

import com.spring.demo.sringjpajunitdemo.model.Customer;
import com.spring.demo.sringjpajunitdemo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/newCustomers")
    public List<String> addCustomers(@RequestBody  @Validated List<Customer> customers){
        log.info("Start of /newCustomers");
        return customerService.addCustomer(customers);
    }

    @GetMapping("/fetchAllCustomers")
    public List<Customer> fetchAllCustomers(){
        return customerService.fetchAllCustomers();
    }

    @GetMapping("/fetchCustomerById")
    public Customer fetchCustomerById(@RequestParam("id") Long id){
        return customerService.fetchCustomerById(id);
    }

    @GetMapping("/fetchCustomerByLastName")
    public List<Customer> fetchCustomerByLastName(@RequestParam("lastName")String lastName){
        return customerService.fetchCustomerByLastName(lastName);
    }

}
