package clases;
/**
 * 
 * @author Peru Erro Arrue
 * @version 1.0
 *
 */
public class Entrenador extends Persona{
	/**
	 * Los jugadores que ha entrenado el entrenador
	 */
	private Jugador jugadoresEntrenados;

	public Entrenador(String nombre, int edad, String nacionalidad, String titulos, Jugador jugadoresEntrenados) {
		super(nombre, edad, nacionalidad, titulos);
		this.jugadoresEntrenados = jugadoresEntrenados;
	}
	/**
	 * Devuelve los jugadores que ha entrenado
	 * @return un objeto Jugador
	 */

	public Jugador getJugadoresEntrenados() {
		return jugadoresEntrenados;
	}
	/**
	 * Modifica los jugadores 
	 * @param jugadoresEntrenados los nuevos jugadores entrenados
	 */
	public void setJugadoresEntrenados(Jugador jugadoresEntrenados) {
		this.jugadoresEntrenados = jugadoresEntrenados;
	}
	
	

}
