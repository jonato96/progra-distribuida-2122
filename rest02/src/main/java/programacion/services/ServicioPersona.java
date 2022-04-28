package programacion.services;

import programacion.db.Persona;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

@ApplicationScoped
public class ServicioPersona implements ServicioPersonaI{

    //DI
    @Inject
    private DataSource dataSource;

//    private Map<Integer, Persona> personas = new HashMap<>();
//
//    {
//        Persona p = new Persona(1, "Jonathan", "Quininde");
//        Persona p1 = new Persona(2, "Juan", "Quito");
//        personas.put(p.getId(), p);
//        personas.put(p1.getId(), p1);
//    }

    public Persona findById(Integer id){
        Connection con = null;
        Persona p = null;
        try{
           con = dataSource.getConnection();
            PreparedStatement pstmt = con.prepareStatement("select * from personas where id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                p = new Persona();
                p.setId(id);
                p.setNombre(rs.getString("nombre"));
                p.setDireccion(rs.getString("direccion"));
            }
            rs.close();
            pstmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return p;
    }

    public List<Persona> findAll(){
        //return new ArrayList<>(personas.values());
        return Collections.emptyList();
    }

    public void delete(Integer id){
        //personas.remove(id);
    }

    public void update(Integer id, Persona obj){

//        Persona p = personas.get(id);
//        if(p != null){
//            p.setNombre(obj.getNombre());
//            p.setDireccion(obj.getDireccion());
//        }
//        personas.put(id, p);
    }

    public void create(Persona p){
        //personas.put(p.getId(), p);
    }

}
