/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "transaccion")
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t"),
    @NamedQuery(name = "Transaccion.findByCdtransaccion", query = "SELECT t FROM Transaccion t WHERE t.cdtransaccion = :cdtransaccion"),
    @NamedQuery(name = "Transaccion.findByCdcuentadestino", query = "SELECT t FROM Transaccion t WHERE t.cdcuentadestino = :cdcuentadestino"),
    @NamedQuery(name = "Transaccion.findByVltransaccion", query = "SELECT t FROM Transaccion t WHERE t.vltransaccion = :vltransaccion"),
    @NamedQuery(name = "Transaccion.findByNmcuotaspago", query = "SELECT t FROM Transaccion t WHERE t.nmcuotaspago = :nmcuotaspago")})
public class Transaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cdtransaccion")
    private Integer cdtransaccion;
    @Basic(optional = false)
    @Column(name = "cdcuentadestino")
    private int cdcuentadestino;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "vltransaccion")
    private BigDecimal vltransaccion;
    @Basic(optional = false)
    @Column(name = "nmcuotaspago")
    private int nmcuotaspago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdtransaccion", fetch = FetchType.LAZY)
    private List<RegistroTransaccion> registroTransaccionList;
    @JoinColumn(name = "cdcuentaorigen", referencedColumnName = "cdcuentabancaria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CuentaBancaria cdcuentaorigen;
    @JoinColumn(name = "cdtipopago", referencedColumnName = "cdtipopago")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoPago cdtipopago;

    public Transaccion() {
    }

    public Transaccion(Integer cdtransaccion) {
        this.cdtransaccion = cdtransaccion;
    }

    public Transaccion(Integer cdtransaccion, int cdcuentadestino, BigDecimal vltransaccion, int nmcuotaspago) {
        this.cdtransaccion = cdtransaccion;
        this.cdcuentadestino = cdcuentadestino;
        this.vltransaccion = vltransaccion;
        this.nmcuotaspago = nmcuotaspago;
    }

    public Integer getCdtransaccion() {
        return cdtransaccion;
    }

    public void setCdtransaccion(Integer cdtransaccion) {
        this.cdtransaccion = cdtransaccion;
    }

    public int getCdcuentadestino() {
        return cdcuentadestino;
    }

    public void setCdcuentadestino(int cdcuentadestino) {
        this.cdcuentadestino = cdcuentadestino;
    }

    public BigDecimal getVltransaccion() {
        return vltransaccion;
    }

    public void setVltransaccion(BigDecimal vltransaccion) {
        this.vltransaccion = vltransaccion;
    }

    public int getNmcuotaspago() {
        return nmcuotaspago;
    }

    public void setNmcuotaspago(int nmcuotaspago) {
        this.nmcuotaspago = nmcuotaspago;
    }

    public List<RegistroTransaccion> getRegistroTransaccionList() {
        return registroTransaccionList;
    }

    public void setRegistroTransaccionList(List<RegistroTransaccion> registroTransaccionList) {
        this.registroTransaccionList = registroTransaccionList;
    }

    public CuentaBancaria getCdcuentaorigen() {
        return cdcuentaorigen;
    }

    public void setCdcuentaorigen(CuentaBancaria cdcuentaorigen) {
        this.cdcuentaorigen = cdcuentaorigen;
    }

    public TipoPago getCdtipopago() {
        return cdtipopago;
    }

    public void setCdtipopago(TipoPago cdtipopago) {
        this.cdtipopago = cdtipopago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdtransaccion != null ? cdtransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.cdtransaccion == null && other.cdtransaccion != null) || (this.cdtransaccion != null && !this.cdtransaccion.equals(other.cdtransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.polijic.beans.Transaccion[ cdtransaccion=" + cdtransaccion + " ]";
    }
    
}