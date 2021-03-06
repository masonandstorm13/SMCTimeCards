package Gui.WorkOrderGui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Custom.FileHandler;
import Objects.Customer;
import Objects.WorkInProgress;
import Objects.WorkOrder;
import Objects.WorkOrderSuper;

public class workOrderRun {
	
	public static WorkOrderSuper workOrderSuper = null;
	public static Customer selectedCustomer = null;
	public static WorkInProgress workInProgress = null;
	public static int currentPart = 0;
	public static int totalParts = 0;
	 
	private static String defaultWorkOrderDirectory;
	private static String defaultCustomerDirectory;
	private static String workInProgressDirectory;
	
	private static FileHandler fileHandler = new FileHandler();
	static JFrame[] jFrameList = null;
	public static Boolean[] saveList = null;
	public static JFrame extraMenu;
	
	public static String mainWorkOrderDate = "";
	public static String mainWorkOrderNumber = "";
	public static String mainWorkOrderPhone = "";
	public static String mainWorkOrderFax = "";
	
	public static String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	
	public workOrderRun(int totalParts) {
		//sets up super work order
		workOrderSuper = new WorkOrderSuper();
		workOrderSuper.setCashJob(false);
		workOrderSuper.setInProgress(true);
		selectedCustomer = null;
		
		//sets up directories
		defaultWorkOrderDirectory = "\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\WorkOrders\\";
		defaultCustomerDirectory = "\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\Customers\\";
		workInProgressDirectory = "\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\WorkInProgress\\WorkInProgressList.JSON";
		
		if(!(new File("\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\WorkInProgress\\").exists())) {
			new File("\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\WorkInProgress\\").mkdirs();
			workInProgress = new WorkInProgress();
			fileHandler.writeFile(new File(workInProgressDirectory), workInProgress);
		}
		
		//sets up all other
		workInProgress = new FileHandler().getWorkInProgress(new File(workInProgressDirectory));
		currentPart = 0;
		workOrderRun.totalParts = totalParts;
				
	}
	
	public void runMultiPartWorkOrder() {
		workOrderRun.workOrderSuper.setMultiPart(true);
		setUpFrames();
	}
	
	public void runSinglePartWorkOrder() {
		workOrderRun.workOrderSuper.setMultiPart(false);
		setUpFrames();
	}
	
	public void setUpFrames() {
		//sets up frames
				jFrameList = new JFrame[totalParts+1];
				saveList = new Boolean[totalParts+1];
				extraMenu = new workOrderExtraMenu();

				//sets up all new work orders and panels
				for(int i = 0; i <= totalParts; i++) {
					WorkOrder workOrder = new WorkOrder();
					workOrder.setPart(i);
					//adds all work orders
					workOrderRun.workOrderSuper.addWorkOrder(workOrder);
					saveList[i] = false;
					//sets up and adds frames
					jFrameList[i] = new newWorkOrder(i);
					jFrameList[i].setName("New Work Order Part: " + alphabet[i]);
					jFrameList[i].setTitle("New Work Order Part: " + alphabet[i]);
					//custom closing operation for seeing if saving is needed
					jFrameList[i].addWindowListener(new WindowAdapter() {
						@Override
			            public void windowClosed(WindowEvent e)
			            {
							
							
			            }
					});
				}
				//sets the first frame to visible
		        jFrameList[0].setVisible(true);
		        
				// sets up extra menu location and set it to visible
				extraMenu.setLocation((int) jFrameList[0].getLocation().getX() + jFrameList[0].getWidth() - 10, (int) jFrameList[0].getLocation().getY());
				extraMenu.setVisible(true);
	}
	
	public static void saveWorkOrder() {
		selectedCustomer.addWorkOrdersDirectories(workOrderSuper.getWorkOrderNumber());		
		if(selectedCustomer.equals("WalkIn")) {
			fileHandler.writeFile(new File(defaultCustomerDirectory + "zzz-WalkIn" + ".JSON"), selectedCustomer);
		}else {
			fileHandler.writeFile(new File(defaultCustomerDirectory + selectedCustomer.getName() + ".JSON"), selectedCustomer);
		}
		defaultWorkOrderDirectory = defaultWorkOrderDirectory + workOrderSuper.getWorkOrderNumber() + "\\";
		if(!new File(defaultWorkOrderDirectory).exists()) {
			new File(defaultWorkOrderDirectory).mkdirs();
		}
		fileHandler.writeFile(new File(defaultWorkOrderDirectory + workOrderSuper.getWorkOrderNumber() + ".JSON") , workOrderSuper);
		new File(defaultWorkOrderDirectory + "Files").mkdirs();
		if(workOrderSuper.getInProgress() == true ) {
			//checks if work order is already in work in progress list 
			Boolean saveInProgress = true;
			for(WorkOrderSuper workOrder : workInProgress.workOrders) {
				if(workOrder.getWorkOrderNumber() == workOrderSuper.getWorkOrderNumber()) {
					saveInProgress = false;
					break;
				}
			}
			//saves the work order to work in progress
			if(saveInProgress == true) {
				workInProgress.addWorkOrder(workOrderSuper);
				fileHandler.writeFile(new File(workInProgressDirectory), workInProgress);
			}

		}
	}

