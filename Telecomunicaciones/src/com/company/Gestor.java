package com.company;

import java.util.HashMap;
import java.util.TreeSet;

public class Gestor {
    private String nombreEmpresa;
    private HashMap<String, Cliente> clientes;

    public Gestor(String nombreEmpresa, HashMap<String, Cliente> clientes) throws ExArgumentoIncorrecto {
        validateGestor(nombreEmpresa);
        if(clientes== null) throw new ExArgumentoIncorrecto("La coleccion clientes no puede ser null.");
        this.clientes = clientes;
    }
    public Gestor(String nombreEmpresa, Cliente cliente) throws ExArgumentoIncorrecto {
        validateGestor(nombreEmpresa);
        if(cliente== null) throw new ExArgumentoIncorrecto("La coleccion clientes no puede ser null.");
        this.clientes = new HashMap<>();
        this.clientes.put(cliente.getNIF(), cliente);
    }
    private void validateGestor(String nombreEmpresa) throws ExArgumentoIncorrecto {
        if(nombreEmpresa ==null) throw new ExArgumentoIncorrecto("El nombre de empresa es null.");
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public HashMap<String, Cliente> getClientes() {

        return clientes;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {

        this.clientes = clientes;
    }
    public void addClientes(Cliente cliente){

        this.clientes.put(cliente.getNIF(), cliente);
    }
    public void insertarPartes(String NIF, ParteDeTrabajo p) throws ExArgumentoIncorrecto {
        Cliente c = this.clientes.get(NIF);
        if (this.clientes.containsKey(c.getNIF())) {
            c.asignaParte(p);
        } else throw new ExArgumentoIncorrecto("Este cliente no existe.");

    }
    public String generarFacturaFecha(String NIF) throws ExArgumentoIncorrecto {
        Cliente c = this.clientes.get(NIF);
        if (this.clientes.containsKey(c.getNIF())) {
            return c.getFacturaPorFecha();
        } else throw new ExArgumentoIncorrecto("Este cliente no existe.");

    }
    public String generarFacturaCoste(String NIF) throws ExArgumentoIncorrecto {
        Cliente c = this.clientes.get(NIF);
        if (this.clientes.containsKey(c.getNIF())){
                return c.getFacturaPorCoste();
            } else throw new ExArgumentoIncorrecto("Este cliente no existe.");
    }
    public double calcularCosteTotalEmpresa(){
        double gastoTotal = 0.0;
        for (Cliente c: this.clientes.values()) {
            gastoTotal += c.calcularCosteTotal();
        } return gastoTotal;
    }





}
