/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author felipe
 */
@Entity
@Table(name = "tipo_pago")
@NamedQueries({
    @NamedQuery(name = "TipoPago.findAll", query = "SELECT t FROM TipoPago t"),
    @NamedQuery(name = "TipoPago.findByCdtipopago", query = "SELECT t FROM TipoPago t WHERE t.cdtipopago = :cdtipopago"),
    @NamedQuery(name = "TipoPago.findByDsdescripcion", query = "SELECT t FROM TipoPago t WHERE t.dsdescripcion = :dsdescripcion")})
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
    public int hashCode() {
        int hash = 0;
        hash += (cdtipopago != null ? cdtipopago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPago)) {
            return false;
        }
        TipoPago other = (TipoPago) object;
        if ((this.cdtipopago == null && other.cdtipopago != null) || (this.cdtipopago != null && !this.cdtipopago.equals(other.cdtipopago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoPago{" + "cdtipopago=" + cdtipopago + ", dsdescripcion=" + dsdescripcion + ", transacciones=" + transacciones + '}';
    }

    
    
}