package servicios;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
@Named("miBean")
public class HolaMundoImpl implements HolaMundo{
    @Inject
    Log miLog;

    @Override
    public String hola(String nombre) {
        System.out.println(miLog.log("Estamos invocando un metodo"));
        return "Hola mundo "+nombre;
    }
}
