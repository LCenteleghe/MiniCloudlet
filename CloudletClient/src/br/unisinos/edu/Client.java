package br.unisinos.edu;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import br.unisinos.edu.request.dto.SimpleQueryRequest;
import br.unisinos.edu.request.dto.ServiceExecutionRequest;
import br.unisinos.edu.request.dto.ServiceRegistrationRequest;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		new Client().start();
	}

	public void start() throws UnknownHostException, IOException, ClassNotFoundException {
		SimpleQueryRequest checkRequest = new SimpleQueryRequest("sum");

		Socket socket = new Socket("127.0.0.1", 5555);

		ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());

		os.writeObject(checkRequest);

		ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
		
		os.writeObject(checkRequest);
		System.out.println(inputStream.readObject());
		
		Service service = new Service("sum", "sum", Sum.class, "application/javascript");
		
		ServiceRegistrationRequest registrationRequest = new ServiceRegistrationRequest(service);
		
		os.writeObject(registrationRequest);
		
		System.out.println(inputStream.readObject());
		
		os.writeObject(checkRequest);
		System.out.println(inputStream.readObject());
		
		ServiceExecutionRequest serviceExecution = new ServiceExecutionRequest("sum", null);
		
		os.writeObject(serviceExecution);
		System.out.println(inputStream.readObject());
		System.out.println(inputStream.readObject());
	}

}
