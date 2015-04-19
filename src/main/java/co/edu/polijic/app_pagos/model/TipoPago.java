/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.app_pagos.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "tipo_pago")
@TableGenerator(name="tipoPagoGenerator", initialValue=1, allocationSize=2500)
@NamedQueries({
    @NamedQuery(name = "TipoPago.findAll", query = "SELECT t FROM TipoPago t"),
    @NamedQuery(name = "TipoPago.findByCdtipopago", query = "SELECT t FROM TipoPago t WHERE t.cdtipopago = :cdtipopago"),
    @NamedQuery(name = "TipoPago.findByDsdescripcion", query = "SELECT t FROM TipoPago t WHERE t.dsdescripcion = :dsdescripcion")})
public class TipoPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="tipoPagoGenerator")
    @Basic(optional = false)
    @Column(name = "cdtipopago")
    private Integer cdtipopago;
    @Basic(optional = false)
    @Column(name = "dsdescripcion")
    private String dsdescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdtipopago")
    private List<Transaccion> transaccionList;

    public TipoPago() {
    }

    public TipoPago(Integer cdtipopago) {
        this.cdtipopago = cdtipopago;
    }

    public TipoPago(Integer cdtipopago, String dsdescripcion) {
        this.cdtipopago = cdtipopago;
        this.dsdescripcion = dsdescripcion;
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
        return transaccionList;
    }

    public void setTransaccionList(List<Transaccion> transaccionList) {
        this.transaccionList = transaccionList;
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
        return "co.edu.polijic.app_pagos.model.TipoPago[ cdtipopago=" + cdtipopago + " ]";
    }
    
}
