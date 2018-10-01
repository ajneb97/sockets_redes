import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Conector {

	private ServerSocket server;
	private Socket socket;
	private int puerto = 7500;
	private DataOutputStream salida;
	private BufferedReader entrada;
	
	public void iniciar() {
		try {
			server = new ServerSocket(puerto);
			socket = new Socket();
			socket = server.accept();
			
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			salida = new DataOutputStream(socket.getOutputStream());
			salida.writeBytes("CONECTADO A JUEGO.");
		}catch(Exception e) {
			
		}
	}
	
	public void cerrar() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedReader getEntrada() {
		return this.entrada;
	}
}
