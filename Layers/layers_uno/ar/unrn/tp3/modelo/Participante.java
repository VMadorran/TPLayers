package ar.unrn.tp3.modelo;

public class Participante {
	private String nombre;
	private Region region;
	private Telefono telefono;
	
	public Participante(String nombre, Region region, Telefono telefono) throws Exception {
		if(this.datoNulo(nombre))
			throw new Exception("Debe cargar un nombre");
		
		this.nombre = nombre;
		this.region = region;
		this.telefono= telefono;
	}
	
	
	private boolean datoNulo(String dato) {
		return dato.equals("");
	}
	
	public String regionDelParticipante() {
		return this.region.nombreDeLaRegion();
	}
	
	public String telefonoDelParticipante() {
		return this.telefono.numeroDeTelefono();
	}
	
	public String nombreDelParticipante() {
		return this.nombre;
	}

}
