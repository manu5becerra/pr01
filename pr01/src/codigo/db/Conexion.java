package codigo.db;

public class Conexion {
	
	private static Conexion instance;

	private Conexion() {
	}

	public static Conexion getInstance() {
		if (instance == null) {
			instance = new Conexion();
		}
		return instance;
	}
}
