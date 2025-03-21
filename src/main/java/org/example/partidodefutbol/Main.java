package org.example.partidodefutbol;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static final String NOMBRE_FICHERO = "src\\main\\java\\org\\example\\partidodefutbol\\partidos.txt";

    public static void main(String[] args) {
        ArrayList<PartidoFutbol> partidos = new ArrayList<>();
        File fichero = new File(NOMBRE_FICHERO);
        Scanner leerLineas = null;

        try {
            leerLineas = new Scanner(fichero);
            while (leerLineas.hasNext()) {
                String linea = leerLineas.nextLine();
                String[] cortalineas = linea.split("::");
                PartidoFutbol partido = new PartidoFutbol();
                partido.setEquipo_local(cortalineas[0]);
                partido.setEquipo_visitante(cortalineas[1]);
                partido.setGolLocal(Integer.parseInt(cortalineas[2]));
                partido.setGolVisitante(Integer.parseInt(cortalineas[3]));
                partidos.add(partido);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el fichero");
        }

        System.out.println("Número total de partidos: " + partidos.size());

        System.out.println("\nPartidos donde ganó el visitante:");
        for (PartidoFutbol partido : partidos) {
            if (partido.getGolVisitante() > partido.getGolLocal()) {
                System.out.println(partido.getEquipo_local() + " " + partido.getGolLocal() + " - " +
                        partido.getEquipo_visitante() + " " + partido.getGolVisitante());
            }
        }

        int contadorSevilla = 0;
        for (PartidoFutbol partido : partidos) {
            if (partido.getEquipo_local().equalsIgnoreCase("Sevilla")
                    && partido.getGolLocal() > partido.getGolVisitante()) {
                contadorSevilla++;
            } else if (partido.getEquipo_visitante().equalsIgnoreCase("Sevilla")
                    && partido.getGolVisitante() > partido.getGolLocal()) {
                contadorSevilla++;
            }
        }
        System.out.println("\nEl Sevilla ha ganado " + contadorSevilla + " veces.");

        Iterator<PartidoFutbol> iterador = partidos.iterator();
        while (iterador.hasNext()) {
            PartidoFutbol partido = iterador.next();
            if (partido.getGolLocal() != partido.getGolVisitante()) {
                iterador.remove();
            }
        }

        System.out.println("\nPartidos después de eliminar los no empatados:");
        for (PartidoFutbol partido : partidos) {
            System.out.println(partido.getEquipo_local() + " " + partido.getGolLocal() + " - " +
                    partido.getEquipo_visitante() + " " + partido.getGolVisitante());
        }

        int contadorLocal = 0;
        for (PartidoFutbol partido : partidos) {
            if (partido.getGolLocal() > partido.getGolVisitante()) {
                contadorLocal++;
            }
        }
        System.out.println("\nCantidad de partidos ganados por el equipo local: " + contadorLocal);
    }
}
