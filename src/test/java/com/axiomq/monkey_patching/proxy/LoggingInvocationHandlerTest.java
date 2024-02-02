package com.axiomq.monkey_patching.proxy;

import com.axiomq.monkey_patching.services.MoneyConverter;
import com.axiomq.monkey_patching.services.MoneyConverterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Proxy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LoggingInvocationHandlerTest {

    @Test
    public void whenMethodCalled_thenSurroundedByLogs() {
        ByteArrayOutputStream logOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(logOutputStream));
        MoneyConverter moneyConverter = new MoneyConverterImpl();
        MoneyConverter proxy = (MoneyConverter) Proxy.newProxyInstance(
                MoneyConverter.class.getClassLoader(),
                new Class[]{MoneyConverter.class},
                new LoggingInvocationHandler(moneyConverter)
        );

        double result = proxy.convertEURtoUSD(10);

        Assertions.assertEquals(11, result);
        String logOutput = logOutputStream.toString();

        System.err.println(logOutput);

        assertTrue(logOutput.contains("Before method Proxy: convertEURtoUSD"));
        assertTrue(logOutput.contains("After method Proxy: convertEURtoUSD"));
    }
}
