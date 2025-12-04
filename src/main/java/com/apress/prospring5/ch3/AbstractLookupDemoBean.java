package com.apress.prospring5.ch3;

public abstract class AbstractLookupDemoBean implements DemoBean {

    @Override
    public abstract Singer getMySinger();

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
