package com.capital;

import com.capital.Operacoes.Operation;
import com.capital.Operacoes.Result;
import com.capital.Operacoes.TaxaCalculator;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import java.util.Collection;



public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando programa..."); // <-- Aqui
        String caseName;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o case (ex: case1 ao case9): ");
            caseName = scanner.nextLine();
        }
        Gson gson = new Gson();
      
       try (FileReader reader = new FileReader("capital.json"))  {
           JsonObject allCases = gson.fromJson(reader, JsonObject.class);

           if (!allCases.has(caseName)) {
               System.out.println("Case not found!");
               return;
           }

           // Removido o caseArray porque não está sendo usado
           JsonArray caseArray = allCases.getAsJsonArray(caseName);
           List<Operation> operations = gson.fromJson(caseArray, new TypeToken<List<Operation>>() {
           }.getType());
    
           System.out.println("Operations Reads: " + operations.size());
           for (Operation op : operations) {
               System.out.println(op.operation + " " + op.quantity + " " + op.unitCost);
           }

           TaxaCalculator calculator = new TaxaCalculator();
           Collection<Result> resultados  = calculator.calculateTaxes(operations);

            System.out.println(gson.toJson(resultados));
           
    
        }
   
    }
}