package com.company;

import java.util.Comparator;

public class OrdenarPartesCoste implements Comparator<ParteDeTrabajo> {
    @Override
    public int compare(ParteDeTrabajo o1, ParteDeTrabajo o2) {
            if (o1.calculaCosteTotal() > o2.calculaCosteTotal()) return 1;
            if (o1.calculaCosteTotal() < o2.calculaCosteTotal()) return -1;
            return 0;
        }
    }

