package Objects;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	public String name;
	public List<String> workOrdersDirectories;
	
	public Customer() {
		this.name = "";
		this.workOrdersDirectories = new ArrayList<String>();
	}
	
	public Customer(String name, List<String> workOrdersDirectories) {
		this.name = name;
		this.workOrdersDirectories = workOrdersDirectories;

	}
	
	public String getName()
	{
	    return this.name;
	}
	
	public List<String> getWorkOrdersDirectories()
	{
	    return this.workOrdersDirectories;
	}
	
	
	public void setName(String name)
	{
	     this.name = name;
	}
	
	public void setWorkOrdersDirectories(List<String> workOrdersDirectories)
	{
	     this.workOrdersDirectories = workOrdersDirectories;
	}
	
	public void addWorkOrdersDirectories(String workOrderSuper) {
		this.workOrdersDirectories.add(workOrderSuper);
	}
	
	public void removeWorkOrdersDirectories(String workOrderSuper) {
		this.workOrdersDirectories.remove(workOrderSuper);
	}
	
}
