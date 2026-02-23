package com.apress.prospring6.aopmy;

import com.apress.prospring6.five.common.Guitarist;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {

    public static void main(String[] args) {
        Guitarist guitarist = new Guitarist();
        guitarist.sing("Without proxy arg1", "Without proxy arg2");
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(guitarist);
        proxyFactory.addAdvice(new SimpleBeforeAdvice());
        Guitarist proxy = (Guitarist) proxyFactory.getProxy();
        proxy.sing("New arg1", "New arg2");
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before method: '" + method.getName() + "', tune guitar.");
        System.out.println("Change args");
        args[0] = "Changed arg1";
        args[1] = "Changed arg2";
        System.out.println("Before method: '" + method.getName() + "', args: " + args[0] + ", " + args[1]);
    }
}
