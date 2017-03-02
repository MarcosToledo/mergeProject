import java.io.Serializable;

public class Cliente implements Serializable {
	private static final long serialVersionUID = -5786987210882488279L;
	private String nomessss;
	private String enderecosss;
	private int idade;
	public boolean nicolasViado;

	public String getNome() {
		return nome;
	}

	public void setNomesss(String nome) {
		this.nome = nome;
	}

	public String getEnderecosss() {
		return endereco;
	}

	public void setEnderecosss(String endereco) {
		this.enderecosss = endereco;
	}

	public int getIdade() {
		return idade;
	}

	public void setNicolasViado(boolean viado) {
		this.viado = nicolasViado;
	}

	public boolean getNicolasViado() {
		return nicolasViado;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String marcosVaiTomarNoCu(String esseTaMais) {
		return "Marcos otário";
	}
}
