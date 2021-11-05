package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectData {
	private Connection dbConnect;
	public void SelectData() throws SQLException{
		this.dbConnect=DriverManager.getConnection("proyecto.db");
	
		
	}
	public void selectData() throws SQLException {
		
		Statement stmt =dbConnect.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT ALUMNO WHERE NOMBRE = 'Jon'");
	}
}
