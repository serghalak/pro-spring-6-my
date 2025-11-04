package com.apress.prospring6.two.annotated;

import com.apress.prospring6.two.decoupled.HelloWorldMessageProvider;
import com.apress.prospring6.two.decoupled.MessageProvider;
import com.apress.prospring6.two.decoupled.MessageRenderer;
import com.apress.prospring6.two.decoupled.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan(basePackages = "com.apress.prospring6.two")
public class HelloWorldConfiguration {

//    @Bean
//    public MessageProvider provider() {
//        return new HelloWorldMessageProvider();
//    }
//
//    @Bean
//    public MessageRenderer renderer() {
//        MessageRenderer renderer = new StandardOutMessageRenderer();
//        renderer.setMessageProvider(provider());
//        return renderer;
//    }
}
