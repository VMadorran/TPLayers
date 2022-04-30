package ar.unrn.oop2.modelo;

import java.util.List;

public interface Concursos {

	public void crearInscripcion(String nombre, String apellido, String dni, String telefono, String correo,
			int idConcurso) throws Exception;
	public List<Concurso> listaDeConcursosVigentes();
}
