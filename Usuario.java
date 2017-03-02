package br.com.sisnoti;

import java.io.Serializable;

import javax.inject.Inject;
import javax.enterprise.context.Dependent;
import br.com.sisnoti.Cliente;

@Named
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	public static Cliente cliente;

	public static String nomeDoCliente(){
		return cliente.getNome();
	}
	
	public static void main(String[] args) {
		cliente.setNome("Nicolas viadão");
        System.out.println(nomeDoCliente());
		System.out.println(cliente.isTomarSuco()); //Se der True já sabe kkkkkk
	}
	
}
