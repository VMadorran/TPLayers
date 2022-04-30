package ar.unrn.oop2.modelo;

public class Participante {
	private String nombre;
	private String apellido;
	private Telefono telefono;
	private Email email;
	private Dni dni;
	
	public Participante(String nombre, String apellido, Telefono telefono, Email email, Dni dni) throws Exception {
		if(this.datoNulo(nombre))
			throw new Exception("Nombre no puede ser vacio");
		if(this.datoNulo(apellido))
			throw new Exception("apellido no puede ser vacio");
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.dni = dni;
	}
	
	private boolean datoNulo(String dato) {
		return dato.equals("");
	}
	protected String datoDelParticipante() {
		return this.apellido + "," + this.nombre + "," + this.email.direccionDeEmail();
	}

}
