package ar.unrn.oop2.ui;

import javax.swing.SwingUtilities;

import ar.unrn.oop2.modelo.ConcursosImplementacion;
import ar.unrn.oop2.modelo.Concursos;
import ar.unrn.oop2.modelo.Persistencia;
import ar.unrn.oop2.persistencia.EnArchivoPersistencia;

public class MainRadio {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					
					Persistencia persistencia = new EnArchivoPersistencia();
					Concursos interfaz = new ConcursosImplementacion(persistencia);
					new MainRadio().start(interfaz);
				} catch (Exception e) {
// log exception...
					System.out.println(e);
				}
			}
		});
	}

	private void start(Concursos interfaz) {
		
		new RadioCompetitionUI(interfaz);
	}
}
