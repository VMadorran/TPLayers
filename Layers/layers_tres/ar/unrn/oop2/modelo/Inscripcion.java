package ar.unrn.oop2.modelo;

import java.time.LocalDate;

public class Inscripcion {
	private Participante inscripto;
	private int idConcurso;
	private LocalDate fechaDeInscripcion;

	public Inscripcion(Participante inscripto, int idConcurso, LocalDate fechaDeInscripcion) {

		this.inscripto = inscripto;
		this.idConcurso = idConcurso;
		this.fechaDeInscripcion = fechaDeInscripcion;
	}
	
	public String datosDeInscripcion() {
		return inscripto.datoDelParticipante() + "," + this.idConcurso;
	}

}
