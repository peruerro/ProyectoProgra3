package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Jugador;

public class testSumarPuntos {
	private Jugador j;
	private int p;

	@Before
	public void setUp() throws Exception {
		j=new Jugador(1,"a",25,"e","a","a","a",100);
		p= 200;
		
	}

	@After
	public void tearDown() throws Exception {
		j=null;
		p=(Integer) null;
	}

	@Test
	public void testSumarPuntos() {
		int suma=j.getPuntosRanking()+p;
		assertEquals(300,suma,0.0);
	}

}
