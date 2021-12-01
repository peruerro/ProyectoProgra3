package clases;
/**
 * Representa a las personas en general y despues las clases Jugador y Entrenador la heredan
 * @author Peru Erro Arrue
 * @version 1.0
 *
 */
public class Persona {
	/**
	 * Indica el nombre de la persona
	 */
	private String nombre;
	/**
	 * Indica la edad de la persona
	 */
	private int edad;
	/**
	 * Indica donde nacio la persona
	 */
	private String nacionalidad;
	/**
	 * Indica los titulos ganados por la persona
	 */
	private int titulos;
	/**
	 * Rellena los parametros de la clase Persona
	 * @param nombre El nombre de la persona
	 * @param edad La edad de la persona
	 * @param nacionalidad Donde nacio la persona
	 * @param titulos que titulos ha ganado la persona
	 */
	public Persona(String nombre, int edad, String nacionalidad, int titulos) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.nacionalidad = nacionalidad;
		this.titulos=titulos;
	}
	/**
	 * Devuelve el nombre de la Persona
	 * @return Un String con el nombre de la Persona
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Modifica el nombre de la Persona
	 * @param nombre El nuevo nombre de la persona
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Devuelve la edad de la Persona
	 * @return Un int con la edad de la persona
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * Modifica la edad de la persona
	 * @param edad la nueva edad de la persona
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	/**
	 * Devuelve la nacionalidad de la persona
	 * @return un String con la nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}
	/**
	 * Modifica la nacionalidad
	 * @param nacionalidad la nueva nacionalidad de la persona
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	/**
	 * Devuelve los titulos de la persona
	 * @return un String con los titulos
	 */
	public int getTitulos() {
		return titulos;
	}
	/**
	 * Modifica los titulos de la persona
	 * @param titulos los nuevos titulos de la persona
	 */
	public void setTitulos(int titulos) {
		this.titulos = titulos;
	}
	
	
	

}
