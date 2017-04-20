package br.edu.unisinos;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import br.edu.unisinos.lcloudlet.api.Service;

/**
 * Represents a service database.
 */
public class ServicesDataBase {
	private static ServicesDataBase instance;

	private final ConcurrentMap<String, Service> servicesMap;

	private ServicesDataBase() {
		servicesMap = new ConcurrentHashMap<String, Service>();
	}

	/**
	 * Gets the single instance of ServicesDataBase.
	 *
	 * @return single instance of ServicesDataBase
	 */
	public static ServicesDataBase getInstance() {
		if (Objects.isNull(instance)) {
			instance = new ServicesDataBase();
		}

		return instance;
	}

	/**
	 * Registers a service in this service base.
	 *
	 * @param service
	 *            the service to be registered.
	 * @return true, if successful
	 */
	public boolean registerService(Service service) {
		return Objects.isNull(servicesMap.putIfAbsent(service.getId(), service));
	}

	/**
	 * Gets a service by its ID.
	 *
	 * @param serviceID
	 *            the service ID
	 * @return the service of the given ID, or {@code null} if the service is
	 *         not in the database.
	 */
	public Service getService(String serviceID) {
		return servicesMap.get(serviceID);
	}

	/**
	 * Checks whether a service exists in this service base.
	 *
	 * @param serviceID the service ID
	 * @return true, if successful
	 */
	public boolean contains(String serviceID) {
		return servicesMap.containsKey(serviceID);
	}

	/**
	 * Gets the list of service IDs registered in this service base.
	 *
	 * @return a list of service IDs registered in this service base. 
	 */
	public Set<String> getServicesIDs() {
		return servicesMap.keySet();
	}
}
