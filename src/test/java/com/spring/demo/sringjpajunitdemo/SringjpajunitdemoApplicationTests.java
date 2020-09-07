package com.spring.demo.sringjpajunitdemo;

import com.spring.demo.sringjpajunitdemo.model.Customer;
import com.spring.demo.sringjpajunitdemo.repository.CustomerRepo;
import com.spring.demo.sringjpajunitdemo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = SringjpajunitdemoApplication.class)
@Slf4j
class SringjpajunitdemoApplicationTests {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerService customerService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetCustomerById(){
        List<String> strings = customerService.addCustomer(Arrays.asList(new Customer(null, "pkp", "abc")));
        Customer byId = customerRepo.findById(1);
        log.info("Customer : {}", byId);
        Assertions.assertTrue(byId.getFirstName().length() > 0);
    }

    @Test
    public void testUpdateFirstName(){
        List<String> strings = customerService.addCustomer(Arrays.asList(new Customer(null, "pkp", "abc")));
        Customer byId = customerRepo.findById(1);
        log.info("Customer : {}", byId);
        Integer status = customerRepo.updateFirstName(Long.valueOf(1), "pkp1");
        byId = customerRepo.findById(1);
        log.info("Status after update : {} ,  Value : {}", status, byId);
        Assertions.assertTrue(byId.getFirstName().length() > 0);
    }

}
