package co.edu.polijic.beans;

import co.edu.polijic.beans.Tarjeta;
import co.edu.polijic.beans.Transaccion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-27T19:57:27")
@StaticMetamodel(CuentaBancaria.class)
public class CuentaBancaria_ { 

    public static volatile SingularAttribute<CuentaBancaria, String> nmcuentabancaria;
    public static volatile ListAttribute<CuentaBancaria, Tarjeta> tarjetas;
    public static volatile ListAttribute<CuentaBancaria, Transaccion> transacciones;
    public static volatile SingularAttribute<CuentaBancaria, Integer> cdcuentabancaria;
    public static volatile SingularAttribute<CuentaBancaria, String> dsnombretitular;

}