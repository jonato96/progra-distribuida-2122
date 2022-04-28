package programacion.rest;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import programacion.db.Persona;
import programacion.services.ServicioPersona;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/personas")
@ApplicationScoped
public class PersonaRest {

    /**
     * GET /personas
     * GET /personas/{id}
     * DELETE /personas{id}
     * PUT /personas{id}
     * POST /personas
     */

//    static private ServicioPersona servicio = new ServicioPersona();
    @Inject
    private ServicioPersona servicio;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona findById(@PathParam("id") Integer id){
        Persona p = servicio.findById(id);
        if (p == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return p;
    }

//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response findById(@PathParam("id") Integer id){
//        Persona p = servicio.findById(id);
//        if (p == null){
//            throw Response.status(Response.Status.NOT_FOUND).build();
//        }
//        return Response.ok(p).build();
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> find(){
        List<Persona> p = servicio.findAll();
        return p;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Persona p){
        servicio.create(p);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, Persona p){
        servicio.update(id, p);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id){
        servicio.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


}
