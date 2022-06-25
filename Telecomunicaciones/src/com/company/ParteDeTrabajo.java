package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParteDeTrabajo implements Comparable<ParteDeTrabajo>{
    protected String descripcionTrabajo;
    protected int numeroHoras;
    protected double costeHora;
    protected long fechaDeCreacion;


    public ParteDeTrabajo(String descripcionTrabajo, int numeroHoras, double costeHora) throws ExArgumentoIncorrecto {
        if(descripcionTrabajo==null) throw new ExArgumentoIncorrecto("La descripción no puede ser null.");
        this.descripcionTrabajo = descripcionTrabajo;
        if(numeroHoras<=0) throw new ExArgumentoIncorrecto("El nº horas invertidas no puede ser inf o igual a 0.");
        this.numeroHoras = numeroHoras;
        if(costeHora<=0) throw new ExArgumentoIncorrecto("El coste por hora no puede ser inf o igual a 0.");
        this.costeHora = costeHora;
        Date creacion = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
        this.setFechaDeCreacion(Long.parseLong(dateFormat.format(creacion)));
        if(creacion==null) throw new ExArgumentoIncorrecto("La fecha no puede ser null.");
    }

    public String getDescripcion() {
        return descripcionTrabajo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcionTrabajo = descripcion;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public double getCosteHora() {
        return costeHora;
    }

    public void setCosteHora(double costeHora) {
        this.costeHora = costeHora;
    }

    public long getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(long fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public double calculaCosteTotal() {
        return this.costeHora*this.numeroHoras;
    }


    public String getInfo() {
        return  " " +
                " ParteDeTrabajo{" +
                " descripcionTrabajo='" + descripcionTrabajo + '\'' +
                ", numeroHoras=" + numeroHoras +
                ", costeHora=" + costeHora +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", costeTotal=" + calculaCosteTotal() + "€"+
                '}';
    }

    @Override
    public int compareTo(ParteDeTrabajo o) {
        if (this.fechaDeCreacion > o.getFechaDeCreacion()) return 1;
        if (this.fechaDeCreacion < o.getFechaDeCreacion()) return -1;
        return 0;
    }


}
