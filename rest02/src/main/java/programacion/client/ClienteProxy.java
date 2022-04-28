package programacion.client;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import programacion.db.Persona;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/personas")
interface ServicioPersonaProxy{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Persona> find();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response create(Persona p);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    Response update(@PathParam("id") Integer id, Persona p);

    @DELETE
    @Path("/{id}")
    Response delete(@PathParam("id") Integer id);

}

public class ClienteProxy {

    public static final String URL = "http://localhost:8080/rest02";
    private ClienteProxy(){}
    public static ServicioPersonaProxy create(){
        ResteasyClientBuilder builder = (ResteasyClientBuilder) ResteasyClientBuilder.newBuilder();
        ResteasyClient client = builder.build();
        ResteasyWebTarget target = client.target(URL);
        return target.proxy(ServicioPersonaProxy.class);
    }

    public static void main(String[] args) throws Exception {
        ServicioPersonaProxy c = ClienteProxy.create();

        Persona p = new Persona();
        p.setId(5);
        p.setNombre("Pepito");
        p.setDireccion("Guadalajara");
        c.create(p);


        List<Persona> clientes = c.find();
        clientes.stream().
                forEach( s ->{
                            System.out.printf("[%d] Nombre: %s\n", s.getId(), s.getNombre());
                        }
                );
    }

}
