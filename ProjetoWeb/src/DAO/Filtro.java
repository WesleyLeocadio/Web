package DAO;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
/**
 * Servlet Filter implementation class Filtro
 */

@WebFilter(urlPatterns = {"/PrincipalUser.jsp","/PrincipalAdm.jsp","/erroLogin.jsp","/CadastraProduto.jsp","/ProdutosAdm.jsp","/InterfaceCarrinho.jsp","/InterfaceProduto.jsp","/CadastrarProduto",})

public class Filtro implements Filter {

	/**
	 * Default constructor.
	 */
	public Filtro() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		

		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest =(HttpServletRequest)request;
		String url= httpServletRequest.getRequestURI();
		HttpSession sessao = httpServletRequest.getSession();
		if(sessao.getAttribute("user")!=null || (url.lastIndexOf("Login.jsp")>-1)|| url.lastIndexOf("Autenticador")>-1){
			
			chain.doFilter(request, response);
		}else{
			((HttpServletResponse)response).sendRedirect("Login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
