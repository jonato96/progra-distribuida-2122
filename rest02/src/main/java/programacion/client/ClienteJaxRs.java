package programacion.client;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClienteJaxRs {
    public static final String URL = "http://localhost:8080/rest02/personas";

    public List<PersonaClient> listarTodos() throws Exception {

        Client client = ClientBuilder.newClient();
        PersonaClient[] personas = client.target(URL)
                .request(MediaType.APPLICATION_JSON)
                .get(PersonaClient[].class);
        System.out.println(personas);
        return Arrays.asList(personas);

    }

    public void insertar(PersonaClient obj) throws Exception{
        Client client = ClientBuilder.newClient();

        Entity<PersonaClient> entity = Entity.entity(obj, MediaType.APPLICATION_JSON);

        client.target(URL)
                .request()
                .post(entity);

    }

    public static void main(String[] args) throws Exception {
        ClienteJaxRs c = new ClienteJaxRs();

        PersonaClient p = new PersonaClient();
        p.setId(4);
        p.setNombre("Pepito");
        p.setDireccion("Loja");
        c.insertar(p);


        List<PersonaClient> clientes = c.listarTodos();
        clientes.stream().
                forEach( s ->{
                    System.out.printf("[%d] Nombre: %s\n", s.getId(), s.getNombre());
                }
        );
    }
}
