class Main {
	
	public static void main(String [] args) {
		List<String> palavras = Arrays.asList("rodrigo", "paulo", "caelum");
		
		Comparator<String> comparador = new Comparator<String>() {
	  public int compare(String s1, String s2) {
	    return Integer.compare(s1.length(), s2.length()); 
	    }
	  }
		
    }
}
