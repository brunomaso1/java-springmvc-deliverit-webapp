/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigInteger;
import java.util.Collection;

/**
 *
 * @author JMArtegoytia
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurant  {

    private static final long serialVersionUID = 1L;

    private Integer id;
    
    private BigInteger rut;
    
    private String razonSocial;
    
    private Usuario usuario;
    
    private Collection<Sucursal> sucursalCollection;

    public Restaurant() {
    }

    public Restaurant(Integer id) {
        this.id = id;
    }

    public Restaurant(Integer id, BigInteger rut) {
        this.id = id;
        this.rut = rut;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getRut() {
        return rut;
    }

    public void setRut(BigInteger rut) {
        this.rut = rut;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Collection<Sucursal> getSucursalCollection() {
        return sucursalCollection;
    }

    public void setSucursalCollection(Collection<Sucursal> sucursalCollection) {
        this.sucursalCollection = sucursalCollection;
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
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucu.deliverit.backcore.entidades.Restaurant[ id=" + id + " ]";
    }
    
}