package db;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Jugador;
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
    public void insertJugador(int idJugador, String nombre, int edad, String nacionalidad, String pala, String manoHabil, String posicion, int puntosRanking)
    {
    	String sql = "INSERT INTO Jugador (idJugador, nombre, edad, nacionalidad, pala, manohabil, posicion, puntosRanking) VALUES (?,?,?,?,?,?,?,?)";
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
    		
    		
    		pstmt.executeUpdate();
    	}
    	catch (SQLException e)
    	{
    		System.out.println(e.getMessage());
    	}
    }
    
    public void insertPartido(int idPartido, int idGanador, int idPerdedor, int resultGanador, int resultPerdedor, int idfase, int idTorneo)
    {
    	String sql = "INSERT INTO Partido (idPartido, idGanador, idPerdedor, resultGanador, resultPerdedor, idfase, idTorneo) VALUES (?,?,?,?,?,?,?)";
    	try
    		(
    				Connection conn = this.connect();
                	PreparedStatement pstmt = conn.prepareStatement(sql)
    		)
    	{
    		pstmt.setInt(1, idPartido);
    		pstmt.setInt(2, idGanador);
    		pstmt.setInt(3, idPerdedor);
    		pstmt.setInt(4, resultGanador);
    		pstmt.setInt(5, resultPerdedor);
    		pstmt.setInt(6, idfase);
    		pstmt.setInt(7, idTorneo);
    		
    		pstmt.executeUpdate();
    	}
    	catch (SQLException e)
    	{
    		System.out.println(e.getMessage());
    	}
    }
    public void insertTorneo(int idTorneo, String nombre, int idGanador)
    {
        String sql = "INSERT INTO Torneo(idTorneo,nombre, idGanador) VALUES(?,?,?)";

        try
                (
                        Connection conn = this.connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setInt(1, idTorneo);
            pstmt.setString(2, nombre);
            pstmt.setObject(3, idGanador);
            
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
    }
    public void insertFase(int idFase, String nombre, int puntosGanador, int puntosPerdedor)
    {
        String sql = "INSERT INTO Fase(idFase,nombre, puntosGanador, puntosPerdedor) VALUES(?,?,?,?)";

        try
                (
                        Connection conn = this.connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setInt(1, idFase);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, puntosGanador);
            pstmt.setInt(4, puntosPerdedor);
            
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
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

        
//        app.insertUsuario("Jonan", "Arana","joni",1);
//        app.insertUsuario("Alex", "sarona","romagnoli",1);
//        app.insertUsuario("Peru", "peruerro", "erro", 0);
//        
//        InsertData app1=new InsertData();
//        app.insertJugador(1,"Alejandro Galan",25,"España", "Adidas Metalbone", "Diestra", "Reves",0);
//        app.insertJugador(2,"Juan Lebron", 25, "España", "Babolat Technical Viper", "Diestra", "Derecha",0);
//        app.insertJugador(3,"Paquito Navarro", 32, "España", "BullPadel Hack", "Diestra", "Reves",0);
//        app.insertJugador(4,"Martin Di Nenno", 24, "Argentina", "BullPadel Vertex", "Diestra", "Derecha",0);
//        app.insertJugador(5,"Sanyo Gutierrez", 37, "Argentina", "Head Graphene", "Diestra", "Derecha",0);
//        app.insertJugador(6,"Agustin Tapia", 22, "Argentina", "Nox AT10", "Diestra", "Reves",0);
//        app.insertJugador(7,"Fernando Belasteguin", 42, "Argentina", "Wilson Bela Pro", "Diestra", "Reves",0);
//        app.insertJugador(8,"Pablo Lima", 34, "Brasil", "Asics Speed", "Izquierda", "Derecha",0);
//        app.insertJugador(9,"Juan Tello", 26, "Argentina","BullPadel Vertex" , "Diestra", "Reves",0);
//        app.insertJugador(10,"Federico Chingotto", 24, "Argentina","BullPadel Vertex", "Diestra", "Derecha",0);
        //app.insertJugador(11, "Franco Stupaczuk", 25, "Argentina", "Starvie Raptor", "Diestra", "Revés", 0);
       // app.insertJugador(12, "Alejandro Ruiz", 27, "España", "Adidas Metalbone", "Izquierda", "Derecha", 0);
       // app.insertJugador(13, "Arturo Coello", 19, "España", "Head Gamma Pro", "Izquierda", "Derecha", 0);
       // app.insertJugador(14, "Miguel Yanguas", 19, "España", "Nox AT10", "Diestra", "Derecha", 0);
       //app.insertJugador(15, "Iñigo Zaratiegui", 26, "España", "Starvie Raptor", "Diestra", "Revés", 0);
       // app.insertJugador(16, "Agustín Gutierrez", 23, "Argentina", "Starvie Raptor", "Diestra", "Revés", 0);
       // app.insertJugador(17, "Agustín Silingo", 38, "Argentina", "J Hayber Dominator", "Diestra", "Revés", 0);
       // app.insertJugador(18, "Javier Ruiz", 34, "España", "Siux Fenix", "Diestra", "Revés", 0);
       // 	app.insertJugador(19, "Miguel Lamperti", 43, "Argentina", "Nox ML10", "Diestra", "Revés", 0);
       // 	app.insertJugador(20, "Javier Rico", 23, "España", "Enebe Supra Carbon", "Izquierda", "Derecha", 0);
       // 	app.insertJugador(21, "Coki Nieto", 23, "España", "Starvie Titania", "Diestra", "Revés", 0);
       // 	app.insertJugador(22, "Lucho Capra", 28, "Argentina", "Siux Trilogy", "Izquierda", "Derecha", 0);
       // 	app.insertJugador(23, "Maximiliano Sanchez", 35, "Argentina", "Bullpadel Vertex", "Diestra", "Revés", 0);
//        app.insertFase(1, "Cuartos de Final", 0, 310);
//        app.insertFase(2, "Seminifales", 0, 610);
//        app.insertFase(3, "Final", 1700, 1020);
        
//        app.insertTorneo(1, "Adeslas Madrid Open",7);
//        app.insertTorneo(2, "Cervezas Victoria Marbella Master",1);
//        app.insertTorneo(3, "Estrella Damm Menorca Open",2);
//        app.insertTorneo(4, "Cascais Padel Master",1);
//        app.insertTorneo(5, "Buenos Aires Pádel Master",3);
        app.insertTorneo(6, "Estrella Damm Master Final", 0);
        //app.insertPartido(idPartido, idGanador, idPerdedor, resultGanador, resultPerdedor, idfase, idTorneo);
        //Torneo Adeslas Madrid Open
//        app.insertPartido(1,12,2,2,1,1,1);
//        app.insertPartido(2, 6, 9, 2, 1, 1, 1);
//        app.insertPartido(3, 13, 14, 2, 0, 1, 1);
//        app.insertPartido(4, 7, 15, 2, 0, 1, 1);
//        app.insertPartido(5, 12, 6, 2, 1, 2, 1);
//        app.insertPartido(6, 7, 13, 2, 1, 2, 1);
//        app.insertPartido(7, 7, 12, 2, 1, 3, 1);
        
        //Cervezas Victoria
//        app.insertPartido(8, 1, 16, 2, 0, 1, 2);
//        app.insertPartido(9, 3, 17, 2, 0, 1, 2);
//        app.insertPartido(10, 18, 10, 2, 1, 1, 2);
//        app.insertPartido(11, 8, 11, 2, 0, 1, 2);
//        app.insertPartido(12, 1, 3, 2, 0, 2, 2);
//        app.insertPartido(13, 8, 18, 2, 0, 2, 2);
//        app.insertPartido(14, 1, 8, 2, 0, 3, 2);
        
        //Menorca
//        app.insertPartido(15, 2, 19, 2, 0, 1, 3);
//        app.insertPartido(16, 5, 20, 2, 0, 1, 3);
//        app.insertPartido(17, 11, 9, 2, 1, 1, 3);
//        app.insertPartido(18, 4, 21, 2, 0, 1, 3);
//        app.insertPartido(19, 2, 5, 2, 0, 2, 3);
//        app.insertPartido(20, 4, 11, 2, 0, 2, 3);
//        app.insertPartido(21, 2, 4, 2, 0, 3, 3);
        //Cascais
//        app.insertPartido(22, 1, 20, 2, 0, 1, 4);
//        app.insertPartido(23, 22, 6, 2, 0, 1, 4);
//        app.insertPartido(24, 10, 13, 2, 0, 1, 4);
//        app.insertPartido(25, 3, 21, 2, 1, 1, 4);
//        app.insertPartido(26, 1, 22, 2, 0, 2, 4);
//        app.insertPartido(27, 10, 3, 2, 0, 2, 4);
//        app.insertPartido(28, 1, 10, 2, 1, 3, 4);
        
        //Buenos Aires
//        app.insertPartido(29, 2, 7, 2, 0, 1, 5);
//        app.insertPartido(30, 6, 18, 2, 1, 1, 5);
//        app.insertPartido(31, 12, 9, 2, 0, 1, 5);
//        app.insertPartido(32, 3, 23, 2, 0, 1, 5);
//        app.insertPartido(33, 6, 2, 2, 0, 2, 5);
//        app.insertPartido(34, 3, 12, 2, 0, 2, 5);
//        app.insertPartido(35, 3, 6, 2, 0, 3, 5);
    }
  
    

}