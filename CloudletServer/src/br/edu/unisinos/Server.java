package br.edu.unisinos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Represents the Cloudlet server.
 */
public class Server {
	private static final int SERVER_DEFAULT_PORT = 5555;
	private ServerSocket serverSocket;
	
	private Server(int port) throws IOException{
		serverSocket = new ServerSocket(port);
	}


	/**
	 * Starts the server.
	 *
	 * @param port the port where the server will receive connections.
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void start(int port) throws IOException {
		System.out.println("The server has started.");
		
		//Wait for connections and delegate them to threads.
		while(true){
			Socket socket = waitForConnection();
			new Thread(ServerThread.newInstance(socket)).start();
		}
	
	}


	/**
	 * Wait for connection.
	 *
	 * @return the socket
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private Socket waitForConnection() throws IOException {
		return serverSocket.accept();
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		new Server(SERVER_DEFAULT_PORT).start(SERVER_DEFAULT_PORT);
	}
}
