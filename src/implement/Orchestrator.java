/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.Persona;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Orchestrator {

    public void menu() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("datos.csv"));
        ArrayList<Persona> personas = ingresarDatos(br);
        
        System.out.println("DATOS INGRESADOS\n");
        personas.stream().forEach(System.out::println);
        

        System.out.println("\n3. Se deben obtener los datos de (Giselle Marshall) e imprimirlos en pantalla");
        personas.stream().filter((persona) -> (persona.getNombreApellido().equalsIgnoreCase("Giselle Marshall"))).forEach(System.out::println);
        
        System.out.println("\n4. Se deben obtener los datos para el correo (imperdiet.non@enim.org).");
        personas.stream().filter((persona) -> (persona.getMail().equalsIgnoreCase("imperdiet.non@enim.org"))).forEach(System.out::println);
        
        System.out.println("\n5. Se deben almacenar en una estructura de datos todos las ciudades para evitar repetidos e imprimir la cantidad.");
        HashSet<String> ciudades = new HashSet();
        personas.stream().forEach((persona) -> ciudades.add(persona.getCiudad()));
        System.out.println(ciudades.stream().count());
        
        System.out.println("\n6. Se deben contar todos los correos que posean en alguna parte de su dominio la palabra (elite)");
        System.out.println(personas.stream().filter((persona) -> (persona.getMail().contains("elite"))).count());
        
        System.out.println("\n7. Se deben multiplicar por 3 todos los montos en la colección, e imprimir los mayores a 29000.");
        personas.forEach((persona) -> {persona.setMonto(persona.getMonto()*3);});
        personas.stream().filter((persona)->(persona.getMonto()>29000)).forEach(System.out::println);
        
        System.out.println("\n8. Calcular el promedio de todos los montos.");
        int promedio = 0;
        promedio = personas.stream().map((persona) -> persona.getMonto()).reduce(promedio, Integer::sum);//no se q hice
        System.out.println(promedio/personas.size());
        
        System.out.println("\n9. Obtener los datos de la persona con el monto menor.");
        personas.stream().sorted((p1,p2) -> (p1.getMonto().compareTo(p2.getMonto()))).limit(1).forEach((p3) -> System.out.println(p3));


        System.out.println("\n10. Obtener los datos de la persona con el monto mayor.");
        personas.stream().sorted((p1,p2)-> (p2.getMonto().compareTo(p1.getMonto()))).limit(1).forEach((p3) -> System.out.println(p3));

    }

    public ArrayList<Persona> ingresarDatos(BufferedReader br) throws IOException {
        ArrayList<Persona> personas = new ArrayList();
        String data = br.readLine();
        while (data != null) {
            String[] dataSplit = data.split(",");
            personas.add(new Persona(dataSplit[0], dataSplit[1], dataSplit[2], Integer.valueOf(dataSplit[3])));
            data = br.readLine();
        }
        return personas;
    }

}
