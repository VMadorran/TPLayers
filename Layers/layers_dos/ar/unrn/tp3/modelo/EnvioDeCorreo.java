package ar.unrn.tp3.modelo;

public interface EnvioDeCorreo {

	public void enviarCorreo(String nombre, String correoDelEmpleado);
	public String recuperarContenidoDeCorreo();
}
