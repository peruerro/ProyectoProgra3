package clases;

public class Fase {
	private int idFase;
	private String nombre;
	private int puntosGanador;
	private int puntosPerdedor;
	
	public Fase(int idFase, String nombre, int puntosGanador, int puntosPerdedor) {
		super();
		this.idFase = idFase;
		this.nombre = nombre;
		this.puntosGanador = puntosGanador;
		this.puntosPerdedor = puntosPerdedor;
	}

	public int getIdFase() {
		return idFase;
	}

	public void setIdFase(int idFase) {
		this.idFase = idFase;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	

}
