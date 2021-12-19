package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
	 private static Connection connect()
	    {
	        String url = "jdbc:sqlite:basededatos.db";
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
	 public static void deleteJugador(int idJugador){
	        String sql = "DELETE FROM jugador "
	        		+ "WHERE IDJUGADOR=?; ";
	        		

	        try
	                (
	                        Connection conn = connect();
	                        PreparedStatement pstmt = conn.prepareStatement(sql)
	                )
	        {
	        	pstmt.setInt(1, idJugador);
	    	
	            pstmt.executeUpdate();

	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }

}
