package br.edu.unisinos;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import br.edu.unisinos.lcloudlet.api.Service;

public class ServicesBase {
	private static ServicesBase instance;
	
	private final ConcurrentMap<String, Service> servicesMap;
	
	private ServicesBase(){
		servicesMap = new ConcurrentHashMap<String, Service>();
	}
	
	public static ServicesBase getInstance(){
		if(Objects.isNull(instance)){
			instance = new ServicesBase();
		}
		
		return instance;
	}
	
	public boolean registerService(Service service){
		return Objects.isNull(servicesMap.putIfAbsent(service.getId(), service));
	}
	
	public Service getService(String serviceID){
		return servicesMap.get(serviceID);
	}
	
	public boolean contains(String serviceID){
		return servicesMap.containsKey(serviceID);
	}
	
	public Set<String> getServicesIDs(){
		return servicesMap.keySet();
	}
}
