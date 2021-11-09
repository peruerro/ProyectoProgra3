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
    public void insert(String nombre, String nombreUsuario, String contrasenya, boolean admin)
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
            int myInt=admin ? 1 : 0;
            pstmt.setBoolean(4, admin);
            
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
        
    }

}