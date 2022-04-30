package ar.unrn.oop2.modelo;

public class Telefono {
	private String numeroDeTelefono;
	
	public Telefono(String numeroDeTelefono) throws Exception {
		if(this.validarTelefono(numeroDeTelefono))
			throw new Exception ("El tel�fono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		this.numeroDeTelefono = numeroDeTelefono;
	}
	
	private boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}
	
	protected String numeroDeTelefono() {
		return this.numeroDeTelefono;
	}

}
