package com.company;

public class ParteDeIncidencia extends ParteDeTrabajo{
    private int descuento;

    public ParteDeIncidencia(String descripcionTrabajo, int numeroHoras, double costeHora, int descuento) throws ExArgumentoIncorrecto {
        super(descripcionTrabajo, numeroHoras, costeHora);
        if(descuento<=0||descuento>100) throw new ExArgumentoIncorrecto("El descuento debe estar entre 0-100.");
        this.descuento=descuento;
    }
    @Override
    public double calculaCosteTotal() {
        return (getCosteHora()*(1-(this.descuento/100))*getNumeroHoras());
    }

    @Override
    public String getInfo() {
        return  " :" +
                " ParteDeIncidencia{" +
                "  descuento=" + descuento +
                ", descripcionTrabajo='" + descripcionTrabajo + '\'' +
                ", numeroHoras=" + numeroHoras +
                ", costeHora=" + costeHora +
                ", fechaDeCreacion=" + fechaDeCreacion +
                '}';
    }
}
