package com.axiomq.monkey_patching.config;

import com.axiomq.monkey_patching.decorator.MoneyConverterDecorator;
import com.axiomq.monkey_patching.proxy.LoggingInvocationHandler;
import com.axiomq.monkey_patching.services.MoneyConverter;
import com.axiomq.monkey_patching.services.MoneyConverterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class Config {

    @Bean(name = "moneyConverter")
    public MoneyConverter moneyConverter() {
        return new MoneyConverterImpl();
    }

    @Bean(name = "moneyConverterDecorator")
    public MoneyConverter moneyConverterDecorator(MoneyConverter moneyConverter) {
        return new MoneyConverterDecorator(moneyConverter);
    }

    @Bean(name = "moneyConverterProxy")
    public MoneyConverter moneyConverterProxy(MoneyConverter moneyConverter) {
        return (MoneyConverter) Proxy.newProxyInstance(
                MoneyConverter.class.getClassLoader(),
                new Class[]{MoneyConverter.class},
                new LoggingInvocationHandler(moneyConverter)
        );
    }

}
