package com.programacion;

public class ManejadorPersistencia {

    public CuentaBancaria buscarCuenta(String cuenta){
        System.out.println("Buscar cuenta> "+cuenta);
        return new CuentaBancaria();
    }

}
