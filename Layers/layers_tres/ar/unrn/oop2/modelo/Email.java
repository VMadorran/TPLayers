package ar.unrn.oop2.modelo;

public class Email {
	private String direccion;
	
	public Email (String direccion) throws Exception {
		if(!this.checkEmail(direccion))
			throw new Exception("email debe ser válido");
		this.direccion = direccion;
	}
	
	private boolean checkEmail(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
	
	protected String direccionDeEmail() {
		return this.direccion;
	}

}
