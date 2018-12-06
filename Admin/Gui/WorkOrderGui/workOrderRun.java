package Gui.WorkOrderGui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFrame;

import Custom.FileHandler;
import Gui.WorkOrderGui.SinglePart.newWorkOrderSinglePart;
import Objects.Customer;
import Objects.WorkOrder;
import Objects.WorkOrderSuper;

public class workOrderRun {
	
	public static WorkOrderSuper workOrderSuper;
	public static Customer selectedCustomer;
	public static int currentPart;
	
	private String defaultWorkOrderDirectory;
	private String defaultCustomerDirectory;
	
	private FileHandler fileHandler = new FileHandler();
	
	public workOrderRun() {
		workOrderSuper = new WorkOrderSuper();
		defaultWorkOrderDirectory = "\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\WorkOrders\\";
		defaultCustomerDirectory = "\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\Customers\\";
		currentPart = 0;
	}
	
	public void runMultiPartWorkOrder(int totalParts) {
		workOrderRun.workOrderSuper.setMultiPart(true);
		
		JFrame workOrderFrame = new newWorkOrderSinglePart();
		workOrderFrame.setVisible(true);
		workOrderFrame.addWindowListener(new WindowAdapter() {
			@Override
            public void windowClosed(WindowEvent e)
            {
				if(workOrderRun.workOrderSuper.workOrderList.get(totalParts).getDescription() != null 
						&& totalParts == currentPart) {
					saveWorkOrder();
				}else if(workOrderRun.workOrderSuper.workOrderList.get(currentPart).getDescription() != null
						&& totalParts != currentPart) {
					currentPart++;
					runMultiPartWorkOrder(totalParts);
				}else {
					
				}
            }
		});
	}
	
	public void runSinglePartWorkOrder() {
		workOrderRun.workOrderSuper.setMultiPart(false);
		currentPart++;
		workOrderRun.workOrderSuper.workOrderList.add(new WorkOrder());
		JFrame workOrderFrame = new newWorkOrderSinglePart();
		workOrderFrame.setVisible(true);
		workOrderFrame.addWindowListener(new WindowAdapter() {
			@Override
            public void windowClosed(WindowEvent e)
            {
				//checks if the work order has values set before saving
				if(workOrderRun.workOrderSuper.workOrderList.get(0).getDescription() != null) {
					saveWorkOrder();
				}
            }
		});
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
