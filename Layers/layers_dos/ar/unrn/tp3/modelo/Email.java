package ar.unrn.tp3.modelo;

public class Email {
	private String direccion;
	
	public Email (String direccion) {
		this.direccion = direccion;
	}

	
	protected String direccionDeEmail() {
		return this.direccion;
	}

}
