import java.util.ArrayList;

public class Palabra {

	private String texto;
	private ArrayList<String> espacios;
	public Palabra(String texto) {
		this.texto = texto;
		this.espacios = new ArrayList<String>();
		for(int i=0;i<texto.length();i++) {
			espacios.add("-1");
		}
	}
	
	public String getTexto() {
		return this.texto;
	}
	
	public String getLineas() {
		String lineas = "";
		for(int i=0;i<this.espacios.size();i++) {
			if(this.espacios.get(i).equals("-1")) {
				lineas = lineas+"_ ";
			}else {
				lineas = lineas+this.espacios.get(i)+" ";
			}
		}
		return lineas;
	}
	
	public boolean letraEstaEnPalabra(String letra) {
		if(texto.contains(letra)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void setLetra(String letra) {
		for(int i=0;i<texto.length();i++) {
			if(texto.substring(i, i+1).equals(letra)) {
				espacios.set(i, letra);
			}
		}
	}
	
	public boolean isPalabraCompleta() {
		int cont = 0;
		for(int i=0;i<this.espacios.size();i++) {
			if(!this.espacios.get(i).equals("-1")) {
				cont++;
			}
		}
		
		if(texto.length() == cont) {
			return true;
		}else {
			return false;
		}
	}
}
