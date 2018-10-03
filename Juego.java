import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Juego {

	private ArrayList<String> palabras;
	private ArrayList<String> letrasUsadas;
	private Palabra palabra;
	private Conector conector;
	private boolean finalizado;
	private int fallos;
	
	public Juego() throws IOException {
		palabras = new ArrayList<String>();
		letrasUsadas = new ArrayList<String>();
		finalizado = false;
		fallos = 0;
		palabras.add("GALLETA");
		palabras.add("REDES");
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
		while(!finalizado) {	
			mostrarPalabra();
			preguntaLetra();
			
		}
		conector.cerrar();
	}
	
	public void preguntaLetra() throws IOException {
		
		System.out.println("");
		String letra = getLetra();
		//AQUI COMPROBACIONES DE QUE SEA VERDADERAMENTE UNA LETRA, NO UNA CADENA DE STRINGS, NO UN NUMERO, NO VACIO
		//PUEDE CREARSE UNA CLASE APARTE DE UTILIDADES PARA VERIFICAR ESTO
		if(!letrasUsadas.contains(letra)) {
			letrasUsadas.add(letra);
			if(palabra.letraEstaEnPalabra(letra)) {
				palabra.setLetra(letra);
				System.out.println("CORRECTO! La letra "+letra+" si esta en la palabra.");
				if(palabra.isPalabraCompleta()) {
					System.out.println("¡HAS GANADO! La palabra era: "+palabra.getTexto());
					finalizado = true;
				}
			}else {
				falloLetra(letra);
				if(fallos == 3) {
					//Terminar juego y conexion
					System.out.println("¡HAS PERDIDO!");
					finalizado = true;
				}
			}
		}else {
			System.out.println("Ya has usado la letra "+letra+", intenta con otra.");
		}
		
	}
	
	public String getLetra() throws IOException {
        String letra;
        do {
        	System.out.println("Escribe una letra");
        	letra = conector.getEntrada().readLine();
            if (!letra.matches("^[a-zA-Z]")) {
                System.out.println("Por favor asegurate de que estes ingresando una letra.");
                
            }
        }while (!letra.matches("^[a-zA-Z]")) ;
        return letra.toUpperCase();
	}
	
	public void mostrarPalabra() {
		System.out.println("____________________________________");
		System.out.println("");
		System.out.println("PALABRA: "+palabra.getLineas());
		if(!letrasUsadas.isEmpty()) {
			String letras = "(";
			for(int i=0;i<letrasUsadas.size();i++) {
				if(i==letrasUsadas.size()-1) {
					letras = letras+letrasUsadas.get(i);
				}else {
					letras = letras+letrasUsadas.get(i)+",";
				}
				
			}
			System.out.println("Letras Usadas: "+letras+")");
		}
		System.out.println("Fallos: ("+this.fallos+")");
		System.out.println("");
		System.out.println("____________________________________");
	}
	
	public void falloLetra(String letra) {
		fallos++;
		System.out.println("FALLO! La letra "+letra+" no esta en la palabra. Ahora tienes: "+fallos+" fallo(s).");		
	}
}
