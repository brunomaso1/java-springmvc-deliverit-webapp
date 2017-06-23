package clases.historialViaje;

public class JsonObjectLineHistViaje {

	private String anioMes;
	private Integer viajes;

	public JsonObjectLineHistViaje(String anioMes, Integer viajes) {
		this.anioMes = anioMes;
		this.viajes = viajes;
	}

	public String getAnioMes() {
		return anioMes;
	}

	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}

	public Integer getViajes() {
		return viajes;
	}

	public void setViajes(Integer viajes) {
		this.viajes = viajes;
	}

	private List<JsonObjectLineHistViaje> mapToJSON (Map<String, Integer> map) {
		List<JsonObjectLineHistViaje> jsonObjectLineList = new ArrayList<>();
		// Agrego a la lista objetos del tipo JsonObjcetLine con clave y valor.
		map.forEach((k, v) -> jsonObjectLineList.add(new JsonObjectLineHistViaje(k, v)));
		return jsonObjectLineList;
	}
}