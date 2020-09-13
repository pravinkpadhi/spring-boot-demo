package com.spring.demo.sringjpajunitdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.spring.demo.sringjpajunitdemo.base.JunitTestBase;
import com.spring.demo.sringjpajunitdemo.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class CustomerControllerTest extends JunitTestBase{

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Test
    public void testAddCustomer() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson=objectWriter.writeValueAsString(Arrays.asList(new Customer(1l, "MockController", "MockController")));
        String responseJson = objectWriter.writeValueAsString(Arrays.asList("MockController MockController"));
        mockMvc.perform(post("/newCustomers")
                            .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestJson))
                            .andDo(print())
                            .andExpect(status().isOk())
                            .andExpect(content().json(responseJson));

    }

}
