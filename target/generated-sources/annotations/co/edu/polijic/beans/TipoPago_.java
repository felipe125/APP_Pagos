package co.edu.polijic.beans;

import co.edu.polijic.beans.Transaccion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-28T09:40:33")
@StaticMetamodel(TipoPago.class)
public class TipoPago_ { 

    public static volatile SingularAttribute<TipoPago, Integer> cdtipopago;
    public static volatile SingularAttribute<TipoPago, String> dsdescripcion;
    public static volatile ListAttribute<TipoPago, Transaccion> transacciones;

}