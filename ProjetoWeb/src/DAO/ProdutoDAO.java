package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
	
	
	private final ConexaoBanco con = new ConexaoBanco();
	private final String INSERTPRODUTO = "INSERT INTO PRODUTOS(PRECO,NOME,DESCRICAO) VALUES (?,?,?)";
	private final String LISTPRODUTO = "SELECT * FROM PRODUTOS";
	private final String BUSCARPRODUTO = "SELECT * FROM PRODUTOS WHERE ID = ?";

	public boolean insertProduto(Produto u) {
		try {
			// CONECTA
			con.conecta();

			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(INSERTPRODUTO);

			preparaInstrucao.setString(2, u.getNome().toUpperCase());
			preparaInstrucao.setInt(1, u.getPreco());
			preparaInstrucao.setString(3, u.getDescricao().toUpperCase());
			
			

			// EXECUTA A INSTRUCAO
			preparaInstrucao.execute();
			
			// DESCONECTA
			con.desconecta();
			 System.out.print("foi  "+u);
			return true;

		} catch (SQLException e) {
			return false;

		}

	}

	public List<Produto> buscarTodos() {
		List<Produto> lista = new ArrayList<Produto>();

		try {
			// CONECTA
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(LISTPRODUTO);
			// EXECUTA A INSTRUCAO
			ResultSet rs = preparaInstrucao.executeQuery();
			System.out.println("chegou");

			// TRATA O RETORNO DA CONSULTA
			while (rs.next()) { // enquanto houver registro
				Produto u = new Produto(rs.getInt("id"),rs.getInt("preco"), rs.getString("nome"), rs.getString("descricao"));
				System.out.println(u);

				lista.add(u);
			}
			// DESCONECTA
			con.desconecta();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return lista;
	}
Cliente u;

	public Produto buscarUsuario(int nome) {
		Produto u=null;
		try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(BUSCARPRODUTO);
			//SETA OS VALORES DA INSTRUCAO
            //OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setInt(1,nome);
          


            // EXECUTA A INSTRUCAO
            ResultSet rs = preparaInstrucao.executeQuery();

            //TRATA O RETORNO DA CONSULTA
           
            
			u = new Produto(rs.getInt("ID"),rs.getInt("PRECO"), rs.getString("NOME"), rs.getString("DESCRICA0"));

           // DESCONECTA
            con.desconecta();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "errooooooooooooo");
        }
		return u;
        
    }

}
