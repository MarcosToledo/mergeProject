package br.com.sisnoti;

import java.io.Serializable;

import javax.inject.Inject;
import javax.enterprise.context.Dependent;

@Dependent
public class Teste implements Serializable {
	private static final long serialVersionUID = 8287093207248514005L;
	@Inject
	public static Cliente cliente;
	
	public static String holaMundo(){
		return cliente.getNome();
	}
	
	public static void main(String[] args) {
		cliente.setNome("Vanderson");
		System.out.println(holaMundo());
	}
	
}
