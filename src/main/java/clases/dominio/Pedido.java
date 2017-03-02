package clases.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pedido {

	protected PedidoPK pedidoPK;

	private String detalle;

	private String formaPago;

	private Viaje viaje;

	private Cliente cliente;

	public Pedido() {
	}

	public Pedido(String detalle, String formaPago, Cliente cliente) {
		this.pedidoPK = new PedidoPK();
		this.detalle = detalle;
		this.formaPago = formaPago;
		this.cliente = cliente;
	}

	public PedidoPK getPedidoPK() {
		return pedidoPK;
	}

	public void setPedidoPK(PedidoPK pedidoPK) {
		this.pedidoPK = pedidoPK;
	}
	
	public void setPedidoPK(int pedidoId, int viajeId) {
		this.pedidoPK.setId(pedidoId);
		this.pedidoPK.setViaje(viajeId);
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

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (pedidoPK != null ? pedidoPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Pedido)) {
			return false;
		}
		Pedido other = (Pedido) object;
		if ((this.pedidoPK == null && other.pedidoPK != null) || (this.pedidoPK != null && !this.pedidoPK.equals(other.pedidoPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ucu.deliverit.backcore.entidades.Pedido[ pedidoPK=" + pedidoPK + " ]";
	}

}
