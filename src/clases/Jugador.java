package clases;
/**
 * 
 * @author Peru Erro Arrue
 *@version 1.0
 */

public class Jugador extends Persona{
	/**
	 * el modelo de la pala del jugador
	 */
	private String pala; 
	/**
	 * la mano con la que el jugador coge la pala
	 */
	private String manoHabil;
	/**
	 * la posicion en la que juega el jugador en la pista: izquierda/derecha
	 */
	private String posicion;
	/**
	 * rellena los parametros
	 * @param nombre nombre del jugador
	 * @param edad la edad del jugador
	 * @param nacionalidad donde nacio el jugador
	 * @param titulos cuantos titulos ha ganado en su historia
	 * @param pala modelo de la pala
	 * @param manoHabil la mano con la que coge la pala
	 * @param posicion la posición del jugador en pista
	 */
	public Jugador(String nombre, int edad, String nacionalidad, String titulos, String pala, String manoHabil,
			String posicion) {
		super(nombre, edad, nacionalidad, titulos);
		this.pala = pala;
		this.manoHabil = manoHabil;
		this.posicion = posicion;
	}
	/**
	 * devuelve la pala
	 * @return un string de la pala
	 */
	public String getPala() {
		return pala;
	}
	public void setPala(String pala) {
		this.pala = pala;
	}
	public String getManoHabil() {
		return manoHabil;
	}
	public void setManoHabil(String manoHabil) {
		this.manoHabil = manoHabil;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	
	

	

}
