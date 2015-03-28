/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.main;

import co.edu.polijic.controllers.RegistroTransaccionJpaController;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import co.edu.polijic.beans.Transaccion;
import co.edu.polijic.controllers.TransaccionJpaController;
/**
 *
 * @author felipe
 */
public class Test {
    
    public static void main(String[] args) {
        
        try {
             EntityManagerFactory emf = Persistence.createEntityManagerFactory("APP_PagosPU");
             
             /*RegistroTransaccionJpaController registroTransaccionController = new RegistroTransaccionJpaController(emf);
             for(RegistroTransaccion registroTransaccion : registroTransaccionController.findRegistroTransaccionEntities()){
                 System.out.println("** : " + registroTransaccion);
             }*/
             
             /*TarjetaJpaController tarjetaController = new TarjetaJpaController(emf);
             for(Tarjeta tarjeta : tarjetaController.findTarjetaEntities()){
                 System.out.println("** : " + tarjeta);
             }*/
             
             TransaccionJpaController transaccionController = new TransaccionJpaController(emf);
             for (Transaccion transaccion : transaccionController.traerClienteNumeroCuenta(1)) {
                 System.out.println("Transaccion --> " + transaccion);
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
