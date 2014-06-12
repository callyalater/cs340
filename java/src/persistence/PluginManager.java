package persistence;

/**
 * This is called from the server.java and takes a parameter as to which persistence model to use.
 * It then parses the config file and creates a new instance of the appropriate storage persistence class.
 * @author scottdaly
 *
 */
public class PluginManager {
	
	
	/**
	 * Parses the config file based on the persistence type.
	 * 
	 * Parse file will contain the following information: path, name of plugin, name of plugin class
	 * 
	 * @param persistanceType that is specified from the command line.
	 */
	public void parseConfig(String configFile) {
		
	}
	
	/**
	 * Calls initialize on the persistence object in order to start connections to storages
	 */
	public void initPersistence(String persistenceType) {
		
	}
	
	/**
	 * Returns the newly created persistence object to be passed to the Server Model Facade
	 */
	public void getPersistenceObject() {
		
	}

}
