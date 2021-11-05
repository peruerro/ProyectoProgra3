package clases;

public class Entrenador extends Persona{
	
	private Jugador jugadoresEntrenados;

	public Entrenador(String nombre, int edad, String nacionalidad, String titulos, Jugador jugadoresEntrenados) {
		super(nombre, edad, nacionalidad, titulos);
		this.jugadoresEntrenados = jugadoresEntrenados;
	}

	public Jugador getJugadoresEntrenados() {
		return jugadoresEntrenados;
	}

	public void setJugadoresEntrenados(Jugador jugadoresEntrenados) {
		this.jugadoresEntrenados = jugadoresEntrenados;
	}
	
	

}
