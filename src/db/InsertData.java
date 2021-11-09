package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * 
 * @author Peru Erro Arrue
 *
 */
public class InsertData
{

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect()
    {
        // SQLite connection string
        String name = "bdproyecto.db";
        String url = "jdbc:sqlite:"+name;

        Connection conn = null;

        try
        {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param capacity
     */
    public void insert(String nombre, String nombreUsuario, String contrasenya, int admin)
    {
        String sql = "INSERT INTO Usuario(nombre,nombreUsuario, contrasenya, admin) VALUES(?,?,?,?)";

        try
                (
                        Connection conn = this.connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setString(1, nombre);
            pstmt.setString(2, nombreUsuario);
            pstmt.setString(3, contrasenya);
            pstmt.setInt(4, admin);
            
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void insert(String nombre, int edad, String nacionalidad, int titulos, String pala, String manoHabil, String posicion)
    {
    	String sql = "INSERT INTO Jugador (nombre, edad, nacionalidad, titulos, pala, manohabil, posicion) VALUES (?,?,?,?,?,?,?)";
    	try
    		(
    				Connection conn = this.connect();
                	PreparedStatement pstmt = conn.prepareStatement(sql)
    		)
    	{
    		pstmt.setString(1, nombre);
    		pstmt.setInt(2, edad);
    		pstmt.setString(3, nacionalidad);
    		pstmt.setInt(4, titulos);
    		pstmt.setString(5, pala);
    		pstmt.setString(6, manoHabil);
    		pstmt.setString(7, posicion);
    		
    		pstmt.executeUpdate();
    	}
    	catch (SQLException e)
    	{
    		System.out.println(e.getMessage());
    	}
    }
    
    	

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        InsertData app = new InsertData();

        // insert three new rows
        app.insert("Jonan", "Arana","joni",1);
        app.insert("Alex", "sarona","romagnoli",1);
        
        InsertData app1=new InsertData();
        app1.insert("Alejandro Galan",25,"España", 0, "Adidas Metalbone", "Diestra", "Reves");
        app1.insert("Juan Lebron", 25, "España", 0, "Babolat Technical Viper", "Diestra", "Derecha");
        app1.insert("Paquito Navarro", 32, "España", 0, "BullPadel Hack", "Diestra", "Reves");
        app1.insert("Martin Di Nenno", 24, "Argentina", 0, "BullPadel Vertex", "Diestra", "Derecha");
        app1.insert("Sanyo Gutierrez", 37, "Argentina", 0, "Head Graphene", "Diestra", "Derecha");
        app1.insert("Agustin Tapia", 22, "Argentina", 0, "Nox AT10", "Diestra", "Reves");
        app1.insert("Fernando Belasteguin", 42, "Argentina", 0, "Wilson Bela Pro", "Diestra", "Reves");
        app1.insert("Pablo Lima", 34, "Brasil", 0, "Asics Speed", "Izquierda", "Derecha");
        app1.insert("Juan Tello", 26, "Argentina", 0,"BullPadel Vertex" , "Diestra", "Reves");
        app1.insert("Federico Chingotto", 24, "Argentina", 0,"BullPadel Vertex", "Diestra", "Derecha");
    }
    

}