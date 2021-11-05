package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {

	public static void crearBaseDatos(String nombreFichero){
		
		String url= "C:/Users/Alumno/Desktop/Progra3/ProyectoProgra3/src/db/" +nombreFichero;
		
		try(Connection conn=DriverManager.getConnection(url)){
			if (conn!=null){
				DatabaseMetaData meta=conn.getMetaData();
				System.out.println("The driver name is "+meta.getDriverName());
				System.out.println("A new database has been created.");
			}
			
		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[]args){
		crearBaseDatos("test.db");
	}

}
