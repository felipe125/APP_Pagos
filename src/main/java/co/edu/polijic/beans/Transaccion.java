/*
 * Politecnico Colombiano Jaime Isaza Cadavid
 * All Copyright Reserved
 * 2015
 */
package co.edu.polijic.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "transaccion")
public class Transaccion implements Serializable {
    @Id
    @Column(name = "cdtransaccion")
    private Integer cdtransaccion;
    @Column(name = "cdcuentadestino")
    private int cdcuentadestino;
    @Column(name = "vltransaccion")
    private BigDecimal vltransaccion;
    @Column(name = "nmcuotaspago")
    private int nmcuotaspago;
    @OneToMany(mappedBy = "cdtransaccion")
    private List<RegistroTransaccion> registrosTransacciones;
    @ManyToOne
    @JoinColumn(name = "cdcuentaorigen", referencedColumnName = "cdcuentabancaria")
    private CuentaBancaria cdcuentaorigen;
    @ManyToOne
    @JoinColumn(name = "cdtipopago", referencedColumnName = "cdtipopago")
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
        return registrosTransacciones;
    }

    public void setRegistroTransaccionList(List<RegistroTransaccion> registroTransaccionList) {
        this.registrosTransacciones = registroTransaccionList;
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
    public String toString() {
        return "Transaccion{" + "cdtransaccion=" + cdtransaccion + ", cdcuentadestino=" + cdcuentadestino + ", vltransaccion=" + vltransaccion + ", nmcuotaspago=" + nmcuotaspago + ", registrosTransacciones=" + registrosTransacciones + ", cdcuentaorigen=" + cdcuentaorigen + ", cdtipopago=" + cdtipopago + '}';
    }

    
    
}
