/*
 * Politecnico Colombiano Jaime Isaza Cadavid
 * All Copyright Reserved
 * 2015
 */
package co.edu.polijic.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Johan Felipe Bedoya
 * @author Natalia Diaz Padilla
 * @author Vanessa Agudelo Marin
 * @version 1.0
 */
@Entity
@Table(name = "registro_transaccion")
public class RegistroTransaccion implements Serializable {

    @Id
    @Column(name = "cdregistro")
    private Integer cdregistro;
    @Column(name = "fefechatransaccion")
    @Temporal(TemporalType.DATE)
    private Date fefechatransaccion;
    @Column(name = "dsobservaciones")
    private String dsobservaciones;
    @Column(name="opestado")
    @Enumerated(EnumType.STRING)  
    private EstadoTransaccion cdestado;
    @JoinColumn(name = "cdtransaccion", referencedColumnName = "cdtransaccion")
    @ManyToOne
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
    public String toString() {
        return "RegistroTransaccion{" + "cdregistro=" + cdregistro + ", fefechatransaccion=" + fefechatransaccion + ", dsobservaciones=" + dsobservaciones + ", cdestado=" + cdestado + ", cdtransaccion=" + cdtransaccion + '}';
    }

}
