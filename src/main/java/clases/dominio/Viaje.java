/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Collection;

/**
 *
 * @author JMArtegoytia
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Viaje {

    private Integer id;
    
    private Short calificacion;
	
    private short precio;
    
    private Collection<Transaccion> transaccionCollection;
	
    private Collection<Pedido> pedidoCollection;
    
    private Delivery delivery;
    
    private Sucursal sucursal;

    private EstadoViaje estado;

    public Viaje() {
    }

    public Viaje(Integer id) {
        this.id = id;
    }

    public Viaje(Integer id, short precio) {
        this.id = id;
        this.precio = precio;
    }

	public Viaje(Integer id, Short calificacion, short precio, Collection<Transaccion> transaccionCollection, Collection<Pedido> pedidoCollection, Delivery delivery, Sucursal sucursal, EstadoViaje estado) {
		this.id = id;
		this.calificacion = calificacion;
		this.precio = precio;
		this.transaccionCollection = transaccionCollection;
		this.pedidoCollection = pedidoCollection;
		this.delivery = delivery;
		this.sucursal = sucursal;
		this.estado = estado;
	}
	
	

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Short calificacion) {
        this.calificacion = calificacion;
    }

    public short getPrecio() {
        return precio;
    }

    public void setPrecio(short precio) {
        this.precio = precio;
    }

    public Collection<Transaccion> getTransaccionCollection() {
        return transaccionCollection;
    }

    public void setTransaccionCollection(Collection<Transaccion> transaccionCollection) {
        this.transaccionCollection = transaccionCollection;
    }

    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public EstadoViaje getEstado() {
        return estado;
    }

    public void setEstado(EstadoViaje estado) {
        this.estado = estado;
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
        if (!(object instanceof Viaje)) {
            return false;
        }
        Viaje other = (Viaje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucu.deliverit.backcore.entidades.Viaje[ id=" + id + " ]";
    }
    
}