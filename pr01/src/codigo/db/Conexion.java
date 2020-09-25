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
	
	private Statement getState() throws SQLException {
		Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);  // set timeout to 30 sec.
        
        return statement;
	}
	
	
	public void close() {
		 try {
           if(connection != null)
             connection.close();
         } catch(SQLException e)  {
           // connection close failed.
           System.err.println(e.getMessage());
         }
	}
	

	private String getStringArray(String[] values) {
		String res = "";
		for (String value : values) {
			res = res + ",'" +value+"'";
		}
		res = res.substring(1);
		return res;
	}
	
	
	private String getStringArray(String[] cols, String[] values) {
		//name = 'Buri'
		String res = "";
		for (int i =0; i < values.length; i++) {
			String value = values[i];
			String col = cols[i];
			res = res + col + "=" + value +"'";
		}
		res = res.substring(1);
		return res;
		
	}
	
	/**
	 * Esta funcion inserta datos en una tabla
	 * 
	 * @param TABLA
	 * @param values
	 * @throws SQLException
	 */
	public void insert(String TABLA, String[] values) throws SQLException{
		String tail = this.getStringArray(values);
		String query = "insert into "+TABLA+" values("+tail+")";
		
		
		instance.execute(query);
	}
	

	public void select(String TABLA) {
		
	}
	
	public void update(String TABLA, Integer ID, String[] cols, String[] values) throws SQLException {
		//UPDATE TABLE XXXX SET YYY-ZZZZ WHERE iD = QQQQQ
		String tail = this.getStringArray(cols, values);
		String query = "UPDATE " + TABLA + " SET " +tail + " WHERE 'id' = "+ ID;
		
		
		instance.execute(query);
		
		
	}
	

	public void delete(String TABLA, Integer ID) throws SQLException {
	
		String query = "Delete from " + TABLA + "WHERE Id = " + (ID) + ";";
		
		instance.execute(query);
		
	}

	public boolean isConnected() throws SQLException {
		if (connection == null) {
			return false;
		} 
		return !connection.isClosed();
	}
	
	private void execute(String query) throws SQLException {

		Statement state = this.getState();
		state.executeUpdate(query);
		
	}
	
}