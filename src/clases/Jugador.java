package clases;

import java.awt.List;
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
	 * el idJugador
	 */
	private int idJugador;
	/**
	 * los puntos totales del ranking
	 */
	private int puntosRanking;
	/**
	 * ArrayList que contiene los titulos que tiene el jugador
	 */
	private ArrayList <Torneo> titulos;
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
	
	
	public Jugador(int idJugador,String nombre, int edad, String nacionalidad, String pala, String manoHabil,
			String posicion, int puntosRanking) {
		super(nombre, edad, nacionalidad);
		this.pala = pala;
		this.manoHabil = manoHabil;
		this.posicion = posicion;
		this.idJugador=idJugador;
		this.puntosRanking=puntosRanking;
		
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
	

	public int getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}
	
	public int getPuntosRanking() {
		return puntosRanking;
	}
	public void setPuntosRanking(int puntosRanking) {
		this.puntosRanking = puntosRanking;
	}
	public ArrayList<Torneo> getTitulos() {
		return titulos;
	}
	public void setTitulos(ArrayList<Torneo> titulos) {
		this.titulos = titulos;
	}
	@Override
	public String toString() {
		return getNombre()+" ; "+getEdad()+" años ; "+getNacionalidad()+" ; "+pala+" ; "+manoHabil+" ; "+posicion+" ; "+puntosRanking+" ; "+titulos;
	}
	
	/**
	 * Metodo para sumar los titulos de todos los jugadores
	 * @return el numero de titulos totales
	 */
//	public static int sumarTitulos (){
//		ArrayList<Jugador>j =SelectData.seleccionarJugador();
//		int titulos=0;
//		for(Jugador a:j){
//			titulos=titulos+a.getTitulos();
//		}
//		
//		return titulos;
//	}
	
//	public static void sumarPuntos(){
//		ArrayList<Jugador> j =SelectData.seleccionarJugador();
//		
//	}
//	
}
	

	
		


