package n1singleton;

import java.util.ArrayList;

public class Undo {

	private static Undo instancia;
	
	private Undo() {}
		
	public static Undo getInstancia() {
		if (instancia == null) {
			instancia = new Undo();
		}
		return instancia;
	}
	
	private ArrayList<String> registro = new ArrayList<>();
	
	//MÈTODES
	public void ejecutar() {
		
		System.out.println(
				"\n///////////////////////////////////////////////////////////////////"+
				"\nBASIC BASH v1.0"+
				"\n--(escribe el comando help para obtener un listado de los comandos)"+
				"\n///////////////////////////////////////////////////////////////////"+
				"\n");
		
		String command;
		boolean salir = false;
		
		do {
			command = Lector.leer(">>");
			
			if (command.isBlank()) {continue;}
			
			addComm(command);
		
			String[] commPieces = command.replaceFirst("^\\s+","").split("\\s+");
			//String comm = command.substring(0, 6);
			//System.out.println(comm);
			//System.out.println(Arrays.toString(commPieces));
			
			if(commPieces.length == 1) {
				
				switch (commPieces[0]) {
					case "list":
						listComm();
						break;
					case "help":
						System.out.println(
							"\n    help: ayuda del sistema"+
							"\n    list: listar el historial de los comandos anteriormente utilizados"+
							"\n    delete n: borrar del historial el comando de índice 'n' seleccionado"+
							"\n    exit: salir de la aplicación"+
							"\n");
						break;
					case "exit":
						System.out.println(
							"\nCerrando aplicación..."+
							"\nBye! =)");
						salir = true;
						break;
					default:			
				}
			}
			
			if(commPieces[0].equals("delete") && commPieces.length == 2) {
				
				try {
					int index = Integer.parseInt(commPieces[1]);
					delComm(index);
					
				}catch(Exception e) {
					System.out.println("Índice de comando incorrecto");
				}
			}
			
		}while (!salir);
		
	}//end ejecutar
	
	
	public void addComm(String input){
		
		registro.add(input);
		//System.out.println("Add command '" + input + "' to list");
	}
	
	public void listComm() {
		
		int i = 1;
		
		for(String s : registro) {
			System.out.println(i + "\t" + s);
			i++;
		}
		
	}
	
	public void delComm(int index) {
		
		registro.remove(index-1);
		//System.out.println("Del command from list");
	}
}
