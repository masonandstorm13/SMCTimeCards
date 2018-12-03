package Gui.WorkOrderGui;

import java.io.File;

import Custom.FileHandler;
import Gui.WorkOrderGui.SinglePart.newWorkOrderSinglePart;
import Objects.Customer;
import Objects.WorkOrderSuper;

public class workOrderRun {
	
	public static WorkOrderSuper workOrderSuper;
	public static Customer selectedCustomer;
	
	private String defaultWorkOrderDirectory;
	private String defaultCustomerDirectory;
	
	private FileHandler fileHandler = new FileHandler();
	
	public workOrderRun() {
		workOrderSuper = new WorkOrderSuper();
		defaultWorkOrderDirectory = "\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\WorkOrders\\";
		defaultCustomerDirectory = "\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\Customers\\";
	}
	
	public void runMultiPartWorkOrder() {
		
	}
	
	public void runSinglePartWorkOrder() {
		new newWorkOrderSinglePart().setVisible(true);
	}
	
	public void saveWorkOrder() {
		selectedCustomer.addWorkOrdersDirectories(workOrderSuper);
		
		if(selectedCustomer.equals("WalkIn")) {
			fileHandler.writeFile(new File(defaultCustomerDirectory + "zzz-WalkIn" + ".JSON"), selectedCustomer);
		}else {
			fileHandler.writeFile(new File(defaultCustomerDirectory + selectedCustomer.getName() + ".JSON"), selectedCustomer);
		}
		
		fileHandler.writeFile(new File(defaultWorkOrderDirectory + workOrderSuper.getWorkOrderNumber() + ".JSON") , workOrderSuper);	
	}
	
}
