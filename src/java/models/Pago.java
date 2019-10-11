/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabri
 */
@Entity
@Table(name = "pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p")
    , @NamedQuery(name = "Pago.findByIdCompra", query = "SELECT p FROM Pago p WHERE p.idCompra = :idCompra")
    , @NamedQuery(name = "Pago.findByNombreCliente", query = "SELECT p FROM Pago p WHERE p.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "Pago.findByIdCliente", query = "SELECT p FROM Pago p WHERE p.idCliente = :idCliente")
    , @NamedQuery(name = "Pago.findByNombreCel", query = "SELECT p FROM Pago p WHERE p.nombreCel = :nombreCel")
    , @NamedQuery(name = "Pago.findByPrecioCel", query = "SELECT p FROM Pago p WHERE p.precioCel = :precioCel")
    , @NamedQuery(name = "Pago.findByDescuento", query = "SELECT p FROM Pago p WHERE p.descuento = :descuento")
    , @NamedQuery(name = "Pago.findByTotal", query = "SELECT p FROM Pago p WHERE p.total = :total")
    , @NamedQuery(name = "Pago.findByTarjeta", query = "SELECT p FROM Pago p WHERE p.tarjeta = :tarjeta")})
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_compra")
    private Integer idCompra;
    @Size(max = 64)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Size(max = 11)
    @Column(name = "id_cliente")
    private String idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "nombre_cel")
    private String nombreCel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_cel")
    private double precioCel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "descuento")
    private Double descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tarjeta")
    private String tarjeta;

    public Pago() {
    }

    public Pago(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Pago(Integer idCompra, String nombreCel, double precioCel, double total, String tarjeta) {
        this.idCompra = idCompra;
        this.nombreCel = nombreCel;
        this.precioCel = precioCel;
        this.total = total;
        this.tarjeta = tarjeta;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCel() {
        return nombreCel;
    }

    public void setNombreCel(String nombreCel) {
        this.nombreCel = nombreCel;
    }

    public double getPrecioCel() {
        return precioCel;
    }

    public void setPrecioCel(double precioCel) {
        this.precioCel = precioCel;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Pago[ idCompra=" + idCompra + " ]";
    }

}
