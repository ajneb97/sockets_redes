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
}
