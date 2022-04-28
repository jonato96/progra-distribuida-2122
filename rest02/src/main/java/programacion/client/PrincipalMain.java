package programacion.client;

import java.util.List;

public class PrincipalMain {
    public static void main(String[] args) throws Exception {
        ClienteHttp clienteHttp = new ClienteHttp();

        PersonaClient p = new PersonaClient();
        p.setId(3);
        p.setNombre("Juanito");
        p.setDireccion("Guayaquil");
        clienteHttp.insertar(p);

        //List<PersonaClient> clientes = clienteHttp.listarTodos();
//        clientes.stream().
//                forEach( s ->{
//                    System.out.printf("[%d] Nombre: %s\n", p.getId(), p.getNombre());
//                }
//
//        );

    }
}
