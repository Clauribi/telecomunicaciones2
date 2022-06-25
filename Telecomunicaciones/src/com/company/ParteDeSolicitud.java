package com.company;

public class ParteDeSolicitud extends ParteDeTrabajo {
    private int recargo;

    public ParteDeSolicitud(String descripcionTrabajo, int numeroHoras, double costeHora, int recargo) throws ExArgumentoIncorrecto {
        super(descripcionTrabajo, numeroHoras, costeHora);
        if(recargo<=0||recargo>100) throw new ExArgumentoIncorrecto("El descuento debe estar entre 0-100.");
        this.recargo=recargo;
    }
    @Override
    public double calculaCosteTotal() {
        return (getCosteHora()*(1+(this.recargo/100))*getNumeroHoras());
    }

    @Override
    public String getInfo() {
        return  " " +
                "ParteDeSolicitud{" +
                "recargo=" + recargo +
                ", descripcionTrabajo='" + descripcionTrabajo + '\'' +
                ", numeroHoras=" + numeroHoras +
                ", costeHora=" + costeHora +
                ", fechaDeCreacion=" + fechaDeCreacion +
                '}';
    }
}
