package ar.unrn.tp3.modelo;

public class ParticipantesImplementacion implements Participantes{

	Persistencia persistencia; 
	public ParticipantesImplementacion(Persistencia persistencia) {
		this.persistencia = persistencia;
	}
	
	@Override
	public void crearParticipante(String nombre, String region, String telefono) throws Exception {
		// TODO Auto-generated method stub
		Telefono telefonoDeParticipante = new Telefono(telefono);
		Region regionParticipante = new Region(region);
		Participante participante = new Participante (nombre,regionParticipante, telefonoDeParticipante);
		
		persistencia.cargarParticipante(participante);
	}
}
