package codigo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	private static Conexion instance;

	private Conexion() {
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public static Conexion getInstance() {
		if (instance == null) {
			instance = new Conexion();
		}
		return instance;
	}
	
	private Connection connection = null;
	
	public Statement getState() throws SQLException {
		 Statement statement = connection.createStatement();
	     statement.setQueryTimeout(30);  // set timeout to 30 sec.
	     
	     return statement;
	
		}
		
	
	public void close() {
		 try
	      {
	        if(connection != null)
	          connection.close();
	      }
	      catch(SQLException e)
	      {
	        // connection close failed.
	        System.err.println(e.getMessage());
	      }
	}
	
	
	public void insertar(String TABLA, String[] values) {
		
	}
	
	
	public void select (String TABLA) {
		
	}
	
	
	public void 
	
}








