package com.spring.demo.sringjpajunitdemo.base;

import com.spring.demo.sringjpajunitdemo.SringjpajunitdemoApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SringjpajunitdemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class JunitTestBase {
}
