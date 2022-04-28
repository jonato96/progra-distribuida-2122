package com.programacion.servicios;

//@ApplicationScoped
public class LogImpl implements Log{
    public void log(String msg) {
        System.out.println("Log: "+msg);
    }
}
