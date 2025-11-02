package com.apress.prospring6.two;

import com.apress.prospring6.two.decoupled.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        MessageRenderer mr = new StandardOutMessageRenderer();
//        MessageProvider mp = new HelloWorldMessageProvider();
//        mr.setMessageProvider(mp);
//        mr.render();
//        MessageSupportFactory msf = MessageSupportFactory.getInstance();
//        MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer()
//                .orElseThrow(() -> new IllegalArgumentException("Service of type 'MessageRenderer' was not found"));
//        MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider()
//                .orElseThrow(() -> new IllegalArgumentException("Service of type 'MessageProvider' was not found"));
//        mr.setMessageProvider(mp);
//        mr.render();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();

    }
}
