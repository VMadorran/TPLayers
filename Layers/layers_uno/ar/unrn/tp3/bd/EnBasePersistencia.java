package ar.unrn.tp3.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.unrn.tp3.modelo.Participante;
import ar.unrn.tp3.modelo.Persistencia;

public class EnBasePersistencia implements Persistencia {

	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL_DB = "jdbc:mysql://localhost:3306/";
	// jdbc:mysql://localhost:3306/
	protected static String DB = "participantes";
	protected static String user = "root";
	protected static String pass = "";
	protected static Connection conn = null;

	private void connect() {
		try {
			conn = DriverManager.getConnection(URL_DB + DB + "?useSSL=false", user, pass);
		} catch (SQLException sqlEx) {
			System.out.println("No se ha podido conectar a " + URL_DB + DB + ". " + sqlEx.getMessage());
			System.out.println("Error al cargar el driver");
		}
	}

	private void disconnect() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void cargarParticipante(Participante participante) {

		this.connect();
		try {
			PreparedStatement statement = conn.prepareStatement("insert into participantes(nombre, telefono, region)values(?,?,?)");
		
			statement.setString(1, participante.nombreDelParticipante());
			statement.setString(2, participante.telefonoDelParticipante());
			statement.setString(3, participante.regionDelParticipante());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			this.disconnect();
		}
	}

}
