package co.edu.polijic.beans;

import co.edu.polijic.beans.CuentaBancaria;
import co.edu.polijic.beans.EstadoTarjeta;
import co.edu.polijic.beans.Franquicia;
import co.edu.polijic.beans.TipoTarjeta;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-28T09:40:33")
@StaticMetamodel(Tarjeta.class)
public class Tarjeta_ { 

    public static volatile SingularAttribute<Tarjeta, Integer> cdtarjeta;
    public static volatile SingularAttribute<Tarjeta, TipoTarjeta> optipotarjeta;
    public static volatile SingularAttribute<Tarjeta, Integer> nmtarjeta;
    public static volatile SingularAttribute<Tarjeta, Franquicia> opfranquicia;
    public static volatile SingularAttribute<Tarjeta, String> dsmesvencimiento;
    public static volatile SingularAttribute<Tarjeta, String> dsaniovencimiento;
    public static volatile SingularAttribute<Tarjeta, Integer> cdseguridad;
    public static volatile SingularAttribute<Tarjeta, EstadoTarjeta> opestadotarjeta;
    public static volatile SingularAttribute<Tarjeta, CuentaBancaria> cdcuentabancaria;

}