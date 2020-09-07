package com.spring.demo.sringjpajunitdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotBlank
    @Size(min = 0, max = 20)
    private String firstName;
    @NotBlank
    @Size(min = 0, max = 20)
    private String lastName;
}
