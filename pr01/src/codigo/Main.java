package codigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import codigo.db.Conexion;
import codigo.models.Persona;

public class Main {

	public static void main(String[] args) { 
	 
		Conexion ctx = Conexion.getInstance();
		
		String[] lista = {"hola", "don", "pepito"};
		String[] cols = {"hola", "hola", "hola"};
		
		
        try
        {
          // create a database connection
        	ctx.insert("person", lista);
    		
    		
    		ctx.close();
    		
    		boolean isConnected = ctx.isConnected();
    		
          
          ctx.delete("person", 1);
          

          /*statement.executeUpdate("drop table if exists person");
          
          statement.executeUpdate("create table person (id integer, name string)");
          
          statement.executeUpdate("insert into person values(1, 'leo')");
          statement.executeUpdate("insert into person values(2, 'yui')");
          */
          
          
          
          /*ResultSet rs = statement.executeQuery("select * from person");
          while(rs.next())
          {
            // read the result set
            System.out.println("name = " + rs.getString("name"));
            System.out.println("id = " + rs.getInt("id"));
          }*/
        
      
        
        }
        catch(SQLException e)
        {
          // if the error message is "out of memory",
          // it probably means no database file is found
          System.err.println(e.getMessage());
        }
        finally
        {
         
        }
		
	}

}