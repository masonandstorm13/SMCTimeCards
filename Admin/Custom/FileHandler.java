package Custom;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
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

import Objects.Customer;
import Objects.Employee;
import Objects.FirstRun;
import Objects.Machine;
import Objects.WorkInProgress;
import Objects.WorkOrder;

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
	
	
	public WorkOrder getWorkOrder(File location) {
		BufferedReader br = null;
		WorkOrder workOrder = null;
		try {
			br = new BufferedReader(new FileReader(location.toString()));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try
		{
			workOrder = new Gson().fromJson(br, WorkOrder.class);

		}
		catch (IllegalStateException | JsonSyntaxException exception)
		{
			System.out.println(exception.getMessage());
		}
		
		return workOrder;
	}
	
	
	public WorkInProgress getWorkInProgress(File location) {
		BufferedReader br = null;
		WorkInProgress workInProgress = null;
		try {
			br = new BufferedReader(new FileReader(location.toString()));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try
		{
			workInProgress = new Gson().fromJson(br, WorkInProgress.class);

		}
		catch (IllegalStateException | JsonSyntaxException exception)
		{
			System.out.println(exception.getMessage());
		}
		
		return workInProgress;
	}
	
	public Customer getCustomer(File location) {
		BufferedReader br = null;
		Customer customer = null;
		try {
			br = new BufferedReader(new FileReader(location.toString()));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try
		{
			customer = new Gson().fromJson(br, Customer.class);

		}
		catch (IllegalStateException | JsonSyntaxException exception)
		{
			System.out.println(exception.getMessage());
		}
		
		return customer;
	}
	
	public FirstRun getFirstRun(File location) {
		BufferedReader br = null;
		FirstRun firstRun = null;
		try {
			br = new BufferedReader(new FileReader(location.toString()));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try
		{
			firstRun = new Gson().fromJson(br, FirstRun.class);

		}
		catch (IllegalStateException | JsonSyntaxException exception)
		{
			System.out.println(exception.getMessage());
		}
		
		return firstRun;
	}
	
	public Machine getMachine(File location) {
		BufferedReader br = null;
		Machine machine = null;
		try {
			br = new BufferedReader(new FileReader(location.toString()));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try
		{
			machine = new Gson().fromJson(br, Machine.class);

		}
		catch (IllegalStateException | JsonSyntaxException exception)
		{
			System.out.println(exception.getMessage());
		}
		
		return machine;
	}
	
	public BufferedImage resizeImage(Image image, int width, int height) {
	    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g = bufferedImage.createGraphics();

	    // Increase quality if needed at the expense of speed
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
	    g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

	    AffineTransform scaleTransform = AffineTransform.getScaleInstance(
	            width / (double) image.getWidth(null), height / (double) image.getHeight(null));
	    g.drawImage(image, scaleTransform, null);

	    // Release resources
	    g.dispose();

	    return bufferedImage;
	}
}

