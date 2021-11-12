package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Jugador;
import db.SelectData;
/**
 * Testeo de metodo sumarTitulos
 * @author Peru Erro Arrue
 * @version 1.0
 *
 */
public class testSumarTitulos {
	/**
	 * ArrayList de jugadores
	 */
	private ArrayList<Jugador> jugadores;

	@Before
	public void setUp() throws Exception {
		ArrayList<Jugador> jugadores=SelectData.seleccionarJugador();
		for (Jugador a:jugadores){
			a.setTitulos(1);
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int resultado=Jugador.sumarTitulos();
		assertEquals(10,resultado,0.0);
	}

}
