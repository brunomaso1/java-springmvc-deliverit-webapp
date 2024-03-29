package clases.dominio;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pedido {

	private Integer id;
	private String detalle;
	private String formaPago;
	private Viaje viaje;
	private Cliente cliente;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", timezone="America/Montevideo")
	private Timestamp fecha;

	public Pedido() {
	}

	public Pedido(String detalle, String formaPago, Cliente cliente) {
		this.detalle = detalle;
		this.formaPago = formaPago;
		this.cliente = cliente;
		// Pone la fecha de hoy.
		this.fecha = Timestamp.valueOf(LocalDateTime.now());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "ucu.deliverit.backcore.entidades.Pedido[ pedidoId=" + id + " ]";
	}
}
