package br.edu.unisinos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import br.edu.unisinos.request.processor.GeneralRequestProcessor;

/**
 * Thread used to serve clients.
 */
public final class ServerThread implements Runnable {
	
	/** The socket. */
	private final Socket socket;
	
	/** The stream from client. */
	private ObjectInputStream streamFromClient;
	
	/** The stream to client. */
	private ObjectOutputStream streamToClient;

	/** The request processor. */
	private GeneralRequestProcessor requestProcessor = GeneralRequestProcessor.getInstance();

	/**
	 * Instantiates a new server thread.
	 *
	 * @param socket the socket
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private ServerThread(Socket socket) throws IOException {
		this.socket = socket;
		streamFromClient = new ObjectInputStream(socket.getInputStream());
		streamToClient = new ObjectOutputStream(socket.getOutputStream());

		System.out.println("Server thread started to serve the socket: " + socket);
	}

	/**
	 * Creates a new instance of this Server Thread.
	 *
	 * @param socket the socket
	 * @return the runnable
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Runnable newInstance(Socket socket) throws IOException {
		return new ServerThread(socket);
	}

	/**
	 * Waits for a request from the client. Once it's received returns it as an Object.
	 * 
	 * @return The request object.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private Object waitForRequest() throws ClassNotFoundException, IOException {
		return streamFromClient.readObject();
	}

	private Object processRequest(Object request) {
		System.out.println("Request received on socket: " + socket + " \nRequest: " + request);
		try {
			return requestProcessor.processRequest(request);
		} catch (Exception e) {
			return e.getMessage();
		}
	}


	/**
	 *  Sends a response to the client.
	 *
	 * @param response the response object
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void sendResponse(Object response) throws IOException {
		streamToClient.writeObject(response);
		System.out.println("Response send to socket " + socket + " \nResponse: " + response);
	}

	/**
	 * Closes the socket used for communication.
	 */
	private void closeSocket() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Starts the thread.
	 */
	public void run() {
		try {
			while (socket.isConnected()) {
				Object request = waitForRequest();
				Object response = processRequest(request);
				sendResponse(response);
			}
		} catch (IOException | ClassNotFoundException e) {
			sendErrorResponse(e);
		} finally {
			closeSocket();
		}
	}

	/**
	 * Sends and error response to the client.
	 *
	 * @param exception the exception that caused the error.
	 */
	private void sendErrorResponse(Exception exception) {
		System.err.println("The server was unable to process the request: " + exception.getMessage());
		try {
			sendResponse(exception);
		} catch (IOException e1) {
			System.err
					.println("The server was unable to send " + "the error response to the client: " + exception.getMessage());
		}
	}

}
