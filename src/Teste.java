package br.com.sisnoti;

import java.io.Serializable;

import javax.inject.Inject;
import javax.enterprise.context.Dependent;

@Named
public class Teste implements Serializable {
	private static final long serialVersionUID = 8287093207248514005L;
	@Inject
	public static Cliente criente;

	public static Usuario usuario;
	
	public static String rolaDoMundo(){
		return criente.getNome();
	}
	
	public static void main(String[] args) {
		criente.setNome("Marcos, menino de São Caetano");
		System.out.println(rolaDoMundo());
	}
	
	public static void main(String[] args) {
		cliente.setNome("nicolas é um arrombado");
		System.out.println(rolaDoMundo());
	}
	
}
