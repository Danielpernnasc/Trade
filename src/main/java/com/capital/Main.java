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

        System.out.println("Iniciando programa...");
        String caseName;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o case (ex: case1 ao case9 ou allcases): ");
            caseName = scanner.nextLine().trim().toLowerCase();
        }

        Gson gson = new Gson();
        try (FileReader reader = new FileReader("capital.json")) {
            JsonObject allCases = gson.fromJson(reader, JsonObject.class);

            if (caseName.equals("allcases")) {
                for (String currentCaseName : allCases.keySet()) {
                    processCase(gson, allCases, currentCaseName);
                }
            } else if (allCases.has(caseName)) {
                processCase(gson, allCases, caseName);
            } else {
                System.out.println("Case inválido.");
            }
        }
    }

    private static void processCase(Gson gson, JsonObject allCases, String caseName) {
        System.out.println("==== " + caseName + " ====");
        JsonArray caseArray = allCases.getAsJsonArray(caseName);
        List<Operation> operations = gson.fromJson(caseArray, new com.google.gson.reflect.TypeToken<List<Operation>>(){}.getType());

        TaxaCalculator calculator = new TaxaCalculator();
        Collection<Result> resultados = calculator.calculateTaxes(operations);

        System.out.println(gson.toJson(resultados));
        System.out.println();
    }
}
