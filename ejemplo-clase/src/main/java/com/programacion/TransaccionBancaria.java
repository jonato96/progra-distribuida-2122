package com.programacion;

public class TransaccionBancaria {

    private ManejadorPersistencia mp = null;

    public TransaccionBancaria(){
        mp = new ManejadorPersistencia();
    }

    public void realizarTranferencia(String c1, String c2, float valor){

        System.out.println("Iniciando transaccion bancaria");
        CuentaBancaria cuenta1  = mp.buscarCuenta(c1);
        CuentaBancaria cuenta2  = mp.buscarCuenta(c2);
        cuenta1.deposito(valor);
        cuenta2.retiro(valor);
        System.out.println("Transferencia realizada");

    }

}
