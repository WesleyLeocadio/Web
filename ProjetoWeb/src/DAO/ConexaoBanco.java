package DAO;
import java.sql.*;

public class ConexaoBanco {

	private static final String USUARIO = "root";
	private static final String SENHA = "";
	private static final String CAMINHO = "jdbc:mysql://localhost:3306/programaweb";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private Connection conexao;

	// METODO QUE EFETUA A CONEXAO COM O BANCO DE DADOS
	public void conecta() {
		try {
			Class.forName(DRIVER); // Carrega o driver (inicializa um objeto da classe org.postgresql.Driver)
			conexao = DriverManager.getConnection(CAMINHO, USUARIO, SENHA); // Cria a conexao
			System.out.println("conectou ao banco");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e);
			System.out.println("Nao conectou");
		}
	}

	// METODO QUE DESCONECTA O BANCO DE DADOS
	public void desconecta() {
		try {
			conexao.close();// fecha a conexao
			System.out.println("desconectou!");
		} catch (SQLException ex) {
			System.err.println(ex);
			System.out.println("continua conectado");
		}
	}

	public Connection getConexao() {
		return conexao;
	}

}
