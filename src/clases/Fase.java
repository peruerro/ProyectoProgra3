package clases;

public class Fase {
	/**
	 * el id de la fase
	 */
	private int idFase;
	/**
	 * el nombre de la fase
	 */
	private String nombre;
	/**
	 * los puntos para el ganador
	 */
	private int puntosGanador;
	/**
	 * los puntos el perdedor
	 */
	private int puntosPerdedor;
	/**
	 * rellena los parametros con lo siguiente
	 * @param idFase con el id de la fase
	 * @param nombre con el nombre de la fase
	 * @param puntosGanador con la cantidad de puntos que se lleva el ganador
	 * @param puntosPerdedor con l cantidad de puntos que se lleva el perdedor
	 */
	public Fase(int idFase, String nombre, int puntosGanador, int puntosPerdedor) {
		super();
		this.idFase = idFase;
		this.nombre = nombre;
		this.puntosGanador = puntosGanador;
		this.puntosPerdedor = puntosPerdedor;
	}
	/**
	 * devuelve el id de la fase
	 * @return ide de la fase
	 */

	public int getIdFase() {
		return idFase;
	}
	/**
	 * modifica el id de la fase
	 * @param idFase el nuevo id
	 */

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
