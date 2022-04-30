package ar.unrn.oop2.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ar.unrn.oop2.modelo.Concurso;
import ar.unrn.oop2.modelo.Inscripcion;
import ar.unrn.oop2.modelo.Persistencia;

public class EnBasePersitencia implements Persistencia {
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL_DB = "jdbc:mysql://localhost:3306/";
	// jdbc:mysql://localhost:3306/
	protected static String DB = "layers_tres";
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
	public void registrarInscripcion(Inscripcion inscripcion) {
		// TODO Auto-generated method stub
		this.connect();
		try {
			PreparedStatement statement = conn
					.prepareStatement("insert into inscripcion(detalle_inscripcion)values(?)");

			statement.setString(1, inscripcion.datosDeInscripcion());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.disconnect();
		}

	}

	@Override
	public String recuperarConcurso(int idConcurso) {
		// TODO Auto-generated method stub
		this.connect();String concurso= null;
		try {
			PreparedStatement statement = conn
					.prepareStatement("SELECT * FROM 'concurso' + WHERE concurso.id_concurso = ?");

			statement.setInt(1, idConcurso);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				
				concurso = rs.getInt("id_concurso") +","+ rs.getString("nombre")+"," 
				+rs.getString("fecha_inicio") +","+ rs.getString("fecha_fin");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.disconnect();
		}
		return concurso;
	}

	@Override
	public List<String> recuperarConcursos() {
		// TODO Auto-generated method stub
		return null;
	}

}
