/*
 * Politecnico Colombiano Jaime Isaza Cadavid
 * All Copyright Reserved
 * 2015
 */
package co.edu.polijic.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Johan Felipe Bedoya
 * @author Natalia Diaz Padilla
 * @author Vanessa Agudelo Marin
 * @version 1.0
 */
@Entity
@Table(name = "tarjeta")
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
    @ManyToOne
    @JoinColumn(name = "cdcuentabancaria", referencedColumnName = "cdcuentabancaria")
    private CuentaBancaria cdcuentabancaria;
    @Column(name="opestadotarjeta")
    @Enumerated(EnumType.STRING)  
    private EstadoTarjeta opestadotarjeta;
    @Column(name="opfranquicia")
    @Enumerated(EnumType.STRING)
    private Franquicia opfranquicia;
    @Column(name="optipotarjeta")
    @Enumerated(EnumType.STRING)
    private TipoTarjeta optipotarjeta;

    public Tarjeta() {
    }
    
    
    public Tarjeta(Integer cdtarjeta, int nmtarjeta, String dsmesvencimiento, String dsaniovencimiento, int cdseguridad, CuentaBancaria cdcuentabancaria, EstadoTarjeta cdestadotarjeta, Franquicia cdfranquicia, TipoTarjeta cdtipotarjeta) {
        this.cdtarjeta = cdtarjeta;
        this.nmtarjeta = nmtarjeta;
        this.dsmesvencimiento = dsmesvencimiento;
        this.dsaniovencimiento = dsaniovencimiento;
        this.cdseguridad = cdseguridad;
        this.cdcuentabancaria = cdcuentabancaria;
        this.opestadotarjeta = cdestadotarjeta;
        this.opfranquicia = cdfranquicia;
        this.optipotarjeta = cdtipotarjeta;
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
        return opestadotarjeta;
    }

    public void setCdestadotarjeta(EstadoTarjeta cdestadotarjeta) {
        this.opestadotarjeta = cdestadotarjeta;
    }

    public Franquicia getCdfranquicia() {
        return opfranquicia;
    }

    public void setCdfranquicia(Franquicia cdfranquicia) {
        this.opfranquicia = cdfranquicia;
    }

    public TipoTarjeta getCdtipotarjeta() {
        return optipotarjeta;
    }

    public void setCdtipotarjeta(TipoTarjeta cdtipotarjeta) {
        this.optipotarjeta = cdtipotarjeta;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "cdtarjeta=" + cdtarjeta + ", nmtarjeta=" + nmtarjeta + ", dsmesvencimiento=" + dsmesvencimiento + ", dsaniovencimiento=" + dsaniovencimiento + ", cdseguridad=" + cdseguridad + ", cdcuentabancaria=" + cdcuentabancaria + ", cdestadotarjeta=" + opestadotarjeta + ", cdfranquicia=" + opfranquicia + ", cdtipotarjeta=" + optipotarjeta + '}';
    }

}
