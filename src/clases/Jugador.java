package clases;

import java.util.ArrayList;

import db.SelectData;

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
	public Jugador(String nombre, int edad, String nacionalidad, int titulos, String pala, String manoHabil,
			String posicion) {
		super(nombre, edad, nacionalidad, titulos);
		this.pala = pala;
		this.manoHabil = manoHabil;
		this.posicion = posicion;
	}
	/**
	 * Devuelve la pala
	 * @return un string de la pala
	 */
	public String getPala() {
		return pala;
	}
	/**
	 * Modifica la pala del jugador
	 * @param pala la nueva pala del jugador
	 */
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

	/**
	 * Metodo para sumar los titulos de todos los jugadores
	 * @return el numero de titulos totales
	 */
	public static int sumarTitulos (){
		ArrayList<Jugador>j =SelectData.seleccionarJugador();
		int titulos=0;
		for(Jugador a:j){
			titulos=titulos+a.getTitulos();
		}
		
		return titulos;
	}
	
}
	

	
		


