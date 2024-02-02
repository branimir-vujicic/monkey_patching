package com.axiomq.monkey_patching.aop;

import com.axiomq.monkey_patching.services.MoneyConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class LoggingAspectIntegrationTest {

    @Autowired
    private MoneyConverter moneyConverter;

    @Test
    public void whenMethodCalled_thenSurroundedByLogs() {
        ByteArrayOutputStream logOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(logOutputStream));

        double result = moneyConverter.convertEURtoUSD(10);

        assertEquals(11, result);
        String logOutput = logOutputStream.toString();

        System.err.println(logOutput);

        assertTrue(logOutput.contains("Before method AOP: convertEURtoUSD"));
        assertTrue(logOutput.contains("After method  AOP: convertEURtoUSD"));
    }

}
