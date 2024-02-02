package com.axiomq.monkey_patching.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingInvocationHandler implements InvocationHandler {

    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method Proxy: " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("After method Proxy: " + method.getName());
        return result;
    }

}
