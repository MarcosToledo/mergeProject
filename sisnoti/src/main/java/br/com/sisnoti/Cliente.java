package br.com.sisnoti;

import java.io.Serializable;

public class Cliente implements Serializable {
	private static final long serialVersionUID = -5786987210882488279L;
	private String nome;
	private String endereco;
	private int idade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
