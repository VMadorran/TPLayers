package ar.unrn.tp3.modelo;

import java.time.LocalDate;

public class Empleado {
	private String nombre;
	private String apellido;
	private Email email;
	private LocalDate fechaDeNacimiento;

	public Empleado(String nombre, String apellido, Email email, LocalDate fechaDeNacimiento) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	protected String nombre() {
		return this.nombre+" " + this.apellido+ " ";
	}

	protected String direccionDeCorreo() {
		return this.email.direccionDeEmail();
	}

	protected boolean esElCumple() {

		LocalDate fecha = LocalDate.of(2022, 9, 11);
		//1975, 9, 11
		
		boolean esIgual = false;
		if ((fecha.getDayOfMonth() == (this.fechaDeNacimiento.getDayOfMonth()))
				&& (fecha.getMonth().equals(fechaDeNacimiento.getMonth())))
			esIgual = true;
		return esIgual;
	}

}
