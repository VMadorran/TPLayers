package ar.unrn.tp3.correo;

import ar.unrn.tp3.modelo.EnvioDeCorreo;

public class ServicioEnvioDeCorreo implements EnvioDeCorreo {

	private String contenido="";

	@Override
	public void enviarCorreo(String nombre, String correoDelEmpleado) {
		// TODO Auto-generated method stub
	
		this.contenido += nombre + correoDelEmpleado;
	}

	@Override
	public String recuperarContenidoDeCorreo() {
		// TODO Auto-generated method stub
		return this.contenido;
	}

}
