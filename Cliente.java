package br.com.sisnoti;

import java.io.Serializable;

public class Cliente implements Serializable {
	private static final long serialVersionUID = -5786987210882488279L;
	protected String nomessss;
	protected String enderecosss;
	protected int idadessssssss;
	protected boolean nicolasViado;
	protected boolean irTomarSuco;

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

	public int getIdadessssssss() {
		return idadessssssss;
	}

	public void setNicolasViado(boolean viado) {
		this.viado = nicolasViado;
	}

	public boolean getNicolasViado() {
		return nicolasViado;
	}

	public void setIdadessssssss(int idadessssssss) {
		this.idadessssssss = idadessssssss;
	}
	
	public String marcosVaiTomarNoCu(String esseTaMais) {
		return "Marcos otário";
	}

	public boolean isTomarSuco(){
		return this.nome.toLowerCase().contains("nicolas") : true ? false;
	}
}
