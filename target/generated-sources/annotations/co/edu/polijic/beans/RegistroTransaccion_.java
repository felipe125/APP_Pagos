package co.edu.polijic.beans;

import co.edu.polijic.beans.EstadoTransaccion;
import co.edu.polijic.beans.Transaccion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-27T19:57:27")
@StaticMetamodel(RegistroTransaccion.class)
public class RegistroTransaccion_ { 

    public static volatile SingularAttribute<RegistroTransaccion, EstadoTransaccion> cdestado;
    public static volatile SingularAttribute<RegistroTransaccion, String> dsobservaciones;
    public static volatile SingularAttribute<RegistroTransaccion, Transaccion> cdtransaccion;
    public static volatile SingularAttribute<RegistroTransaccion, Integer> cdregistro;
    public static volatile SingularAttribute<RegistroTransaccion, Date> fefechatransaccion;

}