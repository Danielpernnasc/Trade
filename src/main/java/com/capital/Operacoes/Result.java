package com.capital.Operacoes;

public class Result {
    private double tax;
    private String description;

    public Result(double tax, String description) {
        this.tax = tax;
        this.description = description;
    }

    public double getTax(){
        return tax;
    }

    public String getDescription(){
        return description;
    }

}
