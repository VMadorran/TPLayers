package ar.unrn.oop2.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConcursosImplementacion implements Concursos {
	private Persistencia persistencia;
	private List<Concurso> concursos = new ArrayList<Concurso>();

	public ConcursosImplementacion(Persistencia persistencia) {
		this.persistencia = persistencia;
	}

	@Override
	public void crearInscripcion(String nombre, String apellido, String dni, String telefono, String correo,
			int idConcurso) throws Exception {
		// TODO Auto-generated method stub
		Email email = new Email(correo);
		Dni id = new Dni(dni);
		Telefono phone = new Telefono(telefono);
		Participante participante = new Participante(nombre, apellido, phone, email, id);

		LocalDate fechaDeInscripcion = LocalDate.of(2020, 6, 2);
		Inscripcion inscripcion = new Inscripcion(participante,idConcurso, fechaDeInscripcion);

		persistencia.registrarInscripcion(inscripcion);
	}

	@Override
	public List<Concurso> listaDeConcursosVigentes() {
		this.recuperarLinea(persistencia.recuperarConcursos());
		List<Concurso> concursosVigentes = new ArrayList<Concurso>();
		for (Concurso concurso : concursos) {
			if (concurso.estaVigente())
				concursosVigentes.add(concurso);
		}
		return concursosVigentes;
	}

	private Concurso recuperarConcurso(int id) {
		Concurso concurso = null;
		persistencia.recuperarConcurso(id);
		return concurso;
	}

	private void recuperarLinea(List<String> lineas) {

		for (int i = 0; i < lineas.size(); i++) {
			String lineaNueva = lineas.get(i);
			String[] datosConcurso = lineaNueva.split("\\,");
			this.reconstruirConcurso(datosConcurso);
		}

	}

	private void reconstruirConcurso(String[] linea) {

		LocalDate fechaInicio = LocalDate.parse(linea[2]);
		LocalDate fechaFin = LocalDate.parse(linea[3]);
		int idConcurso = Integer.parseInt(linea[0]);
		Concurso concurso = new Concurso(idConcurso, linea[1], fechaInicio, fechaFin);
		concursos.add(concurso);
	}

}
