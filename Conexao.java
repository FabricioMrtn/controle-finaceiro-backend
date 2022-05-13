package br.com.fabricioMrtn.challenge.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	//NOME DO USUARIO MYSQL
	private static final String USERNAME = "root";
	
	//SENHA BANCO
	private static final String PASSWORD = "Xml123abc2019@";
	
	//CAMINHO DB: PORTA/BANCO DE DADOS
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/db_challenge";
	
	/*
	 * Conexao db
	 */
	public static Connection createConnectionToMySQL() throws Exception {
			//faz a classe ser carregada pela JVM
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
			return connection;
	}
	
	public static void main(String[] args) throws Exception {
		//recuperar conec=xão com db
		Connection con = createConnectionToMySQL();
		
		//testar se a conexão é nula
		if(con!=null) {
			System.out.println("Conexão obtida com sucesso");
			con.close();
		}
		
	}
	
}
