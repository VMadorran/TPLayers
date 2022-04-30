package ar.unrn.oop2.persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.unrn.oop2.modelo.Inscripcion;
import ar.unrn.oop2.modelo.Persistencia;

public class EnArchivoPersistencia implements Persistencia {

	@Override
	public void registrarInscripcion(Inscripcion inscripcion) {
		// TODO Auto-generated method stub
		String dato = inscripcion.datosDeInscripcion();
		try {
			Files.write(Paths.get("C:\\Users\\valen\\Desktop\\inscriptos.txt"), dato.getBytes(),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("ERROR", e);
		}
	}

	@Override
	public List<String> recuperarConcursos() {
		// TODO Auto-generated method stub
		List<String> empleadosArchivos = new ArrayList<String>();
		File archivo = new File("C:\\Users\\valen\\Desktop\\concursos.txt");
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
	public String recuperarConcurso(int idConcurso) {
		// TODO Auto-generated method stub
		return null;
	}



}
