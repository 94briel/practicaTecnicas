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
@Table(name = "descuento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descuento.findAll", query = "SELECT d FROM Descuento d")
    , @NamedQuery(name = "Descuento.findById", query = "SELECT d FROM Descuento d WHERE d.id = :id")
    , @NamedQuery(name = "Descuento.findByDescuento", query = "SELECT d FROM Descuento d WHERE d.descuento = :descuento")
    , @NamedQuery(name = "Descuento.findByPorcentajeDesc", query = "SELECT d FROM Descuento d WHERE d.porcentajeDesc = :porcentajeDesc")})
public class Descuento implements Serializable {

    @Size(max = 64)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje")
    private double porcentaje;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "descuento")
    private String descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje_desc")
    private double porcentajeDesc;

    public Descuento() {
    }

    public Descuento(Integer id) {
        this.id = id;
    }

    public Descuento(Integer id, String descuento, double porcentajeDesc) {
        this.id = id;
        this.descuento = descuento;
        this.porcentajeDesc = porcentajeDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public double getPorcentajeDesc() {
        return porcentajeDesc;
    }

    public void setPorcentajeDesc(double porcentajeDesc) {
        this.porcentajeDesc = porcentajeDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descuento)) {
            return false;
        }
        Descuento other = (Descuento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Descuento[ id=" + id + " ]";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
}
