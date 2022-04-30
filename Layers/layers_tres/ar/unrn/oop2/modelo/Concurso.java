package ar.unrn.oop2.modelo;

import java.time.LocalDate;

public class Concurso {
	private int idConcurso;
	private String nombre;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinInscripcion;

	public Concurso(int idConcurso, String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) {

		this.idConcurso = idConcurso;
		this.nombre = nombre;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinInscripcion = fechaFinInscripcion;
	}
	
	public int idConcurso() {
		return this.idConcurso;
	}
	
	public String nombreConcurso() {
		return this.nombre;
	}

	public String datosDeConcurso() {
		return this.idConcurso+","+ this.nombre + "," + this.fechaFormatoCorto(fechaInicioInscripcion) + "," +
				this.fechaFormatoCorto(fechaFinInscripcion);
	}

	private String fechaFormatoCorto(LocalDate fecha) {

		String fechaString = String.format("%1$tm-%1$td-%1$tY", fecha);
		return fechaString;
	}
	
	public boolean estaVigente() {

		LocalDate fechaDeInscripcion= LocalDate.of(2020, 6, 2);
		return fechaDeInscripcion.isAfter(this.fechaInicioInscripcion)&& fechaDeInscripcion.isBefore(fechaFinInscripcion);
	}


}
