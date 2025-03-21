/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example.partidodefutbol;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {

    private static final String NOMBRE_FICHERO = "src\\main\\org\\example\\partidodefutbol\\partidos.txt";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<PartidoFutbol> partidos = new ArrayList<>();
        File fichero = new File(NOMBRE_FICHERO);
        Scanner leerLIneas = null;

        try {
            leerLIneas = new Scanner(fichero);
            while (leerLIneas.hasNext()) {
                String linea = leerLIneas.nextLine();
                String[] cortalineas = linea.split("::");
                PartidoFutbol partido = new PartidoFutbol();
                partido.setEquipo_local(cortalineas[0]);
                partido.setEquipo_visitante(cortalineas[1]);
                partido.setGolLocal(Integer.parseInt(cortalineas[2]));
                partido.setGolVisitante(Integer.parseInt(cortalineas[3]));
                partidos.add(partido);

                System.out.println(partido.getEquipo_local() + " " + partido.getGolLocal() + " vs "
                        + partido.getEquipo_visitante() + " " + partido.getGolVisitante());

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el fichero");

        }
        System.out.println("el  numeros de partidos es : " + partidos.size());
    }

}
