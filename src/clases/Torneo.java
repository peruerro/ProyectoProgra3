package clases;

public class Torneo {
	private int idTorneo;
	private String nombreTorneo;
	private Partido [] partidos;
	private Jugador ganador;
	public Torneo(int idTorneo, String nombreTorneo, Partido[] partidos, Jugador ganador) {
		super();
		this.idTorneo = idTorneo;
		this.nombreTorneo = nombreTorneo;
		this.partidos = partidos;
		this.ganador = ganador;
	}
	public int getIdTorneo() {
		return idTorneo;
	}
	public void setIdTorneo(int idTorneo) {
		this.idTorneo = idTorneo;
	}
	public String getNombreTorneo() {
		return nombreTorneo;
	}
	public void setNombreTorneo(String nombreTorneo) {
		this.nombreTorneo = nombreTorneo;
	}
	public Partido[] getPartidos() {
		return partidos;
	}
	public void setPartidos(Partido[] partidos) {
		this.partidos = partidos;
	}
	public Jugador getGanador() {
		return ganador;
	}
	public void setGanador(Jugador ganador) {
		this.ganador = ganador;
	}
	
	
	
	

}
