/*
 * Politecnico Colombiano Jaime Isaza Cadavid
 * All Copyright Reserved
 * 2015
 */
package co.edu.polijic.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Johan Felipe Bedoya
 * @author Natalia Diaz Padilla
 * @author Vanessa Agudelo Marin
 * @version 1.0
 */
@Entity
@Table(name = "tipo_pago")
public class TipoPago implements Serializable {
    @Id
    @Column(name = "cdtipopago")
    private Integer cdtipopago;
    @Column(name = "dsdescripcion")
    private String dsdescripcion;
    @OneToMany(mappedBy = "cdtipopago")
    private List<Transaccion> transacciones;

    public TipoPago() {
    }

    public TipoPago(Integer cdtipopago, String dsdescripcion, List<Transaccion> transacciones) {
        this.cdtipopago = cdtipopago;
        this.dsdescripcion = dsdescripcion;
        this.transacciones = transacciones;
    }

    

    public Integer getCdtipopago() {
        return cdtipopago;
    }

    public void setCdtipopago(Integer cdtipopago) {
        this.cdtipopago = cdtipopago;
    }

    public String getDsdescripcion() {
        return dsdescripcion;
    }

    public void setDsdescripcion(String dsdescripcion) {
        this.dsdescripcion = dsdescripcion;
    }

    public List<Transaccion> getTransaccionList() {
        return transacciones;
    }

    public void setTransaccionList(List<Transaccion> transaccionList) {
        this.transacciones = transaccionList;
    }

    @Override
    public String toString() {
        return "TipoPago{" + "cdtipopago=" + cdtipopago + ", dsdescripcion=" + dsdescripcion + ", transacciones=" + transacciones + '}';
    }

    

    
    
}
