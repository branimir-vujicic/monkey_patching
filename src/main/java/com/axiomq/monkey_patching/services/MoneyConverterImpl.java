package com.axiomq.monkey_patching.services;

public class MoneyConverterImpl implements MoneyConverter {

    private final double conversionRate;

    public MoneyConverterImpl() {
        this.conversionRate = 1.10;
    }

    public MoneyConverterImpl(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    @Override
    public double convertEURtoUSD(double amount) {
        return amount * conversionRate;
    }

    @Override
    public void test() {

    }

}
