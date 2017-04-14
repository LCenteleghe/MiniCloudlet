package br.unisinos.edu;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import br.unisinos.edu.request.dto.ServiceExecutionRequest;
import br.unisinos.edu.request.dto.ServiceRegistrationRequest;
import br.unisinos.edu.request.dto.SimpleQueryRequest;

public class CloudletInterface {
	private Socket socket = new Socket();
	private InetSocketAddress socketAdress;
	
	private ObjectOutputStream streamToServer;
	private ObjectInputStream streamFromServer;
	
	public CloudletInterface(String cloudletAddress) throws UnknownHostException, IOException{
		socketAdress = new InetSocketAddress(cloudletAddress, 5555);
	}
	
	public String executeQuery(String query){
		SimpleQueryRequest sqr = new SimpleQueryRequest(query);
		return String.valueOf(sendRequestToServer(sqr));
	}
	
	
	public String registerService(String id, String entryMethod, Object code, String mimeType){
		Service service = new Service(id, entryMethod, code, mimeType);
		ServiceRegistrationRequest srr = new ServiceRegistrationRequest(service);
		return String.valueOf(sendRequestToServer(srr));
	}
	
	public String executeService(String serviceID, Object parameterData){
		ServiceExecutionRequest ser = new ServiceExecutionRequest(serviceID, parameterData);
		return String.valueOf(sendRequestToServer(ser));
	}
	
	
	private Object sendRequestToServer(Object request){
		if(!socket.isConnected()){
			openSocketAndConnectStreams();
		}
		
		try {
			streamToServer.writeObject(request);
			return streamFromServer.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private void openSocketAndConnectStreams() {
			try {
				socket.connect(socketAdress, 1000);
				streamToServer = new ObjectOutputStream(socket.getOutputStream());
				streamFromServer = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
	}
}
