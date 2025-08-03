package com.capital.Operacoes;

public class Result {
    private double tax;
 

    public Result(double tax) {
        this.tax = Math.round(tax * 100.0) / 100.0;
    }



    public double getTax(){
        return tax;
    }

   

}
