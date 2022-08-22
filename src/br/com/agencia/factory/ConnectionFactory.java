package br.com.agencia.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// nome do usuario
	private static final String USERNAME = "root";
	
	// senha
	private static final String PASSWORD = "17fd2210";
	
	// CAMINHO DO BANCO DE DADOS. PORTA
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agencia";
	
	
	public static Connection createConnectionToMySQL() throws Exception {
		
	   Class.forName("com.mysql.jdbc.Driver");
	   
	   Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	   
	   return connection;	
	}
	
	
	public static void main(String[] args) throws Exception {
		
		Connection con = createConnectionToMySQL();		
		if(con != null) {
			System.out.println("Conexão obtida com sucesso!");
			con.close();
			
		}	
	}
}
