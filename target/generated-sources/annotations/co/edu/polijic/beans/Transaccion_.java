package co.edu.polijic.beans;

import co.edu.polijic.beans.CuentaBancaria;
import co.edu.polijic.beans.RegistroTransaccion;
import co.edu.polijic.beans.TipoPago;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-27T19:57:27")
@StaticMetamodel(Transaccion.class)
public class Transaccion_ { 

    public static volatile SingularAttribute<Transaccion, CuentaBancaria> cdcuentaorigen;
    public static volatile SingularAttribute<Transaccion, Integer> cdcuentadestino;
    public static volatile SingularAttribute<Transaccion, BigDecimal> vltransaccion;
    public static volatile SingularAttribute<Transaccion, TipoPago> cdtipopago;
    public static volatile SingularAttribute<Transaccion, Integer> cdtransaccion;
    public static volatile SingularAttribute<Transaccion, Integer> nmcuotaspago;
    public static volatile ListAttribute<Transaccion, RegistroTransaccion> registroTransaccionList;

}