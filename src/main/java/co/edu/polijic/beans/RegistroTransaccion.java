/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "registro_transaccion")
@NamedQueries({
    @NamedQuery(name = "RegistroTransaccion.findAll", query = "SELECT r FROM RegistroTransaccion r"),
    @NamedQuery(name = "RegistroTransaccion.findByCdregistro", query = "SELECT r FROM RegistroTransaccion r WHERE r.cdregistro = :cdregistro"),
    @NamedQuery(name = "RegistroTransaccion.findByFefechatransaccion", query = "SELECT r FROM RegistroTransaccion r WHERE r.fefechatransaccion = :fefechatransaccion"),
    @NamedQuery(name = "RegistroTransaccion.findByDsobservaciones", query = "SELECT r FROM RegistroTransaccion r WHERE r.dsobservaciones = :dsobservaciones")})
public class RegistroTransaccion implements Serializable {

    @Id
    @Column(name = "cdregistro")
    private Integer cdregistro;
    @Column(name = "fefechatransaccion")
    @Temporal(TemporalType.DATE)
    private Date fefechatransaccion;
    @Column(name = "dsobservaciones")
    private String dsobservaciones;
    @Column(name="cdestado")
    @Enumerated(EnumType.STRING)  
    private EstadoTransaccion cdestado;
    //@Column(name="cdtransaccion")
    @ManyToOne
    @JoinColumn(name = "cdtransaccion", referencedColumnName = "cdtransaccion")
    private Transaccion cdtransaccion;

    public RegistroTransaccion() {
    }

    public RegistroTransaccion(Integer cdregistro, Date fefechatransaccion, String dsobservaciones, EstadoTransaccion cdestado, Transaccion cdtransaccion) {
        this.cdregistro = cdregistro;
        this.fefechatransaccion = fefechatransaccion;
        this.dsobservaciones = dsobservaciones;
        this.cdestado = cdestado;
        this.cdtransaccion = cdtransaccion;
    }

    

    public Integer getCdregistro() {
        return cdregistro;
    }

    public void setCdregistro(Integer cdregistro) {
        this.cdregistro = cdregistro;
    }

    public Date getFefechatransaccion() {
        return fefechatransaccion;
    }

    public void setFefechatransaccion(Date fefechatransaccion) {
        this.fefechatransaccion = fefechatransaccion;
    }

    public String getDsobservaciones() {
        return dsobservaciones;
    }

    public void setDsobservaciones(String dsobservaciones) {
        this.dsobservaciones = dsobservaciones;
    }

    public EstadoTransaccion getCdestado() {
        return cdestado;
    }

    public void setCdestado(EstadoTransaccion cdestado) {
        this.cdestado = cdestado;
    }

    public Transaccion getCdtransaccion() {
        return cdtransaccion;
    }

    public void setCdtransaccion(Transaccion cdtransaccion) {
        this.cdtransaccion = cdtransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdregistro != null ? cdregistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroTransaccion)) {
            return false;
        }
        RegistroTransaccion other = (RegistroTransaccion) object;
        if ((this.cdregistro == null && other.cdregistro != null) || (this.cdregistro != null && !this.cdregistro.equals(other.cdregistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RegistroTransaccion{" + "cdregistro=" + cdregistro + ", fefechatransaccion=" + fefechatransaccion + ", dsobservaciones=" + dsobservaciones + ", cdestado=" + cdestado + ", cdtransaccion=" + cdtransaccion + '}';
    }

   

    
    
}
