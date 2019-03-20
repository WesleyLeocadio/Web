package DAO;

public class Produto {

	private int id;
	private int preco;
	private String nome;
	private String Descricao;

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(int preco, String nome, String descricao) {
		super();
		this.preco = preco;
		this.nome = nome;
		Descricao = descricao;
	}

	public Produto(int id, int preco, String nome, String descricao) {
		super();
		this.id = id;
		this.preco = preco;
		this.nome = nome;
		this.Descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	@Override
	public String toString() {
		return "Produto [preco=" + preco + ", nome=" + nome + ", Descricao="
				+ Descricao + "]";
	}
}
