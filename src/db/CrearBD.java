package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Crea una base de datoss
 * @author Peru Erro Arrue
 * @version 1.0
 */
public class CrearBD
{

    /**
     * Conecta el proyecto con una base de datos
     *
     * @param fileName el nombre del fichero
     */
    public static void crearNuevaBD(String fileName)
    {

        String url = "jdbc:sqlite:" + fileName;

        try (Connection conn = DriverManager.getConnection(url))
        {
            if (conn != null)
            {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo principal para ejeutar el metodo crearNuevaBD
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        crearNuevaBD("basededatos.db");
    }
}
