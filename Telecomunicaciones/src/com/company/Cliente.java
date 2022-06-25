package com.company;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class Cliente {
    private String NIF;
    private String nombre;
    private String direccion;
    private TreeSet<ParteDeTrabajo> partesCliente;

    public Cliente(String NIF, String nombre, String direccion, TreeSet<ParteDeTrabajo> partesCliente) throws ExArgumentoIncorrecto {
        validateClient(NIF, nombre, direccion);
        if(partesCliente == null) throw new ExArgumentoIncorrecto("La coleccion de partes no puede ser null.");
        this.partesCliente = partesCliente;
    }
    public Cliente(String NIF, String nombre, String direccion, ParteDeTrabajo parteDeTrabajo) throws ExArgumentoIncorrecto {
        validateClient(NIF, nombre, direccion);
        if(parteDeTrabajo == null) throw new ExArgumentoIncorrecto("La coleccion de partes no puede ser null.");
        this.partesCliente = new TreeSet<>();
        this.partesCliente.add(parteDeTrabajo);
    }
    private void validateClient(String NIF, String nombre, String direccion) throws ExArgumentoIncorrecto {
        if(NIF == null) throw new ExArgumentoIncorrecto("El NIF no puede ser null.");
        this.NIF = NIF;
        if(nombre == null) throw new ExArgumentoIncorrecto("El nombre no puede ser null.");
        this.nombre = nombre;
        if(direccion == null) throw new ExArgumentoIncorrecto("La direccion no puede ser null.");
        this.direccion = direccion;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TreeSet<ParteDeTrabajo> getPartesCliente() {
        return partesCliente;
    }

    public void setPartesCliente(TreeSet<ParteDeTrabajo> partesCliente) {

        this.partesCliente = partesCliente;
    }
    public void asignaParte(ParteDeTrabajo p){

        this.partesCliente.add(p);

    }
    public double calcularCosteTotal(){
        double gastoTotal = 0.0;
        for (ParteDeTrabajo parteDeTrabajo: this.partesCliente) {
            gastoTotal += parteDeTrabajo.calculaCosteTotal();
        } return gastoTotal;
    }
    public String getFacturaPorFecha() {
        String factura= getNIF()+ getNombre();
        for(ParteDeTrabajo p: this.partesCliente){
            factura += p.getInfo() + calcularCosteTotal();
        }
        return factura;
    }

    public String getFacturaPorCoste(){
        String facturaCoste = getNIF();
        TreeSet<ParteDeTrabajo> partesClienteCoste = new TreeSet<>(new OrdenarPartesCoste());
        partesClienteCoste.addAll(this.partesCliente);
        for(ParteDeTrabajo p: partesClienteCoste){
            facturaCoste += p.getInfo() + calcularCosteTotal();
        }

        return facturaCoste;

    }



}
