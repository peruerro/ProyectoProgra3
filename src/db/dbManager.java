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
	        
	        String name = "bdproyecto.db";
	        String url = "jdbc:sqlite:" + name;

	        
	        String sql = "CREATE TABLE IF NOT EXISTS Jugador (\n"
	                + "    nombre text not null,\n"
	                + "    edad interger not null,\n"
	                + "    nacionalidad text not null,\n"
	                + "    titulos interger not null,\n"
	                + "    pala text not null,\n"
	                + "    manoHabil text not null,\n"
	                + "    posicion text not null\n"
	          
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
	    }

	}

