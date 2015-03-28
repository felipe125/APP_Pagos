/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.beans;

import java.io.Serializable;
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

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "tarjeta")
@NamedQueries({
    @NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t"),
    @NamedQuery(name = "Tarjeta.findByCdtarjeta", query = "SELECT t FROM Tarjeta t WHERE t.cdtarjeta = :cdtarjeta"),
    @NamedQuery(name = "Tarjeta.findByNmtarjeta", query = "SELECT t FROM Tarjeta t WHERE t.nmtarjeta = :nmtarjeta"),
    @NamedQuery(name = "Tarjeta.findByDsmesvencimiento", query = "SELECT t FROM Tarjeta t WHERE t.dsmesvencimiento = :dsmesvencimiento"),
    @NamedQuery(name = "Tarjeta.findByDsaniovencimiento", query = "SELECT t FROM Tarjeta t WHERE t.dsaniovencimiento = :dsaniovencimiento"),
    @NamedQuery(name = "Tarjeta.findByCdseguridad", query = "SELECT t FROM Tarjeta t WHERE t.cdseguridad = :cdseguridad")})
public class Tarjeta implements Serializable {
    @Id
    @Column(name = "cdtarjeta")
    private Integer cdtarjeta;
    @Column(name = "nmtarjeta")
    private int nmtarjeta;
    @Column(name = "dsmesvencimiento")
    private String dsmesvencimiento;
    @Column(name = "dsaniovencimiento")
    private String dsaniovencimiento;
    @Column(name = "cdseguridad")
    private int cdseguridad;
    //@Column(name="cdcuentabancaria")
    @JoinColumn(name = "cdcuentabancaria", referencedColumnName = "cdcuentabancaria")
    @ManyToOne
    private CuentaBancaria cdcuentabancaria;
    @Column(name="cdestadotarjeta")
    @Enumerated(EnumType.STRING)  
    private EstadoTarjeta cdestadotarjeta;
    @Column(name="cdfranquicia")
    @Enumerated(EnumType.STRING)    
    private Franquicia cdfranquicia;
    @Column(name="cdtipotarjeta")
    @Enumerated(EnumType.STRING)  
    private TipoTarjeta cdtipotarjeta;

    public Tarjeta() {
    }
    
    
    public Tarjeta(Integer cdtarjeta, int nmtarjeta, String dsmesvencimiento, String dsaniovencimiento, int cdseguridad, CuentaBancaria cdcuentabancaria, EstadoTarjeta cdestadotarjeta, Franquicia cdfranquicia, TipoTarjeta cdtipotarjeta) {
        this.cdtarjeta = cdtarjeta;
        this.nmtarjeta = nmtarjeta;
        this.dsmesvencimiento = dsmesvencimiento;
        this.dsaniovencimiento = dsaniovencimiento;
        this.cdseguridad = cdseguridad;
        this.cdcuentabancaria = cdcuentabancaria;
        this.cdestadotarjeta = cdestadotarjeta;
        this.cdfranquicia = cdfranquicia;
        this.cdtipotarjeta = cdtipotarjeta;
    }

    

    public Integer getCdtarjeta() {
        return cdtarjeta;
    }

    public void setCdtarjeta(Integer cdtarjeta) {
        this.cdtarjeta = cdtarjeta;
    }

    public int getNmtarjeta() {
        return nmtarjeta;
    }

    public void setNmtarjeta(int nmtarjeta) {
        this.nmtarjeta = nmtarjeta;
    }

    public String getDsmesvencimiento() {
        return dsmesvencimiento;
    }

    public void setDsmesvencimiento(String dsmesvencimiento) {
        this.dsmesvencimiento = dsmesvencimiento;
    }

    public String getDsaniovencimiento() {
        return dsaniovencimiento;
    }

    public void setDsaniovencimiento(String dsaniovencimiento) {
        this.dsaniovencimiento = dsaniovencimiento;
    }

    public int getCdseguridad() {
        return cdseguridad;
    }

    public void setCdseguridad(int cdseguridad) {
        this.cdseguridad = cdseguridad;
    }

    public CuentaBancaria getCdcuentabancaria() {
        return cdcuentabancaria;
    }

    public void setCdcuentabancaria(CuentaBancaria cdcuentabancaria) {
        this.cdcuentabancaria = cdcuentabancaria;
    }

    public EstadoTarjeta getCdestadotarjeta() {
        return cdestadotarjeta;
    }

    public void setCdestadotarjeta(EstadoTarjeta cdestadotarjeta) {
        this.cdestadotarjeta = cdestadotarjeta;
    }

    public Franquicia getCdfranquicia() {
        return cdfranquicia;
    }

    public void setCdfranquicia(Franquicia cdfranquicia) {
        this.cdfranquicia = cdfranquicia;
    }

    public TipoTarjeta getCdtipotarjeta() {
        return cdtipotarjeta;
    }

    public void setCdtipotarjeta(TipoTarjeta cdtipotarjeta) {
        this.cdtipotarjeta = cdtipotarjeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdtarjeta != null ? cdtarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjeta)) {
            return false;
        }
        Tarjeta other = (Tarjeta) object;
        if ((this.cdtarjeta == null && other.cdtarjeta != null) || (this.cdtarjeta != null && !this.cdtarjeta.equals(other.cdtarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "cdtarjeta=" + cdtarjeta + ", nmtarjeta=" + nmtarjeta + ", dsmesvencimiento=" + dsmesvencimiento + ", dsaniovencimiento=" + dsaniovencimiento + ", cdseguridad=" + cdseguridad + ", cdcuentabancaria=" + cdcuentabancaria + ", cdestadotarjeta=" + cdestadotarjeta + ", cdfranquicia=" + cdfranquicia + ", cdtipotarjeta=" + cdtipotarjeta + '}';
    }

    
    
    
}
