package br.com.sisnoti;

import java.io.Serializable;

import javax.inject.Inject;
import javax.enterprise.context.Dependent;

@Named
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	public static Cliente cliente;

	public static String retornaONomeDoCrient(){
		return cliente.getNome();
	}
	
	public static void main(String[] args) {
		cliente.marcosDaOCu("Nicolas lindo e maravilhoso");
		System.out.println(retornaONomeDoCrient());
        System.out.println(cliente.isTomaSuquinho());
	}
	
	public static void main(String[] args) {
		cliente.setNome("ADICIONANDO MAIS UM");
		System.out.println(retornaONomeDoCrient());
        System.out.println(cliente.isTomaSuquinho());
	}
}
