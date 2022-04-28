package servicios;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LogImpl implements Log{
    @Override
    public String log(String mensaje) {
        return mensaje;
    }
}
