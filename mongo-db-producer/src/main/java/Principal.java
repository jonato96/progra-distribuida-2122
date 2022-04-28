import com.programacion.Hola;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class Principal {
    public static void main(String[] args){
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        Instance<Hola> servicio = container.select(Hola.class);
        Hola saludo = servicio.get();
        System.out.println(saludo.saludar());
    }
}
