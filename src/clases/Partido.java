package clases;

public class Partido {
	private int idPartido;
	private Jugador ganador;
	private Jugador perdedor;
	private int puntosGanador;
	private int puntosPerdedor;
	private Fase fase;
	public Partido(int idPartido, Jugador ganador, Jugador perdedor, int puntosGanador, int puntosPerdedor, Fase fase) {
		super();
		this.idPartido = idPartido;
		this.ganador = ganador;
		this.perdedor = perdedor;
		this.puntosGanador = puntosGanador;
		this.puntosPerdedor = puntosPerdedor;
		this.fase = fase;
	}
	public Partido(int int1, int int2, int int3, int int4, int int5, int int6, int int7) {
		// TODO Auto-generated constructor stub
	}
	public int getIdPartido() {
		return idPartido;
	}
	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}
	public Jugador getGanador() {
		return ganador;
	}
	public void setGanador(Jugador ganador) {
		this.ganador = ganador;
	}
	public Jugador getPerdedor() {
		return perdedor;
	}
	public void setPerdedor(Jugador perdedor) {
		this.perdedor = perdedor;
	}
	public int getPuntosGanador() {
		return puntosGanador;
	}
	public void setPuntosGanador(int puntosGanador) {
		this.puntosGanador = puntosGanador;
	}
	public int getPuntosPerdedor() {
		return puntosPerdedor;
	}
	public void setPuntosPerdedor(int puntosPerdedor) {
		this.puntosPerdedor = puntosPerdedor;
	}
	public Fase getFase() {
		return fase;
	}
	public void setFase(Fase fase) {
		this.fase = fase;
	}
	
	

}
