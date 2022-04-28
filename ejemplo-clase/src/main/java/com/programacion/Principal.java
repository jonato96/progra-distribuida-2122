package com.programacion;

public class Principal {

    public static void main(String[] args) {

        TransaccionBancaria tr = new TransaccionBancaria();
        tr.realizarTranferencia("0930146", "314600",100.00f);

    }

}
