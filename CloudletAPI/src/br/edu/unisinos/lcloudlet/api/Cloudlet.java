package br.edu.unisinos.lcloudlet.api;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cloudlet {
	private static final int connectionTimeout = 1000;
	private Socket socket = new Socket();
	private InetSocketAddress socketAdress;
	
	private ObjectOutputStream streamToServer;
	private ObjectInputStream streamFromServer;
	
	public Cloudlet(String cloudletAddress) throws UnknownHostException {
		socketAdress = new InetSocketAddress(cloudletAddress, 5555);
	}
	
	public String executeQuery(String query){
		SimpleQueryRequest sqr = new SimpleQueryRequest(query);
		return String.valueOf(sendRequestToServer(sqr));
	}
	
	
	public String registerService(String id, String code, MimeType mimeType){
		Service service = new Service(id, code, mimeType.getCode());
		return registerService(service);
	}
	
	public String registerService(String id, Class<?> clazz, MimeType mimeType){
		Service service = new Service(id, ClassUtils.getClassBytes(clazz), mimeType.getCode());
		return registerService(service);
	}

	private String registerService(Service service) {
		ServiceRegistrationRequest srr = new ServiceRegistrationRequest(service);
		return String.valueOf(sendRequestToServer(srr));
	}
	
	public String executeService(String serviceID, String method, Object ... parameters){
		ServiceExecutionRequest ser = new ServiceExecutionRequest(serviceID, method, parameters);
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
				socket.connect(socketAdress, connectionTimeout);
				streamToServer = new ObjectOutputStream(socket.getOutputStream());
				streamFromServer = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
	}

	public boolean checkService(String serviceID) {
		SimpleQueryRequest sqr = new SimpleQueryRequest("CHECK " + serviceID);
		return Boolean.valueOf(sendRequestToServer(sqr).toString());
	}
}
