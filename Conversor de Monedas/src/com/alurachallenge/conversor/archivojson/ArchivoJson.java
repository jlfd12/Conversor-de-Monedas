package com.alurachallenge.conversor.archivojson;

import com.alurachallenge.conversor.conversion.Conversion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArchivoJson{

    public void guardarJson(List<Conversion> cambios) throws IOException {
        FileWriter escritura = new FileWriter("conversiones.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        escritura.write(gson.toJson(cambios));
        escritura.close();
        System.out.println("Archivo Json guardado\n<<<CONVERSIONES>>>");

        if(cambios.isEmpty()){
            System.out.println("No hubo conversiones");
        }else{
            for (Conversion conversion : cambios){
                System.out.println(conversion.toString());
            }
        }
    }
}
