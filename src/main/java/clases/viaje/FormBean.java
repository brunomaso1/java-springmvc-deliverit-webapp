package clases.viaje;

public class FormBean {
	
	private String nombre;
	
	private String calle;
	
	private String puerta;
	
	private String esquina;
	
	private String apartamento;
	
	private String telefono;
	
	private String aclaraciones;

	//Constructors
	public FormBean() {
	}

	public FormBean(String nombre, String calle, String puerta, String esquina, String apartamento, String telefono, String aclaraciones) {
		this.nombre = nombre;
		this.calle = calle;
		this.puerta = puerta;
		this.esquina = esquina;
		this.apartamento = apartamento;
		this.telefono = telefono;
		this.aclaraciones = aclaraciones;
	}

	//Getters and Setters
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public String getEsquina() {
		return esquina;
	}

	public void setEsquina(String esquina) {
		this.esquina = esquina;
	}

	public String getApartamento() {
		return apartamento;
	}

	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getAclaraciones() {
		return aclaraciones;
	}

	public void setAclaraciones(String aclaraciones) {
		this.aclaraciones = aclaraciones;
	}	
}