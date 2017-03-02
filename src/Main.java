import java.util.function.Consumer;

class Main {
	
	public static void main(String [] args) {
		
		Usuario usuario = new Usuario();
		usuario.setNome("marcos");
		usuario.setTelefone("123456789");
		
		Consumer<Usuario> mostrador = (Usuario u) -> {System.out.println(usuario.getNome());};
	  }
}
