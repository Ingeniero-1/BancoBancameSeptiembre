
package utn.frd.bancobancame.rest.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utn.frd.bancobancame.entities.Clientes;
import utn.frd.bancobancame.sessions.ClientesFacade;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
@Path("/clientes")
public class ClientesRest {
    @EJB
    private ClientesFacade ejbClienteFacade;
    
    //obtener todas las entidades
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Clientes> findAll(){
        return ejbClienteFacade.findAll();
    }
    
    //crear entidades
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Clientes clientes){
        ejbClienteFacade.create(clientes);
    }
    
    //actualizar entidades
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public void edit(@PathParam("id")long id, Clientes clientes){
        ejbClienteFacade.edit(clientes);
    }
    
    //eliminar entidades
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public void remove(@PathParam("id")long id){
        ejbClienteFacade.remove( ejbClienteFacade.find(id) );
    }
    
    //obtener una entidad por id
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Clientes findById(@PathParam("id")long id){
        return ejbClienteFacade.find(id);
    }
   
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/login")

    public List findByEmail(Clientes clientes){
       
        return ejbClienteFacade.findByEmail(clientes.getEmail(), clientes.getPassword());
        
               
    }
    
    
    
}
