package clases;

public class Persona {

	private String nombre;
	private int edad;
	private String nacionalidad;
	private String titulos;
	
	public Persona(String nombre, int edad, String nacionalidad, String titulos) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.nacionalidad = nacionalidad;
		this.titulos=titulos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getTitulos() {
		return titulos;
	}
	public void setTitulos(String titulos) {
		this.titulos = titulos;
	}
	
	
	

}
