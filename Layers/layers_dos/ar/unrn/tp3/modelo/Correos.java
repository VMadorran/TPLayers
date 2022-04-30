package ar.unrn.tp3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Correos {
	private EnvioDeCorreo servicio;
	private Empleados instancia;
	List<Empleado> empleados = new ArrayList<Empleado>();

	public Correos(EnvioDeCorreo servicio, Empleados instancia) {

		this.servicio = servicio;
		this.instancia = instancia;
	}

	public void enviarCorreos() {

		empleados = instancia.recuperarEmpleados();
		recorrerLista(empleados);
	}

	public void enviarCorreos(List<Empleado> empleados) {
		recorrerLista(empleados);
	}
	
	private void recorrerLista(List<Empleado> empleados) {
		for (Empleado empleado : empleados) {
			this.esSuCumple(empleado);
		}
	}
	private void esSuCumple(Empleado empleado) {
		if (empleado.esElCumple())	
			servicio.enviarCorreo(empleado.nombre(), empleado.direccionDeCorreo());
	}


}
