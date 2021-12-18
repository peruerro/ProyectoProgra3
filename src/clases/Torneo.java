package clases;

import java.util.Arrays;

public class Torneo {
	private int idTorneo;
	private String nombreTorneo;
	private Partido [] partidos;
	private int ganador;
	public Torneo(int idTorneo, String nombreTorneo,  int ganador) {
		super();
		this.idTorneo = idTorneo;
		this.nombreTorneo = nombreTorneo;
		
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
	public int getGanador() {
		return ganador;
	}
	public void setGanador(int ganador) {
		this.ganador = ganador;
	}
	@Override
	public String toString() {
		return "Torneo [idTorneo=" + idTorneo + ", nombreTorneo=" + nombreTorneo + ", partidos="
				+ Arrays.toString(partidos) + ", ganador=" + ganador + "]";
	}
	
	
	
	

}
