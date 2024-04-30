package com.alurachallenge.conversor.conversion;

public record Conversion(String base_code, String target_code, double conversion_result,double cantidad_a_convertir) {

    public String toString(){
        return String.format("Conversión de %.2f %s = %.2f %s", cantidad_a_convertir, base_code, conversion_result, target_code);
    }
}
