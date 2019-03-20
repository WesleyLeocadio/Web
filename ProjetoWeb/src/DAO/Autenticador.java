package DAO;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class BuscarCliente
 */
@WebServlet("/Autenticador")
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Autenticador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	ClienteDAO c = new ClienteDAO();
	ConexaoBanco con = new ConexaoBanco();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Cliente a = c.autenticacao(email);
		HttpSession session;
		if (a != null) {
			session = request.getSession();
			session.setAttribute("user", a.getNome());
			session.setAttribute("cliente-logado", "logado");

			session.setMaxInactiveInterval(100);

			if (a.getUsuario().equals("ADMINISTRADOR")) {
				response.sendRedirect("PrincipalAdm.jsp");
			} else {
				response.sendRedirect("PrincipalUser.jsp");
			}

		} else {
			response.sendRedirect("erroLogin.jsp");

		}
	}
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession sessao = req.getSession(false);
		if (sessao != null) {
			sessao.invalidate();
		}
		resp.sendRedirect("Login.jsp");
		
}}
