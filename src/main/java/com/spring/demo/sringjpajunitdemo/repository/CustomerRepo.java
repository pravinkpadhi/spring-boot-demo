package com.spring.demo.sringjpajunitdemo.repository;

import com.spring.demo.sringjpajunitdemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);

}
