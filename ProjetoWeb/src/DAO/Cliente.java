package DAO;

public class Cliente {

	private int id;
	private String nome;
	private String email;
	private String senha;
	private String usuario;

	public Cliente() {

	}

	public Cliente(String nome, String email, String senha, String usuario) {

		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.usuario = usuario;
	}

	public Cliente(int id, String nome, String email, String senha,
			String usuario) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", email=" + email + ", senha="
				+ senha + ", usuario=" + usuario + "]";
	}

}
