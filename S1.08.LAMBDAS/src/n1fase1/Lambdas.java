package n1fase1;

import java.util.List;
import java.util.stream.Collectors;

public class Lambdas {

	public List<String> lambdaEx1 (List<String> llista){
		
		return llista.stream().filter(s->s.startsWith("A")).filter(s -> s.length() == 3).collect(Collectors.toList());
	}
	
	public String lambdaEx2 (List<Integer> llista) {
		
		return llista.stream().map(n -> (n % 2 == 0)? "e" + n: "o" + n).collect(Collectors.joining(", "));
	}
	
	public List<String> lambdaEx3 (List<String> llista){
		
		return llista.stream().filter(s -> s.contains("o")).collect(Collectors.toList());
	}

	public List<String> lambdaEx4 (List<String> llista){
		
		return llista.stream().filter(s -> s.length() > 5).collect(Collectors.toList());
	}
	
	public void lambdaEx5 (List<String> llista){
		//Consumer<String> c = s -> System.out.println(s);
		//llista.stream().forEach(c);
		
		llista.stream().forEach(s -> System.out.println(s));
	}
	
	public void lambdaEx6 (List<String> llista){
		
		llista.stream().forEach(System.out::println);
	}
	
	
}