	public static void nextWorkOrder() {
		Point legacyLocation;
		if(currentPart != totalParts) {
			legacyLocation = jFrameList[currentPart].getLocation();
			jFrameList[currentPart].setVisible(false);
			currentPart++;
			jFrameList[currentPart].setLocation(legacyLocation);
			jFrameList[currentPart].setVisible(true);
		}
	}
	
	public static void previousWorkOrder() {
		Point legacyLocation;
		if(currentPart != 0) {
			legacyLocation = jFrameList[currentPart].getLocation();
			jFrameList[currentPart].setVisible(false);
			currentPart--;
			jFrameList[currentPart].setLocation(legacyLocation);
			jFrameList[currentPart].setVisible(true);
		}
	}
	
	public static void upDateAllFrames() {
		for(int i = 1; i <= totalParts; i++) {
			//loop for each frame
			for(Component component : jFrameList[i].getContentPane().getComponents()) {
				if(component instanceof Container) {
					//loop for jPanel1 Container
					for(Component component1 : ((Container) component).getComponents()) {
						if(component1.getName() != null) {
							//loop for Date/WorkOrderNumber Container
							if(component1.getName().equals("Date/WorkOrderNumber")) {
								if(component1 instanceof Container) {
									for(Component componentDate_WorkOrderNumber : ((Container) component1).getComponents()) {
										//loop for Date Container
										if(componentDate_WorkOrderNumber instanceof Container) {
											if(componentDate_WorkOrderNumber.getName().equals("Date")) {
												for(Component componentDate : ((Container) componentDate_WorkOrderNumber).getComponents()) {
													//loop for Date TextField
													if(componentDate instanceof JFormattedTextField) {
														//((JFormattedTextField) componentDate).setText(mainWorkOrderDate);
													}
												}
											}
										}
										//loop for WorkOrderNumber Container
										if(componentDate_WorkOrderNumber instanceof Container) {
											if(componentDate_WorkOrderNumber.getName().equals("WorkOrderNumber")) {
												for(Component componentWorkOrderNumber : ((Container) componentDate_WorkOrderNumber).getComponents()) {
													//loop for WorkOrderNumber TextField
													if(componentWorkOrderNumber instanceof JFormattedTextField) {
														((JFormattedTextField) componentWorkOrderNumber).setText(mainWorkOrderNumber);
													}
												}
											}
										}
									}
								}
							}
							//loop for Customer Container
							if(component1.getName().equals("Customer")) {
								if(component1 instanceof Container) {
									for(Component com : ((Container) component1).getComponents()) {
										//loop for Customer TextField
										if(com instanceof JTextField && com.getName().equals("TextField_Customer")) {
											if(selectedCustomer != null) {
												((JTextField) com).setText(selectedCustomer.getName());
											}
										}
									}
								}
							}
							//loop for Phone/Fax Container
							if(component1.getName().equals("Phone/Fax")) {
								if(component1 instanceof Container) {
									for(Component componentPhone_Fax : ((Container) component1).getComponents()) {
										//loop for Phone Container
										if(componentPhone_Fax instanceof Container) {
											if(componentPhone_Fax.getName().equals("Phone")) {
												for(Component componentPhone : ((Container) componentPhone_Fax).getComponents()) {
													//loop for Phone TextField
													if(componentPhone instanceof JTextField) {
														((JTextField) componentPhone).setText(mainWorkOrderPhone);
													}
												}
											}
										}
										//loop for Fax Container
										if(componentPhone_Fax instanceof Container) {
											if(componentPhone_Fax.getName().equals("Fax")) {
												for(Component componentFax : ((Container) componentPhone_Fax).getComponents()) {
													//loop for Fax TextField
													if(componentFax instanceof JTextField) {
														((JTextField) componentFax).setText(mainWorkOrderFax);
													}
												}
											}
										}
									}
								}
							}
						}

					}
				}				
			}
			
			//updates each workOrder Value
			for(int e = 1; e <= totalParts; e++) {
				workOrderSuper.getWorkOrderList().get(e).setDate(mainWorkOrderDate);
				workOrderSuper.getWorkOrderList().get(e).setPhone(mainWorkOrderPhone);
				workOrderSuper.getWorkOrderList().get(e).setFax(mainWorkOrderFax);
				
			}	
		}
		workOrderSuper.setWorkOrderNumber(mainWorkOrderNumber);
	}

}
