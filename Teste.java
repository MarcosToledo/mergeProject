package br.com.sisnoti;

import java.io.Serializable;

import javax.inject.Inject;
import javax.enterprise.context.Dependent;
import br.com.sisnoti.Usuario

@Named
public class Teste implements Serializable {
	private static final long serialVersionUID = 8287093207248514005L;
	@Inject
	protected static Cliente cliente;

	protected static Usuario usuario;
	
	public static String mostraNome(){
		return cliente.getNome();
	}
	
	public static void main(String[] args) {
		cliente.setNome("Marcos boy de São Caetano");
		System.out.println(mostraNome());
	}
	
}
