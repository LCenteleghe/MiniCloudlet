package br.edu.unisinos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static final int SERVER_DEFAULT_PORT = 5555;
	private ServerSocket serverSocket;
	
	private Server(int port) throws IOException{
		serverSocket = new ServerSocket(port);
	}

	/**
	 * Inicia o servidor.
	 * @param port Porta na qual o servidor ser� iniciado.
	 * @throws IOException
	 */
	public void start(int port) throws IOException {
		System.out.println("The server has started.");
		
		//Aguarda conex�es, e delega elas para uma thread.
		while(true){
			Socket socket = waitForConnection();
			new Thread(ServerThread.newInstance(socket)).start();
		}
	
	}

	/**
	 * Aguarda por uma conex�o.
	 * @return O socket da conex�o recebida.
	 * @throws IOException
	 */
	private Socket waitForConnection() throws IOException {
		return serverSocket.accept();
	}

	public static void main(String[] args) throws IOException {
		new Server(SERVER_DEFAULT_PORT).start(SERVER_DEFAULT_PORT);
	}
}
