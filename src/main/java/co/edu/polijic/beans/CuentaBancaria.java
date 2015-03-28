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
 * @author felipe
 */
@Entity
@Table(name = "cuenta_bancaria")
@NamedQueries({
    @NamedQuery(name = "CuentaBancaria.findAll", query = "SELECT c FROM CuentaBancaria c"),
    @NamedQuery(name = "CuentaBancaria.findByCdcuentabancaria", query = "SELECT c FROM CuentaBancaria c WHERE c.cdcuentabancaria = :cdcuentabancaria"),
    @NamedQuery(name = "CuentaBancaria.findByNmcuentabancaria", query = "SELECT c FROM CuentaBancaria c WHERE c.nmcuentabancaria = :nmcuentabancaria"),
    @NamedQuery(name = "CuentaBancaria.findByDsnombretitular", query = "SELECT c FROM CuentaBancaria c WHERE c.dsnombretitular = :dsnombretitular")})
public class CuentaBancaria implements Serializable {
    @Id
    @Column(name = "cdcuentabancaria")
    private Integer cdcuentabancaria;
    @Column(name = "nmcuentabancaria")
    private String nmcuentabancaria;
    @Column(name = "dsnombretitular")
    private String dsnombretitular;
    @OneToMany( mappedBy = "cdcuentaorigen")
    private List<Transaccion> transacciones;
    @OneToMany(mappedBy = "cdcuentabancaria")
    private List<Tarjeta> tarjetas;

    public CuentaBancaria() {
    }

    public CuentaBancaria(Integer cdcuentabancaria, String nmcuentabancaria, String dsnombretitular, List<Transaccion> transacciones, List<Tarjeta> tarjetas) {
        this.cdcuentabancaria = cdcuentabancaria;
        this.nmcuentabancaria = nmcuentabancaria;
        this.dsnombretitular = dsnombretitular;
        this.transacciones = transacciones;
        this.tarjetas = tarjetas;
    }

    

    public Integer getCdcuentabancaria() {
        return cdcuentabancaria;
    }

    public void setCdcuentabancaria(Integer cdcuentabancaria) {
        this.cdcuentabancaria = cdcuentabancaria;
    }

    public String getNmcuentabancaria() {
        return nmcuentabancaria;
    }

    public void setNmcuentabancaria(String nmcuentabancaria) {
        this.nmcuentabancaria = nmcuentabancaria;
    }

    public String getDsnombretitular() {
        return dsnombretitular;
    }

    public void setDsnombretitular(String dsnombretitular) {
        this.dsnombretitular = dsnombretitular;
    }

    public List<Transaccion> getTransaccionList() {
        return transacciones;
    }

    public void setTransaccionList(List<Transaccion> transaccionList) {
        this.transacciones = transaccionList;
    }

    public List<Tarjeta> getTarjetaList() {
        return tarjetas;
    }

    public void setTarjetaList(List<Tarjeta> tarjetaList) {
        this.tarjetas = tarjetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdcuentabancaria != null ? cdcuentabancaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaBancaria)) {
            return false;
        }
        CuentaBancaria other = (CuentaBancaria) object;
        if ((this.cdcuentabancaria == null && other.cdcuentabancaria != null) || (this.cdcuentabancaria != null && !this.cdcuentabancaria.equals(other.cdcuentabancaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" + "cdcuentabancaria=" + cdcuentabancaria + ", nmcuentabancaria=" + nmcuentabancaria + ", dsnombretitular=" + dsnombretitular + ", transacciones=" + transacciones + ", tarjetas=" + tarjetas + '}';
    }
    
    
}
