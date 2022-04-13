/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;


import constants.Constant;
import entity.Persona;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class PersonaImplementService {

    private final BufferedReader br;
    public final ArrayList<Persona> personas;

    public PersonaImplementService() throws FileNotFoundException, IOException {
        this.br = new BufferedReader(new FileReader(Constant.CSV));
        this.personas = ingresarDatos(br);
    }
    
    public void datosIngresados(ArrayList<Persona> personas) {
        System.out.println("DATOS INGRESADOS\n");
        personas.stream().forEach(System.out::println);
    }

    public void datosNombre(ArrayList<Persona> personas) {
        System.out.println("\n3. Se deben obtener los datos de (Giselle Marshall) e imprimirlos en pantalla");
        personas.stream().filter((persona) -> (persona.getNombreApellido().equalsIgnoreCase(Constant.NOMBRE))).forEach(System.out::println);
    }

    public void datosCorreo(ArrayList<Persona> personas) {
        System.out.println("\n4. Se deben obtener los datos para el correo (imperdiet.non@enim.org).");
        personas.stream().filter((persona) -> (persona.getMail().equalsIgnoreCase(Constant.EMAIL))).forEach(System.out::println);
    }

    public void almacCiudad(ArrayList<Persona> personas) {
        System.out.println("\n5. Se deben almacenar en una estructura de datos todos las ciudades para evitar repetidos e imprimir la cantidad.");
        HashSet<String> ciudades = new HashSet();
        personas.stream().forEach((persona) -> ciudades.add(persona.getCiudad()));
        System.out.println(ciudades.stream().count());
    }

    public void contCorreo(ArrayList<Persona> personas) {
        System.out.println("\n6. Se deben contar todos los correos que posean en alguna parte de su dominio la palabra (elite)");
        System.out.println(personas.stream().filter((persona) -> (persona.getMail().contains(Constant.EMAILCONT))).count());
    }

    public void multiMonto(ArrayList<Persona> personas) {
        System.out.println("\n7. Se deben multiplicar por 3 todos los montos en la colección, e imprimir los mayores a 29000.");
        personas.forEach((persona) -> {
            persona.setMonto(persona.getMonto() * 3);
        });
        personas.stream().filter((persona) -> (persona.getMonto() > 29000)).forEach(System.out::println);
    }

    public void promedioMonto(ArrayList<Persona> personas) {
        System.out.println("\n8. Calcular el promedio de todos los montos.");
        int promedio = 0;
        promedio = personas.stream().map((persona) -> persona.getMonto()).reduce(promedio, Integer::sum);//no se q hice
        System.out.println(promedio / personas.size());
    }

    public void montoMenor(ArrayList<Persona> personas) {
        System.out.println("\n9. Obtener los datos de la persona con el monto menor.");
        personas.stream().sorted((p1, p2) -> (p1.getMonto().compareTo(p2.getMonto()))).limit(1).forEach((p3) -> System.out.println(p3));
    }

    public void montoMayor(ArrayList<Persona> personas) {
        System.out.println("\n10. Obtener los datos de la persona con el monto mayor.");
        personas.stream().sorted((p1, p2) -> (p2.getMonto().compareTo(p1.getMonto()))).limit(1).forEach((p3) -> System.out.println(p3));
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
