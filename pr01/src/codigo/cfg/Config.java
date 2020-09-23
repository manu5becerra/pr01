package codigo.cfg;

import codigo.db.Conexion;

public class Config {

	public static final int IVA = 21;
	
	private Config() { 
		
		Conexion ctx = Conexion.getInstance();
	}
}
