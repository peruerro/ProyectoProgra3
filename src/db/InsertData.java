package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Insertar objetos a la base de datos
 * @author Peru Erro Arrue
 * @version 1.0
 *
 */
public class InsertData
{

    /**
     * Conectar con la bd bdproyecto.db
     *
     * @return la conexion
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
     * Insertar usuarios en tabla Usuario
     *
     * @param nombre el nombre del usuario
     * @param nombreUsuario el nombre de usuario
     * @param constrasenya la contrasenya del usuario
     * @param admin 0 o 1 para saber si es administrador o no
     */
    public void insertUsuario(String nombre, String nombreUsuario, String contrasenya, int admin)
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
            e.printStackTrace();
        }
    }
    /**
     * Insertar jugadores en tabla Jugador
     * @param nombre el nombre del jugador
     * @param edad la edad del jugador
     * @param nacionalidad donde nacio el jugador
     * @param titulos que titulos tiene el jugador
     * @param pala que pala utiliza el jugador
     * @param manoHabil si el jugador es diestro o zurdo
     * @param posicion si el jugador es jugador de reves o de derecha
     */
    public void insertJugador(String nombre, int edad, String nacionalidad, int titulos, String pala, String manoHabil, String posicion)
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
     * Metodo principal para ejecutar la inserts
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        InsertData app = new InsertData();

        
        //app.insertUsuario("Jonan", "Arana","joni",1);
        //app.insertUsuario("Alex", "sarona","romagnoli",1);
        app.insertUsuario("Peru", "peruerro", "erro", 0);
        
        InsertData app1=new InsertData();
        app1.insertJugador("Alejandro Galan",25,"España", 0, "Adidas Metalbone", "Diestra", "Reves");
        app1.insertJugador("Juan Lebron", 25, "España", 0, "Babolat Technical Viper", "Diestra", "Derecha");
        app1.insertJugador("Paquito Navarro", 32, "España", 0, "BullPadel Hack", "Diestra", "Reves");
        app1.insertJugador("Martin Di Nenno", 24, "Argentina", 0, "BullPadel Vertex", "Diestra", "Derecha");
        app1.insertJugador("Sanyo Gutierrez", 37, "Argentina", 0, "Head Graphene", "Diestra", "Derecha");
        app1.insertJugador("Agustin Tapia", 22, "Argentina", 0, "Nox AT10", "Diestra", "Reves");
        app1.insertJugador("Fernando Belasteguin", 42, "Argentina", 0, "Wilson Bela Pro", "Diestra", "Reves");
        app1.insertJugador("Pablo Lima", 34, "Brasil", 0, "Asics Speed", "Izquierda", "Derecha");
        app1.insertJugador("Juan Tello", 26, "Argentina", 0,"BullPadel Vertex" , "Diestra", "Reves");
        app1.insertJugador("Federico Chingotto", 24, "Argentina", 0,"BullPadel Vertex", "Diestra", "Derecha");
    }
    

}