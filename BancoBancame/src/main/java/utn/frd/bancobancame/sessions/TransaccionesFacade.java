/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.bancobancame.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utn.frd.bancobancame.entities.Transacciones;

/**
 *
 * @author pmari
 */
@Stateless
public class TransaccionesFacade extends AbstractFacade<Transacciones> {

    @PersistenceContext(unitName = "utn.frd_BancoBancame_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransaccionesFacade() {
        super(Transacciones.class);
    }

    public int createTransactionByEmail(int senderID, String receiverEmail, int cantidad, String name) {
            
    Query query = getEntityManager().createNativeQuery("INSERT INTO transacciones (cantidad, id_emisor, id_receptor) VALUES (?,?,(SELECT u.id FROM clientes u WHERE u.email LIKE ? ))");            
            query.setParameter(1, cantidad);
            query.setParameter(2, senderID);
            query.setParameter(3, receiverEmail);
           // query.setParameter(4, name);
                return query.executeUpdate();       
    }
    
}
