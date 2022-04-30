package ar.unrn.tp3.modelo;


public class Telefono {
	private String numeroDeTelefono;
	
	public Telefono(String numeroDeTelefono) throws Exception {
		if(this.validarTelefono(numeroDeTelefono))
			throw new Exception ("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		if((this.datoNulo(numeroDeTelefono)))
			throw new Exception("Debe cargar un telefono");
		
		
		this.numeroDeTelefono = numeroDeTelefono;
	}
	
	private boolean datoNulo(String dato) {
		return dato == null | dato.isEmpty();
	}
	
	private boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}
	
	protected String numeroDeTelefono() {
		return this.numeroDeTelefono;
	}

}
