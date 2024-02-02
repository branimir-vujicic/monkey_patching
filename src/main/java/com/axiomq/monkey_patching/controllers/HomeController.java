package com.axiomq.monkey_patching.controllers;

import com.axiomq.monkey_patching.services.MoneyConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class HomeController {

    private final MoneyConverter moneyConverter;
    private final MoneyConverter moneyConverterDecorator;
    private final MoneyConverter moneyConverterProxy;

    public HomeController(MoneyConverter moneyConverter, MoneyConverter moneyConverterDecorator, MoneyConverter moneyConverterProxy) {
        this.moneyConverter = moneyConverter;
        this.moneyConverterDecorator = moneyConverterDecorator;
        this.moneyConverterProxy = moneyConverterProxy;
    }

    @GetMapping("/aop")
    public void aop() {

        moneyConverter.convertEURtoUSD(100);

    }

    @GetMapping("/decorator")
    public void decorator() {

        moneyConverterDecorator.convertEURtoUSD(100);

    }

    @GetMapping("/proxy")
    public void proxy() {

        moneyConverterProxy.convertEURtoUSD(100);

    }

}
