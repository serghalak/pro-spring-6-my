package com.apress.prospring5.ch3.annotated;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;

@Configuration
@ComponentScan()
public class LookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(LookupDemo.class);

        DemoBean abstractBean = ctx.getBean("abstractLookupDemoBean", DemoBean.class);
        DemoBean standardBean = ctx.getBean("standardLookupDemoBean", DemoBean.class);
        displayInfo("abstractLookupBean", abstractBean);
        displayInfo("standardLookupBean", standardBean);

    }

    public static void displayInfo(String beanName, DemoBean bean) {
        Singer singer1 = bean.getMySinger();
        Singer singer2 = bean.getMySinger();
        System.out.println("" + beanName + ": "
                + "Singer Instances the Same? "
                + (singer1 == singer2));
    }
}
