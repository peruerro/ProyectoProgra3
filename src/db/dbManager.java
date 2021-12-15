package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Creacion de tablas
 * @author Peru Erro Arrue
 * @version 1.0
 */
public class dbManager {
	
	    /**
	     * Crear una tabla en la base de datos
	     *
	     */
	    public static void crearTablaJugador()
	    {
	        
	        String name = "basededatos.db";
	        String url = "jdbc:sqlite:" + name;

	        
	        String sql = "CREATE TABLE IF NOT EXISTS Jugador (\n"
	                + "    idJugador interger not null primary key ,\n"
	        		+ "    nombre text not null,\n"
	                + "    edad interger not null,\n"
	                + "    nacionalidad text not null,\n"
	                + "    pala text not null,\n"
	                + "    manoHabil text not null,\n"
	                + "    posicion text not null, \n"
	                + "    puntosRanking interger not null, \n"
	                + "    idPartido interger references Partido(idPartido) on delete cascade \n"
	          
	                + ");";

	        try
	                (
	                        Connection conn = DriverManager.getConnection(url);
	                        Statement stmt = conn.createStatement()
	                )
	        {
	            // create a new table
	            stmt.execute(sql);
	        } catch (SQLException e)
	        {
	        	e.printStackTrace();
	        }
	    }
	    /**
	     * Creacion de la tabla Partido
	     */
	    public static void crearTablaPartido()
	    {
	        
	        String name = "basededatos.db";
	        String url = "jdbc:sqlite:" + name;

	        
	        String sql = "CREATE TABLE IF NOT EXISTS Partido (\n"
	                + "    idPartido interger primary key not null ,\n"
	                + "    idGanador interger references Jugador(idJugador) on delete cascade,\n"
	                + "    idPerdedor text references Jugador (idPerdedor)on delete cascade,\n"
	                + "    resultGanador interger not null,\n"
	                + "    resultPerdedor interger not null,\n"
	                + "    idfase interger references Fase(idFase) on delete cascade , \n"  
	                + "	   idTorneo interger references Torneo(idTorneo)on delete cascade \n"	
	                + ");";

	        try
	                (
	                        Connection conn = DriverManager.getConnection(url);
	                        Statement stmt = conn.createStatement()
	                )
	        {
	            // create a new table
	            stmt.execute(sql);
	        } catch (SQLException e)
	        {
	        	e.printStackTrace();
	        }
	    }
	    /**
	     * Creacion de la tabla Usuario
	     */
	    public static void crearTablaUsuario()
	    {
	        
	        String name = "basededatos.db";
	        String url = "jdbc:sqlite:" + name;

	        
	        String sql = "CREATE TABLE IF NOT EXISTS Usuario (\n"
	                + "    nombre text primary key not null ,\n"
	                + "    nombreUsuario text not null,\n"
	                + "    contrasenya text not null,\n"
	                + "    admin interger not null \n"   
	                + ");";

	        try
	                (
	                        Connection conn = DriverManager.getConnection(url);
	                        Statement stmt = conn.createStatement()
	                )
	        {
	            // create a new table
	            stmt.execute(sql);
	        } catch (SQLException e)
	        {
	        	e.printStackTrace();
	        }
	    }
	    /**
	     * Creacion de la Fase 
	     */
	    public static void crearTablaFase(){
	        
	        String name = "basededatos.db";
	        String url = "jdbc:sqlite:" + name;

	        
	        String sql = "CREATE TABLE IF NOT EXISTS Fase (\n"
	                + "    idFase interger primary key not null ,\n"
	                + "    nombre text not null,\n"
	                + "    puntosGanador interger not null,\n"
	                + "    puntosPerdedor interger not null \n"   
	                + ");";

	        try
	                (
	                        Connection conn = DriverManager.getConnection(url);
	                        Statement stmt = conn.createStatement()
	                )
	        {
	            // create a new table
	            stmt.execute(sql);
	        } catch (SQLException e)
	        {
	        	e.printStackTrace();
	        }
	    }
	    public static void crearTablaTorneo(){
	        
	        String name = "basededatos.db";
	        String url = "jdbc:sqlite:" + name;

	        
	        String sql = "CREATE TABLE IF NOT EXISTS Torneo (\n"
	                + "    idTorneo interger primary key not null ,\n"
	                + "    nombre text not null,\n"
	                + "    idGanador interger references Partido(idGanador)on delete cascade \n"   
	                + ");";

	        try
	                (
	                        Connection conn = DriverManager.getConnection(url);
	                        Statement stmt = conn.createStatement()
	                )
	        {
	            // create a new table
	            stmt.execute(sql);
	        } catch (SQLException e)
	        {
	        	e.printStackTrace();
	        }
	    }
	    

	    /**
	     * Metodo principal para poder utilizar el metodo crearTablaJugador
	     * @param args the command line arguments
	     */
	    public static void main(String[] args)
	    {
	        crearTablaJugador();
	    	crearTablaPartido();
	    	crearTablaUsuario();
	    	crearTablaFase();
	    	crearTablaTorneo();
	    	
	    }

	}

