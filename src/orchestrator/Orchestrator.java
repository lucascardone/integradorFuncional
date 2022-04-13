/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package orchestrator;

import constants.Constant;
import entity.Persona;
import implement.PersonaImplementService;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Orchestrator {

    public static void start() throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(Constant.CSV));
        PersonaImplementService perServ = new PersonaImplementService();
        ArrayList<Persona> personas = perServ.ingresarDatos(br);
        perServ.datosIngresados(personas);
        perServ.datosNombre(personas);
        perServ.datosCorreo(personas);
        perServ.almacCiudad(personas);
        perServ.contCorreo(personas);
        perServ.multiMonto(personas);
        perServ.promedioMonto(personas);
        perServ.montoMenor(personas);
        perServ.montoMayor(personas);
        
    }
}
