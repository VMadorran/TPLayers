package ar.unrn.tp3.ui;

import java.awt.EventQueue;

import ar.unrn.tp3.bd.EnBasePersistencia;
import ar.unrn.tp3.modelo.Participantes;
import ar.unrn.tp3.modelo.ParticipantesImplementacion;
import ar.unrn.tp3.modelo.Persistencia;
public class Main {
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Persistencia enBase = new EnBasePersistencia();
					Participantes interfaz = new ParticipantesImplementacion(enBase);
					new AgregarUI(interfaz);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
	}
}
