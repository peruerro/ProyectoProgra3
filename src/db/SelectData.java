package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Fase;
import clases.Jugador;
import clases.Partido;
import clases.Torneo;
import clases.Usuario;


public class SelectData {
	 /**
     * Conectar con la bd bdproyecto.db
     *
     * @return la conexion
     */
    private static Connection connect()
    {
        
        String name = "basededatos.db";
        String url = "jdbc:sqlite:" + name;
        Connection conn = null;

        try
        {
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    /**
     * Seleciona todo lo de la tabla Usuario
     * @return devuelve los usuarios
     */
    public static ArrayList<Usuario> seleccionarUsuario()
    {
        String sql = "SELECT nombre, nombreUsuario, contrasenya, admin FROM Usuario";
        ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
        try
                (
                        Connection conn = connect();
                        Statement stmt  = conn.createStatement();
                       
                )
        {
        	ResultSet rs=stmt.executeQuery(sql);
       while (rs.next()){
    	   Usuario u= new Usuario(rs.getString("nombre"),rs.getString("nombreUsuario"),rs.getString("contrasenya"),rs.getInt("admin"));
    	   usuarios.add(u);
       }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
		return usuarios;
    }
    /**
     * Selecciona todo de la tabla Jugador
     * @param sql un String
     * @return los jugadores
     */
    public static ArrayList<Jugador> seleccionarJugador(String sql)
    {
        
        ArrayList<Jugador> jugadores=new ArrayList<Jugador>();
        try
                (
                        Connection conn = connect();
                        Statement stmt  = conn.createStatement();
                       
                )
        {
        	ResultSet rs=stmt.executeQuery(sql);
       while (rs.next()){
    	   Jugador j= new Jugador(rs.getInt("idJugador"),rs.getString("nombre"),rs.getInt("edad"),rs.getString("nacionalidad"),rs.getString("pala"),rs.getString("manoHabil"),rs.getString("posicion"),rs.getInt("puntosRanking"));
    	   jugadores.add(j);
       }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
		return jugadores;
    }
    /**
     * Selecciona todo de la tabla Torneo
     * @param sql un String
     * @return los torneos
     */
    public static ArrayList<Torneo> seleccionarTorneo(String sql)
    {
        
        ArrayList<Torneo> torneos=new ArrayList<Torneo>();
        try
                (
                        Connection conn = connect();
                        Statement stmt  = conn.createStatement();
                       
                )
        {
        	ResultSet rs=stmt.executeQuery(sql);
       while (rs.next()){
    	   Torneo t= new Torneo(rs.getInt("idTorneo"),rs.getString("nombre"),rs.getInt("idGanador"));
    	   torneos.add(t);
       }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
		return torneos;
    }
    public static ArrayList<Fase> seleccionarFase(String sql)
    {
        
        ArrayList<Fase> fases=new ArrayList<Fase>();
        try
                (
                        Connection conn = connect();
                        Statement stmt  = conn.createStatement();
                       
                )
        {
        	ResultSet rs=stmt.executeQuery(sql);
       while (rs.next()){
    	   Fase f= new Fase(rs.getInt("idFase"),rs.getString("nombre"),rs.getInt("puntosGanador"),rs.getInt("puntosPerdedor"));
    	   fases.add(f);
       }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
		return fases;
    }
    public static ArrayList<Partido> seleccionarPartido(String sql)
    {
        
        ArrayList<Partido> partidos=new ArrayList<Partido>();
        try
                (
                        Connection conn = connect();
                        Statement stmt  = conn.createStatement();
                       
                )
        {
        	ResultSet rs=stmt.executeQuery(sql);
       while (rs.next()){
    	   Partido p= new Partido(rs.getInt("idPartido"),rs.getInt("idGanador"),rs.getInt("idPerdedor"),rs.getInt("resultGanador"),rs.getInt("resultPerdedor"),rs.getInt("idFase"),rs.getInt("idTorneo"));
    	   partidos.add(p);
       }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
		return partidos;
    }
    /**
     * Metodo principal para probar que funciona la select
     * @param args
     */
    public static void main(String[]args){
    	ArrayList<Usuario> u= SelectData.seleccionarUsuario();
    	System.out.println(u);
    }
    

}
