package com.axiomq.monkey_patching.decorator;

import com.axiomq.monkey_patching.services.MoneyConverter;

public class MoneyConverterDecorator implements MoneyConverter {

    private final MoneyConverter moneyConverter;

    public MoneyConverterDecorator(MoneyConverter moneyConverter) {
        this.moneyConverter = moneyConverter;
    }

    @Override
    public double convertEURtoUSD(double amount) {

        System.out.println("Before method Decorator: convertEURtoUSD");
        double result = moneyConverter.convertEURtoUSD(amount);
        System.out.println("After method Decorator: convertEURtoUSD");
        return result;

    }

    @Override
    public void test() {
        moneyConverter.test();
    }

}
