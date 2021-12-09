package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Torneo;


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
        String name = "basededatos.db";
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
    public void insertJugador(int idJugador, String nombre, int edad, String nacionalidad, String pala, String manoHabil, String posicion, int puntosRanking, String titulos)
    {
    	String sql = "INSERT INTO Jugador (idJugador, nombre, edad, nacionalidad, pala, manohabil, posicion, puntosRanking, titulos) VALUES (?,?,?,?,?,?,?,?,?)";
    	try
    		(
    				Connection conn = this.connect();
                	PreparedStatement pstmt = conn.prepareStatement(sql)
    		)
    	{
    		pstmt.setInt(1, idJugador);
    		pstmt.setString(2, nombre);
    		pstmt.setInt(3, edad);
    		pstmt.setString(4, nacionalidad);
    		pstmt.setString(5, pala);
    		pstmt.setString(6, manoHabil);
    		pstmt.setString(7, posicion);
    		pstmt.setInt(8, puntosRanking);
    		pstmt.setString(9, titulos);
    		
    		pstmt.executeUpdate();
    	}
    	catch (SQLException e)
    	{
    		System.out.println(e.getMessage());
    	}
    }
    
    public void insertPartido(int idPartido, String ganador, String perdedor, int resultGanador, int resultPerdedor, String fase)
    {
    	String sql = "INSERT INTO Partido (idPartido, ganador, perdedor, resultGanador, resultPerdedor, fase) VALUES (?,?,?,?,?,?)";
    	try
    		(
    				Connection conn = this.connect();
                	PreparedStatement pstmt = conn.prepareStatement(sql)
    		)
    	{
    		pstmt.setInt(1, idPartido);
    		pstmt.setString(2, ganador);
    		pstmt.setString(3, perdedor);
    		pstmt.setInt(4, resultGanador);
    		pstmt.setInt(5, resultPerdedor);
    		pstmt.setString(6, fase);
    		
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
//        app.insertPartido(1, " Alejandro Galán", "Federico Chingotto", 2, 1, "Cuartos de final");

        
        app.insertUsuario("Jonan", "Arana","joni",1);
        app.insertUsuario("Alex", "sarona","romagnoli",1);
        app.insertUsuario("Peru", "peruerro", "erro", 0);
//        
//        InsertData app1=new InsertData();
//        app1.insertJugador(1,"Alejandro Galan",25,"España", "Adidas Metalbone", "Diestra", "Reves",0,"");
//        app1.insertJugador(2,"Juan Lebron", 25, "España", "Babolat Technical Viper", "Diestra", "Derecha",0,"");
//        app1.insertJugador(3,"Paquito Navarro", 32, "España", "BullPadel Hack", "Diestra", "Reves",0,"");
//        app1.insertJugador(4,"Martin Di Nenno", 24, "Argentina", "BullPadel Vertex", "Diestra", "Derecha",0,"");
//        app1.insertJugador(5,"Sanyo Gutierrez", 37, "Argentina", "Head Graphene", "Diestra", "Derecha",0,"");
//        app1.insertJugador(6,"Agustin Tapia", 22, "Argentina", "Nox AT10", "Diestra", "Reves",0,"");
//        app1.insertJugador(7,"Fernando Belasteguin", 42, "Argentina", "Wilson Bela Pro", "Diestra", "Reves",0,"");
//        app1.insertJugador(8,"Pablo Lima", 34, "Brasil", "Asics Speed", "Izquierda", "Derecha",0,"");
//        app1.insertJugador(9,"Juan Tello", 26, "Argentina","BullPadel Vertex" , "Diestra", "Reves",0,"");
//        app1.insertJugador(10,"Federico Chingotto", 24, "Argentina","BullPadel Vertex", "Diestra", "Derecha",0,"");
    }
    

}