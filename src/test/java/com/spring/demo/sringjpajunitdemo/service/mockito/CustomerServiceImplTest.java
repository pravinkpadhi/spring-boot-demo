package com.spring.demo.sringjpajunitdemo.service.mockito;

import com.spring.demo.sringjpajunitdemo.base.JunitTestBase;
import com.spring.demo.sringjpajunitdemo.model.Customer;
import com.spring.demo.sringjpajunitdemo.repository.CustomerRepo;
import com.spring.demo.sringjpajunitdemo.service.impl.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class CustomerServiceImplTest extends JunitTestBase {

    @Mock
    private CustomerRepo customerRepo;

    @InjectMocks
    private CustomerServiceImpl customerService;

    /*
    This method runs before any mocked method.
    Mostly initialization like define a mock json or object and use in all test methods.
     */
    @BeforeEach
    public void initializeMockito(){
        log.info("Initializing mockito");
    }

    @Test
    public void testFetchAllCustomers(){

        Mockito.when(customerRepo.findAll()).thenReturn(Arrays.asList(new Customer(1l, "MockedFirstName", "MockedLastName")));
        List<Customer> customers = customerService.fetchAllCustomers();
        Assertions.assertSame("MockedFirstName", customers.get(0).getFirstName());
    }

    @Test
    public void testFetchCustomerByLastName(){
        Mockito.when(customerRepo.findByLastName(Mockito.anyString())).thenReturn(Arrays.asList(new Customer(1l, "MockedFirstName", "MockedLastName")));
        List<Customer> customers = customerService.fetchCustomerByLastName("MockedLastName");
        Assertions.assertSame("MockedLastName", customers.get(0).getLastName());
    }

    @Test
    public void testFetchCustomerById(){
        Mockito.when(customerRepo.findById(Mockito.anyLong())).thenReturn(new Customer(1l, "MockedFirstName", "MockedLastName"));
        Customer customer = customerService.fetchCustomerById(1l);
        Assertions.assertSame(1l, customer.getId());
    }

    @Test
    public void testAddCustomer(){
        Mockito.when(customerRepo.saveAll(Mockito.any())).thenReturn(Arrays.asList(new Customer(1l, "MockedFirstName", "MockedLastName")));
        List<String> customers = customerService.addCustomer(new ArrayList<>());
        Assertions.assertTrue("MockedFirstName MockedLastName".equalsIgnoreCase(customers.get(0)));
    }
}
