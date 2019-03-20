package DAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastrarProduto
 */
@WebServlet("/CadastrarProduto")
public class CadastrarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarProduto() {
        super();
        // TODO Auto-generated constructor stub
    }
    ProdutoDAO c = new ProdutoDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String nome= request.getParameter("nome");
		 String  descricao= request.getParameter("descricao");
		 Integer preco= Integer.parseInt( request.getParameter("preco"));

		 Produto u = new Produto(preco,nome,descricao);
		 c.insertProduto(u);
		 	response.sendRedirect("CadastraProduto.jsp");
	}

	
	

}
