package Objects;

public class tempWorkOrderTimeStore {
	
	public WorkOrderSuper workOrderSuper;
	public Employee employee;
	public Integer part;
	public Time time;	
	
	public tempWorkOrderTimeStore() {
		this.workOrderSuper = null;
		this.employee = null;
		this.part = null;
		this.time = null;
	}
	
	public tempWorkOrderTimeStore(WorkOrderSuper workOrderSuper, Employee employee, Integer part, Time time) {
		this.workOrderSuper = workOrderSuper;
		this.employee = employee;
		this.part = part;
		this.time = time;
	}
	
	public void setWorkOrderSuper(WorkOrderSuper workOrderSuper) {
		this.workOrderSuper = workOrderSuper;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void setPart(Integer part) {
		this.part = part;
	}
	
	public void setTime(Time time) {
		this.time = time;
	}
	
	public WorkOrderSuper getWorkOrderSuper() {
		return this.workOrderSuper;
	}
	
	public Employee getEmployee() {
		return this.employee;
	}
	
	public Integer getPart() {
		return this.part;
	}
	
	public Time getTime() {
		return this.time;
	}
}
