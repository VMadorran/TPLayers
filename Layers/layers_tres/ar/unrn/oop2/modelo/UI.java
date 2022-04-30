package ar.unrn.oop2.modelo;

import java.util.List;

public interface UI {
	public void formElements();
	public List<Concurso> todosLosConcursos();
	public  void saveInscription(int lineaSeleccionada);
	public void layout();
}
