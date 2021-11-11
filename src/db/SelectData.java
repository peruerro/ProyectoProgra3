package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Usuario;


public class SelectData {
	/**
     * Conectar a la bd bdproyecto.db 
     * @return la conexion
     */
    private static Connection connect()
    {
        // SQLite connection string
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
            
            while (rs.next())
            {
                System.out.println
                        (
                                rs.getString("nombre") +  "\t" +
                                rs.getString("nombreUsuario") + "\t" +
                                rs.getString("contrasenya") + "\t" +
                                rs.getInt("admin")
                        );
            }
            
        
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
		return usuarios;
    }
    public static void main(String[]args){
    	ArrayList<Usuario> u= SelectData.seleccionarUsuario();
    	System.out.println(u);
    }
    

}
