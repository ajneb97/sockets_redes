import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Juego {

	private ArrayList<String> palabras;
	private Palabra palabra;
	private Conector conector;
	private boolean finalizado;
	
	public Juego() throws IOException {
		palabras = new ArrayList<String>();
		finalizado = false;
		palabras.add("PERRO");
		palabras.add("GALLETA");
		palabras.add("REDES");
		palabras.add("ARBOLEDA");
		Random r = new Random();
		int pos = r.nextInt(palabras.size()-1);
		this.palabra = new Palabra(palabras.get(pos));
		this.conector = new Conector();
		conector.iniciar();
	}
	
	
	public void comenzar() throws IOException {
		System.out.println("La idea del juego es escribir una letra cada vez para adivinar la Palabra.");
		System.out.println("Si la letra se encuentra en la Palabra, se agregara, sino obtendras 1 Fallo.");
		System.out.println("(Si obtienes 3 fallos, pierdes el juego.)");
		System.out.println("");
		System.out.println("ENTER para Comenzar.");
		conector.getEntrada().readLine();
		
		System.out.println("");
		System.out.println("PALABRA: "+palabra.getLineas());
		System.out.println("");
		while(!finalizado) {
			preguntaLetra();
		}
	}
	
	public void preguntaLetra() throws IOException {
		System.out.println("Escribe una letra");
		String letra = conector.getEntrada().readLine();
		//AQUI COMPROBACIONES DE QUE SEA VERDADERAMENTE UNA LETRA, NO UNA CADENA DE STRINGS, NO UN NUMERO, NO VACIO
		//PUEDE CREARSE UNA CLASE APARTE DE UTILIDADES PARA VERIFICAR ESTO
	}
}
