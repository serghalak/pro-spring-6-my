package com.apress.prospring6.two.decoupled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {

    private String message;

    //@Autowired
    public HelloWorldMessageProvider(/*@Value("Configurable message")*/ String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message; /*"Hello World!";*/
    }
}
