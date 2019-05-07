package Objects;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.Period;

public class SubTimeCard {
	
	/*
	 * for machine code
	 * Master Clocking Function 001
	 * Lunch 002
	 * Personal Leave 003
	 * 
	 */
	//Time format MM.dd.yyy.hh.mm.ss.SSSS
	
	public String startTime;
	public String stopTime;
	public Period totalTime;
	public String workOrderNumber;
	public Integer part;
	public List<String> machineCode;
	
	public SubTimeCard() {
		this.startTime = null;
		this.stopTime = null;
		this.totalTime = null;
		this.workOrderNumber = null;
		this.part = null;
		this.machineCode = new ArrayList<String>();
	}
	
	public SubTimeCard(String startTime, String stopTime, Period totalTime, String workOrderNumber, Integer part, List<String> machineCode) {
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.totalTime = totalTime;
		this.workOrderNumber = workOrderNumber;
		this.part = part;
		this.machineCode = machineCode;
	}
	
	public String getStartTime() {
		return this.startTime;
	}
	
	public String getStopTime() {
		return this.stopTime;
	}
	
	public Period getTotalTime() {
		return this.totalTime;
	}
	
	public String getWorkOrderNumber() {
		return this.workOrderNumber;
	}
	
	public Integer getPart() {
		return this.part;
	}
	
	public List<String> getMachineCode() {
		return this.machineCode;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	
	public void setTotalTime(Period totalTime) {
		this.totalTime = totalTime;
	}
	
	public void setWorkOrderNumber(String workOrderNumber) {
		this.workOrderNumber = workOrderNumber;
	}
	
	public void setPart(Integer part) {
		this.part = part;
	}
	
	public void setMachineCode(List<String> machineCode) {
		this.machineCode = machineCode;
	}
	
	public void addMachineCode(String machineCode) {
		this.machineCode.add(machineCode);
	}
	
	public void removeMachineCode(String machineCode) {
		this.machineCode.remove(machineCode);
	}
}
