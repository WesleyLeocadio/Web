package DAO;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class CarrinhoServlet
 */
@WebServlet("/CarrinhoServlet")
public class CarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarrinhoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sessao = request.getSession();
		//pegar as vari�veis do request
		String id = request.getParameter("id");
		String command = request.getParameter("metodo");
		
		System.out.println(id+" "+command);
		
		//a fun��o getCookies retorna um array list com todos os objetos de cookies da requisi��o
		Cookie cookies[] = request.getCookies();
	
		
		String dadosCarrinho = new String();
		// Um cookie � um texto, esse "for" verifica o array list de cookies "cookies" e encontra 
		//o cookie chamado "carrinho". A string "dadosCarrinho" � criada para armazenar o texto do cookie 
		//que cont�m os dados do carrinho.
		
		for (int i = 0; i < cookies.length; i++) {
			//verifica se o nome de algum cookie em todo o array list � "carrinho"
			if(cookies[i].getName().equals("Carrinho")) 
				dadosCarrinho = cookies[i].getValue();	
		}
		
		Integer qtd = null;
		//verifica se o request foi para adicionar um produto
		String[] parts = dadosCarrinho.split(" ");
		if(command.equals("add")){
			//aqui ser�o feitos os algoritmos que manipular�o os dados do carrinho, "dadosCarrinho"
			//primeira condi��o para se o produto ja existir no carrinho
			for (int i = 0; i < parts.length; i++) {
				if (parts[i].contains(id+"Q")) {
					//se o produto ja existe eu vou mexer apenas na quantidade
					//quebro mais uma vez para alterar apenas a quantidade
					String[] parts2 = parts[i].split("Q");
					qtd = Integer.parseInt(parts[1]);
					qtd++;
					parts[1] = Integer.toString(qtd);
				}
				//segunda condi��o para de o produto n�o existir no carrinho
				else {
					// nesse caso vou criar um novo
					parts[parts.length +1] = (id+"Q1");
				}
			}
			//concateno tudo para os novos dados do carrinho
			for (int i = 0; i < parts.length; i++) {
				dadosCarrinho += parts[i]; 
				
			}
			
			
		}
		
		
		//verifica se o request foi para remover um produto
		if(command.equals("remove")){
			//aqui ser�o feitos os algoritmos que manipular�o os dados do carrinho, "dadosCarrinho"
			for (int i = 0; i < parts.length; i++) {
				if (parts[i].contains(id+"Q")) {
					//se o produto ja existe eu vou mexer apenas na quantidade
					//quebro mais uma vez para alterar apenas a quantidade
					String[] parts2 = parts[i].split("Q");
					if (parts2[1]=="1") {
						parts[i] = ("");
						break;
					}
					else {
						qtd = Integer.parseInt(parts[1]);
						qtd--;
						parts[1] = Integer.toString(qtd);
					}
				}
			}
			
			//concateno tudo para os novos dados do carrinho
			for (int i = 0; i < parts.length; i++) {
				dadosCarrinho += parts[i];
			}
		}
		
		
		
		// criando o cookie re vai armazenar o texto que representa os dados 
		//do carrinho.
		//aqui no final � criado um novo cookie que ir� receber
		//os dados do carrinho "dadosCarrinho" depois de serem manipulados e atualizados.
		Cookie produtosCarrinho = new Cookie("carrinho",dadosCarrinho);
		// em seguida o cookie � adicionado a resposta para ser envado ao servidor
		response.addCookie(produtosCarrinho);
		
	//	RequestDispatcher encaminhar = request.getRequestDispatcher("http://aulaa.herokuapp.com/InterfaceProduto");
		
	}
	

	
	
}
