package ar.unrn.tp3.modelo;

import ar.unrn.tp3.correo.MailTrapEnvioDeCorreo;
import ar.unrn.tp3.persistencia.EnArchivoPersistencia;

public class MainCorreos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EnvioDeCorreo servicio = new MailTrapEnvioDeCorreo();
		Empleados instancia= new EnArchivoPersistencia();
		
		Correos correo = new Correos(servicio, instancia);
		
		correo.enviarCorreos();

	}

}
