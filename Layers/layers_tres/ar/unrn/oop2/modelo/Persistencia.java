package ar.unrn.oop2.modelo;

import java.util.List;

public interface Persistencia {

	public List<String> recuperarConcursos();//cambiar a String
	public void registrarInscripcion(Inscripcion inscripcion);
	public String recuperarConcurso(int idConcurso);//Cambiar a String
}
