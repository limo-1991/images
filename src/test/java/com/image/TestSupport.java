package com.image;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSupport {

    protected ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
}
