package Objects;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	public String name;
	public List<WorkOrderSuper> workOrdersDirectories;
	
	public Customer() {
		this.name = "";
		this.workOrdersDirectories = new ArrayList<WorkOrderSuper>();
	}
	
	public Customer(String name, List<WorkOrderSuper> workOrdersDirectories) {
		this.name = name;
		this.workOrdersDirectories = workOrdersDirectories;

	}
	
	public String getName()
	{
	    return this.name;
	}
	
	public List<WorkOrderSuper> getWorkOrdersDirectories()
	{
	    return this.workOrdersDirectories;
	}
	
	
	public void setName(String name)
	{
	     this.name = name;
	}
	
	public void setWorkOrdersDirectories(List<WorkOrderSuper> workOrdersDirectories)
	{
	     this.workOrdersDirectories = workOrdersDirectories;
	}
	
	public void addWorkOrdersDirectories(WorkOrderSuper workOrderSuper) {
		this.workOrdersDirectories.add(workOrderSuper);
	}
	
	public void removeWorkOrdersDirectories(WorkOrderSuper workOrderSuper) {
		this.workOrdersDirectories.remove(workOrderSuper);
	}
	
}
