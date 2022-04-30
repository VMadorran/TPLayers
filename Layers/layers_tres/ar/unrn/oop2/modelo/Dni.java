package ar.unrn.oop2.modelo;

public class Dni {
	String dni;
	
	public Dni(String dni) throws Exception {
		if(this.datoNulo(dni))
			throw new Exception("dni no puede ser vacio");
		this.dni = dni;
	}
	
	private boolean datoNulo(String dato) {
		return dato.equals("");
	}
	

}
