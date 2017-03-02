import java.io.Serializable;

public class Cliente implements Serializable {
	protected static final long serialVersionUID = -5786987210882488279L;
	protected String nomessss;
	protected String enderecosss;
	protected int idade;
	public boolean nicolasViado;
	protected boolean tomaSuquinho;

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
<<<<<<< HEAD
	
	public String getARROMBADO() {
		return TUDOUMBANDODEARROMADO;
	}
	
	public boolean isTomaSuquinho(){
		return this.nome.toLowerCase().contains("nicolas") : true ? false;
	}
=======

	public boolean isTomaSuquinho(){
		return this.nome.toLowerCase().contains("nicolas") : true ? false;
	}

>>>>>>> branch 'master' of https://github.com/MarcosToledo/mergeProject.git
}
