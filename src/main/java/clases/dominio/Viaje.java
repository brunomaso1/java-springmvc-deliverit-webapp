package clases.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Viaje {

	private Integer id;

	private Short calificacion;

	private short precio;

	private Collection<Transaccion> transaccionCollection;

	private Collection<Pedido> pedidos;

	private Delivery delivery;

	private Sucursal sucursal;

	private EstadoViaje estado;

	private Timestamp fecha;

	public Viaje() {
	}

	public Viaje(String precio, String sucursalId, String estado) {
		this.precio = Short.parseShort(precio);
		this.transaccionCollection = new ArrayList<>();
		this.pedidos = new ArrayList<>();
		this.sucursal = new Sucursal(Integer.valueOf(sucursalId));
		this.estado = new EstadoViaje(Integer.valueOf(estado));
		this.fecha = Timestamp.valueOf(LocalDateTime.now());
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

	public Collection<Pedido> getPedidoss() {
		return pedidos;
	}

	public void setPedidos(Collection<Pedido> pedidoCollection) {
		this.pedidos = pedidoCollection;
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

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "ucu.deliverit.backcore.entidades.Viaje[ id=" + id + " ]";
	}

}
