package DAO;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {

	private final ConexaoBanco con = new ConexaoBanco();
	private final String INSERTUSUARIO = "INSERT INTO CLIENTES(NOME,EMAIL,SENHA,USUARIO) VALUES (?,?,?,?)";
	private final String LISTCLIENTE = "SELECT * FROM USUARIO";
	private final String BUSCARUSUARIO = "SELECT * FROM CLIENTES WHERE  email = ?";

	public boolean insertCliente(Cliente u) {
		try {
			// CONECTA
			con.conecta();

			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(INSERTUSUARIO);

			preparaInstrucao.setString(1, u.getNome().toUpperCase());
			preparaInstrucao.setString(2, u.getEmail().toUpperCase());
			preparaInstrucao.setString(3, u.getSenha().toUpperCase());
			preparaInstrucao.setString(4, u.getUsuario().toUpperCase());

			// EXECUTA A INSTRUCAO
			preparaInstrucao.execute();

			// DESCONECTA
			con.desconecta();
			System.out.print("foi  " + u);
			return true;

		} catch (SQLException e) {
			return false;

		}

	}

	public ArrayList<Cliente> listCliente() {
		ArrayList<Cliente> lista = new ArrayList<>();

		try {
			// CONECTA
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(LISTCLIENTE);

			// EXECUTA A INSTRUCAO
			ResultSet rs = preparaInstrucao.executeQuery();

			// TRATA O RETORNO DA CONSULTA
			while (rs.next()) { // enquanto houver registro
				Cliente u = new Cliente(rs.getInt("ID"), rs.getString("NOME"),
						rs.getString("EMAIL"), rs.getString("SENHA"),
						rs.getString("USUARIO"));
				System.out.println(u);

				lista.add(u);
			}
			// DESCONECTA
			con.desconecta();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// ///////////////// Collections.sort(lista);/////////////////////////
		return lista;
	}

	public Cliente autenticacao(String nome) {
		Cliente u = null;

		try {
			// CONECTA
			con.conecta();
			PreparedStatement preparaInstrucao = con.getConexao()
					.prepareStatement(BUSCARUSUARIO);
			// SETA OS VALORES DA INSTRUCAO
			// OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
			preparaInstrucao.setString(1, nome);
			// EXECUTA A INSTRUCAO
			ResultSet rs = preparaInstrucao.executeQuery();
			// TRATA O RETORNO DA CONSULTA
			if (rs.next()) {
				u = new Cliente(rs.getInt("id"), rs.getString("nome"),
						rs.getString("email"), rs.getString("senha"),
						rs.getString("usuario"));
			}
			System.out.println("encontrado");

			// DESCONECTA
			con.desconecta();

		} catch (SQLException e) {
			System.out.println(e.getMessage() + "errooooooooooooo");
		}
		return u;

	}

}
