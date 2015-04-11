/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.app_pagos.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Tarjeta.findByOpfranquicia", query = "SELECT t FROM Tarjeta t WHERE t.opfranquicia = :opfranquicia"),
    @NamedQuery(name = "Tarjeta.findByOpestadotarjeta", query = "SELECT t FROM Tarjeta t WHERE t.opestadotarjeta = :opestadotarjeta"),
    @NamedQuery(name = "Tarjeta.findByOptipotarjeta", query = "SELECT t FROM Tarjeta t WHERE t.optipotarjeta = :optipotarjeta"),
    @NamedQuery(name = "Tarjeta.findByNmtarjeta", query = "SELECT t FROM Tarjeta t WHERE t.nmtarjeta = :nmtarjeta"),
    @NamedQuery(name = "Tarjeta.findByDsmesvencimiento", query = "SELECT t FROM Tarjeta t WHERE t.dsmesvencimiento = :dsmesvencimiento"),
    @NamedQuery(name = "Tarjeta.findByDsaniovencimiento", query = "SELECT t FROM Tarjeta t WHERE t.dsaniovencimiento = :dsaniovencimiento"),
    @NamedQuery(name = "Tarjeta.findByCdseguridad", query = "SELECT t FROM Tarjeta t WHERE t.cdseguridad = :cdseguridad"),
    @NamedQuery(name = "Tarjeta.findByDsnombretitular", query = "SELECT t FROM Tarjeta t WHERE t.dsnombretitular = :dsnombretitular")})
public class Tarjeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cdtarjeta")
    private Integer cdtarjeta;
    @Basic(optional = false)
    @Column(name = "opfranquicia")
    private String opfranquicia;
    @Basic(optional = false)
    @Column(name = "opestadotarjeta")
    private String opestadotarjeta;
    @Basic(optional = false)
    @Column(name = "optipotarjeta")
    private String optipotarjeta;
    @Basic(optional = false)
    @Column(name = "nmtarjeta")
    private int nmtarjeta;
    @Basic(optional = false)
    @Column(name = "dsmesvencimiento")
    private String dsmesvencimiento;
    @Basic(optional = false)
    @Column(name = "dsaniovencimiento")
    private String dsaniovencimiento;
    @Basic(optional = false)
    @Column(name = "cdseguridad")
    private int cdseguridad;
    @Column(name = "dsnombretitular")
    private String dsnombretitular;
    @JoinColumn(name = "cdtransaccion", referencedColumnName = "cdtransaccion")
    @ManyToOne(optional = false)
    private Transaccion cdtransaccion;

    public Tarjeta() {
    }

    public Tarjeta(Integer cdtarjeta) {
        this.cdtarjeta = cdtarjeta;
    }

    public Tarjeta(Integer cdtarjeta, String opfranquicia, String opestadotarjeta, String optipotarjeta, int nmtarjeta, String dsmesvencimiento, String dsaniovencimiento, int cdseguridad) {
        this.cdtarjeta = cdtarjeta;
        this.opfranquicia = opfranquicia;
        this.opestadotarjeta = opestadotarjeta;
        this.optipotarjeta = optipotarjeta;
        this.nmtarjeta = nmtarjeta;
        this.dsmesvencimiento = dsmesvencimiento;
        this.dsaniovencimiento = dsaniovencimiento;
        this.cdseguridad = cdseguridad;
    }

    public Integer getCdtarjeta() {
        return cdtarjeta;
    }

    public void setCdtarjeta(Integer cdtarjeta) {
        this.cdtarjeta = cdtarjeta;
    }

    public String getOpfranquicia() {
        return opfranquicia;
    }

    public void setOpfranquicia(String opfranquicia) {
        this.opfranquicia = opfranquicia;
    }

    public String getOpestadotarjeta() {
        return opestadotarjeta;
    }

    public void setOpestadotarjeta(String opestadotarjeta) {
        this.opestadotarjeta = opestadotarjeta;
    }

    public String getOptipotarjeta() {
        return optipotarjeta;
    }

    public void setOptipotarjeta(String optipotarjeta) {
        this.optipotarjeta = optipotarjeta;
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

    public String getDsnombretitular() {
        return dsnombretitular;
    }

    public void setDsnombretitular(String dsnombretitular) {
        this.dsnombretitular = dsnombretitular;
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
        return "co.edu.polijic.app_pagos.model.Tarjeta[ cdtarjeta=" + cdtarjeta + " ]";
    }
    
}
