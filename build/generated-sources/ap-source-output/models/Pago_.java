package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T01:14:03")
@StaticMetamodel(Pago.class)
public class Pago_ { 

    public static volatile SingularAttribute<Pago, String> nombreCel;
    public static volatile SingularAttribute<Pago, Double> precioCel;
    public static volatile SingularAttribute<Pago, Double> total;
    public static volatile SingularAttribute<Pago, String> nombreCliente;
    public static volatile SingularAttribute<Pago, String> idCliente;
    public static volatile SingularAttribute<Pago, Double> descuento;
    public static volatile SingularAttribute<Pago, Integer> idCompra;
    public static volatile SingularAttribute<Pago, String> tarjeta;

}