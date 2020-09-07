package com.spring.demo.sringjpajunitdemo.repository;

import com.spring.demo.sringjpajunitdemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);

    /*
    * U need to mention entity name in jpql not table name
    * In addition to that that, field names should be entity variable name, not column name of the table
    * Jpa will generate sql query for you internally and call db. Intelligent piece of framework :)
    * */
    @Transactional
    @Modifying
    @Query("update Customer set firstName = :firstName where id = :id")
    Integer updateFirstName(@Param("id")Long id, @Param("firstName") String firstName);

}
