package com.alurachallenge.conversor.principal;
import com.alurachallenge.conversor.archivojson.ArchivoJson;
import com.alurachallenge.conversor.conversion.Cambio;
import com.alurachallenge.conversor.conversion.Conversion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        int opcion = 0;
        double cantidad = 0;
        List<Conversion> cambios = new ArrayList<>();
         Scanner lectura = new Scanner(System.in);
         Cambio cambio = new Cambio();
         String menu = """
                 ***************************
                 Hola! Bienvenido/a al Conversor de Monedas:
                 
                 1 - Dolar -----> Peso mexicano
                 2 - Peso mexicano -----> Dolar
                 3 - Dolar -----> Real brasileño 
                 4 - Real brasileño -----> Dolar
                 5 - Dolar -----> Peso colombiano
                 6 - Peso colombiano -----> Dolar
                 7 - SALIR
                 
                 Elija una opcion valida:
                 """;

        while(true) {
            System.out.println(menu);
            String input = lectura.nextLine().trim();
            if(input.isBlank()){
                System.out.println("Introduzca una opcion valida");
                continue;
            }
            try{
                opcion = Integer.parseInt(input);
            }catch (NumberFormatException e){
                System.out.println("Introduzca una opcion valida\n");
                continue;
            }
            if (opcion == 7){
                System.out.println("Saliendo del Conversor de Monedas");
                System.out.println();
                break;
            }
            if(opcion < 1 || opcion > 6){
                System.out.println("Introduzca una opcion valida\n");
                continue;
            }
            System.out.println("¿Cual es la cantidad a convertir?");
            input  = lectura.nextLine().trim();
            if (input.isBlank()){
                System.out.println("Introduzca una cantidad valida\n");
                continue;
            }
            try{
                cantidad = Double.parseDouble(input);
            }catch (NumberFormatException e){
                System.out.println("Introduzca una opcion valida\n");
                continue;
            }
            Conversion reConversion = cambio.hazCambio(opcion, cantidad);
            System.out.println("Cantidad: " + String.format("%.2f", cantidad) + " " + reConversion.base_code() + "\n"
                    + "Resultado: " + String.format("%.2f", reConversion.conversion_result()) + " " + reConversion.target_code());
            System.out.println("\n");
            Conversion conversion = new Conversion(
                    reConversion.base_code(),
                    reConversion.target_code(),
                    reConversion.conversion_result(),
                    cantidad
            );
            cambios.add(conversion);
        }

        ArchivoJson archivo = new ArchivoJson();
        archivo.guardarJson(cambios);
    }
}
