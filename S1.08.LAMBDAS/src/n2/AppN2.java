package n2;

public class AppN2 {

	public static void main(String[] args) {
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("=============================================");
		
		
		I02_FunctionalInterface i02Suma = (x, y) -> (float)x + y; 
		I02_FunctionalInterface i02Resta = (x, y) -> (float)x - y; 
		I02_FunctionalInterface i02Multiplicacio = (x, y) -> (float)x * y; 
		I02_FunctionalInterface i02Divisio = 
				(x, y) -> {
					if(x == 0 || y == 0) {
						System.out.println("Error: No es pot dividir entre 0");
						return 0;
					}else {
						return (float)x / y;
					}
				};
		
		System.out.println(i02Suma.operacio(10, 6));
		System.out.println(i02Resta.operacio(10, 6));
		System.out.println(i02Multiplicacio.operacio(10, 6));
		System.out.println(i02Divisio.operacio(10, 6));
		System.out.println(i02Divisio.operacio(10, 0));
		
	}

}
