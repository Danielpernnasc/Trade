package com.capital.Operacoes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;




// Removed incorrect import
// Define a custom Result class or import the correct one

public class TaxaCalculator {

    public Collection<com.capital.Operacoes.Result> calculateTaxes(List<Operation> operations){
        List<Result> results = new ArrayList<>();


        int totalQuantidade= 0;
        double CustoVariado = 0.0;
        double acumuloPerda = 0.0;

        for (Operation op: operations){
            if (op.operation.equals("buy")) {
                double totalCusto = CustoVariado * totalQuantidade + op.unitCost * op.quantity;
                totalQuantidade += op.quantity;
                CustoVariado = totalCusto / totalQuantidade;
                results.add(new Result(0.0, "By of active no pay taxes on buy operations"));
            }else if (op.operation.equals("sell")) {
                double totalVendasValor = op.unitCost * op.quantity;
                double totalCustoBase = CustoVariado * op.quantity;
                double lucro = totalVendasValor - totalCustoBase;

                System.out.println("Venda: valor=" + totalVendasValor + ", custo=" + totalCustoBase + ", lucro=" + lucro
                        + ", acumuloPerda=" + acumuloPerda);

                if (lucro < 0) {
                    acumuloPerda += -lucro;
                    results.add(new Result(0.0,
                            "Prejuízo: nenhum imposto pago, prejuízo acumulado para compensar lucros futuros"));
                } else if (totalVendasValor <= 20000.0) {
                    results.add(new Result(0.0, "Valor total da venda menor ou igual a R$ 20000: isento de imposto"));
                } else {
                    double taxa = Math.max(lucro - acumuloPerda, 0.0);
                    acumuloPerda = Math.max(0, acumuloPerda - lucro);
                    results.add(new Result(taxa * 0.20, "Imposto de 20% sobre o lucro após compensar prejuízos"));
                }

                totalQuantidade -= op.quantity;
            }
           
        }

        return results;
    }

}
