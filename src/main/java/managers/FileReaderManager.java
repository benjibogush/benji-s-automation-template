package managers;
//import dataProviders.ConfigFileReader;
//import dataProviders.JsonDataReader;
import data_providers.JsonDataReader;
import data_providers.PropReader;

public class FileReaderManager {

	private static PropReader configFileReader;
	private static JsonDataReader jsonDataReader;
	private static FileReaderManager fileReaderManager  = new FileReaderManager();

	private FileReaderManager() {

	}
	 public static FileReaderManager getInstance()
	 {
		 return fileReaderManager;
	 }

	 public PropReader getConfigFileReader()
	 {

		 return (configFileReader == null) ? new PropReader():configFileReader;

	 }

	 public JsonDataReader getJsonDataReader() {

		 return (jsonDataReader == null)?new JsonDataReader():jsonDataReader;
	 }

}
