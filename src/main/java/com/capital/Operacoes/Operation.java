package com.capital.Operacoes;

import com.google.gson.annotations.SerializedName;

public class Operation {

    public static final int CustoUnitario = 0;
    public String operation;
    public int quantity;
    
    @SerializedName("unit-cost")
    public double unitCost;

    public Operation(){}

    public Operation(String operation, int quantity, double unitCost) {
        this.operation = operation;
        this.quantity = quantity;
        this.unitCost = unitCost;
    }

}
