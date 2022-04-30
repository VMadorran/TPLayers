package ar.unrn.tp3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import ar.unrn.tp3.correo.ServicioEnvioDeCorreo;
import ar.unrn.tp3.modelo.Correos;
import ar.unrn.tp3.modelo.Email;
import ar.unrn.tp3.modelo.Empleado;
import ar.unrn.tp3.modelo.Empleados;
import ar.unrn.tp3.modelo.EnvioDeCorreo;
import ar.unrn.tp3.persistencia.EnArchivoPersistencia;

public class TestCorreos {

	List<Empleado> empleados = new ArrayList<Empleado>();
	@Test
	public void envioDeCorreos() {
		
		
		EnvioDeCorreo servicio = new ServicioEnvioDeCorreo();
		Empleados instancia= new EnArchivoPersistencia();
		
		Correos correo = new Correos(servicio, instancia);
		
		Email correoAngus = new Email ("angus@acdc.com");
		Email correoBrian = new Email ("brian@acdc.com");
		Email correoJosh = new Email ("josh@acdc.com");
		
		LocalDate fechaAngus= LocalDate.of(1982, 10, 8);
		LocalDate fechaBrian = LocalDate.of(1975, 9, 11);
		
		Empleado angus = new Empleado("Angus", "Young", correoAngus, fechaAngus);
		Empleado brian = new Empleado("Brian", "Johnson", correoBrian, fechaBrian);
		Empleado josh = new Empleado("Josh", "Green", correoJosh, fechaAngus);
		
		empleados.add(josh);
		empleados.add(angus);
		empleados.add(brian);
		
		correo.enviarCorreos(empleados);
		
		String contenidoEsperado="Brian Johnson"+" "+"brian@acdc.com";
		
		assertEquals(contenidoEsperado, servicio.recuperarContenidoDeCorreo());
	}
}
