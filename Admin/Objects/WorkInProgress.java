package Objects;

import java.util.ArrayList;
import java.util.List;

public class WorkInProgress {

	public List<WorkOrderSuper> workOrders;
	
	public WorkInProgress() {
		this.workOrders = new ArrayList<WorkOrderSuper>();
	}
	
	public WorkInProgress(List<WorkOrderSuper> workOrders) {
		this.workOrders = workOrders;
	}
	
	public void setWorkOrders(List<WorkOrderSuper> workOrders) {
		this.workOrders = workOrders;
	}
	
	public List<WorkOrderSuper> getWorkOrders(){
		return workOrders;
	}
	
	public void addWorkOrder(WorkOrderSuper workOrder) {
		this.workOrders.add(workOrder);
	}
	
	public void removeWokOrder(WorkOrderSuper workOrder) {
		this.workOrders.remove(workOrder);
	}
}
