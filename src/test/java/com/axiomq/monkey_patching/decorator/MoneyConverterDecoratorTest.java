package com.axiomq.monkey_patching.decorator;

import com.axiomq.monkey_patching.services.MoneyConverter;
import com.axiomq.monkey_patching.services.MoneyConverterImpl;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class MoneyConverterDecoratorTest {


        @Test
        public void whenMethodCalled_thenSurroundedByLogs() {
            ByteArrayOutputStream logOutputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(logOutputStream));
            MoneyConverter moneyConverter = new MoneyConverterDecorator(new MoneyConverterImpl());

            double result = moneyConverter.convertEURtoUSD(10);

            assertEquals(11, result);
            String logOutput = logOutputStream.toString();

            System.err.println(logOutput);

            assertTrue(logOutput.contains("Before method Decorator: convertEURtoUSD"));
            assertTrue(logOutput.contains("After method Decorator: convertEURtoUSD"));
        }
}
