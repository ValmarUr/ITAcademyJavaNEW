/*
 * 	IT ACADEMY : ITINERARI JAVA
 * 
 * 		SPRINT 3.Patterns
 * 		Tasca S3.02.Patterns 2
 * 		Nivell 1
 * 
 * 		ALUMNE: Juan Emilio Fernández Reinaldos
 * 		
 */

package N1.OBSERVER;

import java.util.List;

public class App {

	public static void main(String[] args) {

		Subject agent = new AgentBorsa();
		
		//AbanteAgencia abante = new AbanteAgencia(agent);
		//SolventisAgencia solventis = new SolventisAgencia(agent);
		new AbanteAgencia(agent);
		new SolventisAgencia(agent);
		
		//App app = new App();
		//Simula l'entrada de dades --> + info a la classe Borsa.java
		new App().demoBorsa(new Borsa().valorsBorsa, agent);

	}

	private void demoBorsa(List<Integer> llista, Subject agent) {
		
		for(int valor:llista) {
			agent.setState(valor);
			System.out.println("///////////////////////////////");
		}
		
	}	
}
