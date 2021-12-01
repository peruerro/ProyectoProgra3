package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Jugador;
import clases.Usuario;


public class SelectData {
	 /**
     * Conectar con la bd bdproyecto.db
     *
     * @return la conexion
     */
    private static Connection connect()
    {
        
        String name = "bdproyecto.db";
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
    public static ArrayList<Jugador> seleccionarJugador()
    {
        String sql = "SELECT nombre,edad, nacionalidad, titulos, pala, manoHabil, posicion FROM Usuario";
        ArrayList<Jugador> jugadores=new ArrayList<Jugador>();
        try
                (
                        Connection conn = connect();
                        Statement stmt  = conn.createStatement();
                       
                )
        {
        	ResultSet rs=stmt.executeQuery(sql);
       while (rs.next()){
    	   Jugador j= new Jugador(rs.getString("nombre"),rs.getInt("edad"),rs.getString("nacionalidad"),rs.getInt("titulos"),rs.getString("pala"),rs.getString("manoHabil"),rs.getString("posicion"));
    	   jugadores.add(j);
       }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
		return jugadores;
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
