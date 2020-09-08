
package utn.frd.bancobancame.rest.services;

import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import utn.frd.bancobancame.entities.Clientes;
import utn.frd.bancobancame.entities.Transacciones;
import utn.frd.bancobancame.sessions.TransaccionesFacade;

/**
 *
 * @author Sergio
 */
@Path("/transacciones")
public class TransaccionesRest {
    @EJB
    private TransaccionesFacade ejbClienteFacade;
    
    //obtener todas las entidades
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Transacciones> findAll(){
        return ejbClienteFacade.findAll();
    }
    
    //crear entidades
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Transacciones transacciones){
        ejbClienteFacade.create(transacciones);
    }
    
    //actualizar entidades
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public void edit(@PathParam("id")long id, Transacciones transacciones){
        ejbClienteFacade.edit(transacciones);
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
    public Transacciones findById(@PathParam("id")long id){
        return ejbClienteFacade.find(id);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/nuevaTransaccion")

public int createTransactionByEmail(Map<String, Object> params){
       
        return ejbClienteFacade.createTransactionByEmail(params.get("senderID"), params.get("email"), params.get("cantidad"), params.get("email"));
    }
    
} 
