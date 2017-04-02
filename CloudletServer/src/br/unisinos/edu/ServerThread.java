package br.unisinos.edu;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import br.unisinos.edu.request.processor.GeneralRequestProcessor;

/**
 * Thread criada para atender um cliente do servidor.
 */
public final class ServerThread implements Runnable {
	private final Socket socket;
	private GeneralRequestProcessor requestProcessor;
	
	private ServerThread(Socket socket){
		this.socket = socket;
	}
	
	public static Runnable newInstance(Socket socket){
		return new ServerThread(socket);
	}
	
	/**
	 * Aguarda um request do cliente, ao receber o request, retorna ele como String.
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 */
	private Object waitForRequest() throws ClassNotFoundException, IOException  {
		return new ObjectInputStream(socket.getInputStream()).readObject();
	}
	
	private Object processRequest(Object request){
		return requestProcessor.processRequest(request);
	}
	
	/**
	 * Responde ao request do cliente com os bytes do arquivo solicidado.
	 * @param requestMsg Requisição (nome do arquivo desejado).
	 * @throws IOException
	 */
	private void sendResponse(Object response) throws IOException {
		ObjectOutputStream streamToClient = new ObjectOutputStream(socket.getOutputStream());
		streamToClient.writeObject(response);
		streamToClient.close();
	}

	/**
	 * Fecha o socket utilizado para comunicação.
	 */
	private void closeSocket() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inicia a thread criada para atender um cliente.
	 */
	public void run() {
		try {
			Object request = waitForRequest();
			Object response = processRequest(request);
			sendResponse(response);
		} catch (IOException | ClassNotFoundException e) {
			sendErrorResponse(e);
		} finally{
			closeSocket();
		}
	}

	private void sendErrorResponse(Exception e) {
		System.err.println("The server was unable to process the request: " + e.getMessage());
		try {
			sendResponse(e);
		} catch (IOException e1) {
			System.err.println(
					  "The server was unable to send "
					+ "the error response to the client: " + e.getMessage());
		}
	}

}
