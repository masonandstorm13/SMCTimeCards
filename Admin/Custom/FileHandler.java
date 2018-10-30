package Custom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import Objects.Employee;

public class FileHandler {
	public void writeFile(File location, Object object) {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			mapper.writeValue(location, object);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Employee getEmployee(File location) {
		BufferedReader br = null;
		Employee employee = null;
		try {
			br = new BufferedReader(new FileReader(location.toString()));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try
		{
			employee = new Gson().fromJson(br, Employee.class);

		}
		catch (IllegalStateException | JsonSyntaxException exception)
		{
			System.out.println(exception.getMessage());
		}
		
		return employee;
	}
}

