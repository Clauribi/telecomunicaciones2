package com.company;

import java.util.HashMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        try {
        Gestor gestor1 = new Gestor("Gamba", new HashMap<>());
        gestor1.addClientes(new Cliente("04225", "Pablo", "calle alvarado", new TreeSet<>()));
        gestor1.insertarPartes("04225", new ParteDeTrabajo("instalacion", 8, 12));
        gestor1.insertarPartes("04225", new ParteDeIncidencia("averia",3,12,2));
        gestor1.insertarPartes("04225",new ParteDeSolicitud("arregloestetico",12,12,5));
        String facturaPablo = gestor1.generarFacturaFecha("04225");
            System.out.println(facturaPablo);
        String factura2Pablo = gestor1.generarFacturaCoste("04225");
            System.out.println(factura2Pablo);
        gestor1.addClientes(new Cliente("04226", "Antonia", "calle alvarado 2", new TreeSet<>()));
        gestor1.insertarPartes("04226", new ParteDeTrabajo("reforma", 10, 10));
        gestor1.insertarPartes("04226", new ParteDeIncidencia("averia electrica",12,10,3));
        gestor1.insertarPartes("04226",new ParteDeSolicitud("arreglo",12,12,5));
        String facturaAntonia = gestor1.generarFacturaFecha("04226");
            System.out.println(facturaAntonia);
        String factura2Antonia = gestor1.generarFacturaCoste("04226");
            System.out.println(factura2Antonia);

        System.out.println(gestor1.calcularCosteTotalEmpresa());

        } catch (ExArgumentoIncorrecto e) {
        e.printStackTrace();
    }
    }
}
