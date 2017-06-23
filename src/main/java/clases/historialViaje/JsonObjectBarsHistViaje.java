package clases.historialViaje;

public class JsonObjectBarsHistViaje {

	private String anioMes;
	private Integer costo;

	public JsonObjectBarsHistViaje(String anioMes, Integer ganancia) {
		this.anioMes = anioMes;
		this.costo = ganancia;
	}

	public String getAnioMes() {
		return anioMes;
	}

	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	private List<JsonObjectBarsHistViaje> mapToJSON(Map<String, Integer> map) {
		List<JsonObjectBarsHistViaje> jsonObjectBarsList = new ArrayList<>();
		// Agrego a la lista objetos del tipo JsonObjcetLine con clave y valor.
		map.forEach((k, v) -> jsonObjectBarsList.add(new JsonObjectBarsHistViaje(k, v)));
		return jsonObjectBarsList;
	}
}