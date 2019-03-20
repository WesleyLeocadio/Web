package DAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


/**
 * Servlet implementation class CadastrarCliente
 */
@WebServlet("/CadastrarCliente")
public class CadastrarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

    ClienteDAO c = new ClienteDAO();
    ConexaoBanco con = new ConexaoBanco();
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String nome= request.getParameter("nome");
		 String email= request.getParameter("email");
		 String senha= request.getParameter("senha");
		 String usuario= request.getParameter("usuario");

		 Cliente u = new Cliente(nome,email,senha,usuario);

		if( c.insertCliente(u)){		 	
			response.sendRedirect("Login.jsp");

		}else{
			response.sendRedirect("erroLogin.jsp");

		}
		
		
	}

}
