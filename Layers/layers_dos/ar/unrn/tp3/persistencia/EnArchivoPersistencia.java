package ar.unrn.tp3.persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.unrn.tp3.modelo.Email;
import ar.unrn.tp3.modelo.Empleado;
import ar.unrn.tp3.modelo.Empleados;

public class EnArchivoPersistencia implements Empleados {

	List<Empleado> empleados= new ArrayList<Empleado>();
	
	private List<String> recuperarDatos() {
		// TODO Auto-generated method stub
		List<String> empleadosArchivos = new ArrayList<String>();
		File archivo = new File("C:\\Users\\valen\\Desktop\\Empleados.txt");
		Scanner scanner;
		try {
			scanner = new Scanner(archivo);
			while (scanner.hasNextLine()) {
				empleadosArchivos.add(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empleadosArchivos;
	}

	@Override
	public List<Empleado> recuperarEmpleados() {
		this.recuperarLinea(this.recuperarDatos());
		return this.empleados;
	}

	private void recuperarLinea(List<String> lineas) {
 
		for (int i = 0; i < lineas.size(); i++) {
			String lineaNueva = lineas.get(i);
			String[] datosEmpleado = lineaNueva.split("\\,");
			this.reconstruirEmpleado(datosEmpleado);
		}

	}

	private void reconstruirEmpleado(String[] linea) {
	
		// Young, Angus, 1982/10/08, angus@acdc.com
		Email email = new Email(linea[3]);
		LocalDate fecha = LocalDate.parse(linea[2]);
	
		Empleado empleado = new Empleado(linea[1], linea[0], email, fecha);
		empleados.add(empleado);
		
	}

}
