package codigo.modelos;

import codigo.cfg.Config;

public class Persona {
	
	private int id = 0;
	private String name = "";
	private int edad = 18;
	private int sueldo = 100;
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;	
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;	
	}
	
	public int sueldoBruto() {
		int iva = Config.IVA;
		return((this.sueldo + (this.sueldo * iva) /100)); 
	}
	
	public boolean esMayor() {
		return (this.edad>=18);	
	}
}
