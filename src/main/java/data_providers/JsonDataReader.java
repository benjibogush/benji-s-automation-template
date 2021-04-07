package data_providers;

import com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.empData;
import testDataTypes.LoginData;
import testDataTypes.searchEmpData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonDataReader {

	private final String loginInfoFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath()+"login.json";
	private final String empInfoFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath()+"newEmp.json";
	private final String searchEmpFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath()+"searchEmp.json";
	private final List<LoginData> userList;
	private final List<empData> employeeList;
	private final List<searchEmpData> searchDataList;


	public JsonDataReader()
	{
		userList = getUserData();
		employeeList = getEmpData();
		searchDataList = getSearchEmpData();
	}

	private List<LoginData> getUserData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(loginInfoFilePath));
			LoginData[] users = gson.fromJson(bufferReader, LoginData[].class);
			return Arrays.asList(users);
		}
		catch(FileNotFoundException e) {
		throw new RuntimeException("Json file was not found in the path " +loginInfoFilePath );
		}finally {
			try {
				if(bufferReader != null)bufferReader.close();}
			catch(IOException ignore) {}
		}
	}

	private List<empData> getEmpData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(empInfoFilePath));
			empData[] employees = gson.fromJson(bufferReader, empData[].class);
			return Arrays.asList(employees);
		}
		catch(FileNotFoundException e) {
		throw new RuntimeException("Json file was not found in the path " +empInfoFilePath );
		}finally {
			try {
				if(bufferReader != null)bufferReader.close();}
			catch(IOException ignore) {}
		}
	}

	private List<searchEmpData> getSearchEmpData(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(searchEmpFilePath));
			searchEmpData[] search = gson.fromJson(bufferReader, searchEmpData[].class);
			return Arrays.asList(search);
		}
		catch(FileNotFoundException e) {
		throw new RuntimeException("Json file was not found in the path " +searchEmpFilePath );
		}finally {
			try {
				if(bufferReader != null)bufferReader.close();}
			catch(IOException ignore) {}
		}
	}

	public final LoginData getUserByName(String userName ) {
		return userList.stream().filter(x -> x.getUsername().equalsIgnoreCase(userName)).findAny().get();

	}

	public final empData getEmployeeByName(String empName)
	{
		return employeeList.stream().filter(x -> x.name.fname.equalsIgnoreCase(empName)).findAny().get();
	}

	public final searchEmpData getSearchById(Integer id)
	{


		return searchDataList.stream().filter(x -> x.empSearch.equals(id)).findAny().get();

	}




}
