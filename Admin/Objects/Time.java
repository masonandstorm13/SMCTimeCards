package Objects;

import org.joda.time.DateTime;
import org.joda.time.Period;

public class Time {

	public Employee employee;
	public Machine machine;
	public DateTime startTime;
	public DateTime stopTime;
	public Period totalTime;
	public Boolean rush;
	public Boolean overTime;
	public Double totalTimeCost;
	
	public Time() {
		
		this.employee = null;
		this.machine = null;
		this.startTime = null;
		this.stopTime = null;
		this.totalTime = null;
		this.rush = null;
		this.overTime = null;
		this.totalTimeCost = null;
	}
	
	public Time(Employee employee, Machine machine, DateTime startTime, DateTime stopTime, Period totalTime, Boolean rush, Boolean overTime, Double totalTimeCost) {
		this.employee = employee;
		this.machine = machine;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.totalTime = totalTime;
		this.rush = rush;
		this.overTime = overTime;
		this.totalTimeCost = totalTimeCost;
	}
	
	public Employee getEmployee() {
		return this.employee;
	}
	
	public Machine getMachine() {
		return this.machine;
	}
	
	public DateTime getStartTime() {
		return this.startTime;
	}
	
	public DateTime getStopTime() {
		return this.stopTime;
	}
	
	public Period getTotalTime() {
		return this.totalTime;
	}
	
	public Boolean getRush() {
		return this.rush;
	}
	
	public Boolean getOverTime() {
		return this.overTime;
	}
	
	public Double getTotalTimeCost() {
		return this.totalTimeCost;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	
	public void setStarTime(DateTime startTime) {
		this.startTime = startTime;
	}
	
	public void setStopTime(DateTime stopTime) {
		this.stopTime = stopTime;
	}
	
	public void setTotalTime(Period totalTime) {
		this.totalTime = totalTime;
	}
	
	public void setRush(Boolean rush) {
		this.rush = rush;
	}
	
	public void setOverTime(Boolean overTime) {
		this.overTime = overTime;
	}
	
	public void setTotalTimeCost(Double totalTimeCost) {
		this.totalTimeCost = totalTimeCost;
	}
}
