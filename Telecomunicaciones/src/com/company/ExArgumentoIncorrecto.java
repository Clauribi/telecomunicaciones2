package com.company;

public class ExArgumentoIncorrecto extends Exception {
    public ExArgumentoIncorrecto(String message) {
        super("EXARGINC: "+message);
    }


}
