package Objects;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.MutablePeriod;

public class TimeCard {
	//master Date format MM.dd.yyyy
	public String masterDate;
	public Employee employee;
	public MutablePeriod totalTime;
	public List<SubTimeCard> subTimeCardList;
	
	public TimeCard() {
		this.masterDate = null;
		this.employee = null;
		this.totalTime = null;
		this.subTimeCardList = new ArrayList<SubTimeCard>();
	}
	
	public TimeCard(String masterDate, Employee employee,MutablePeriod totalTime, List<SubTimeCard> subTimeCardList) {
		this.masterDate = masterDate;
		this.employee = employee;
		this.totalTime = totalTime;
		this.subTimeCardList = subTimeCardList;
	}
	
	public String getMasterDate() {
		return this.masterDate;
	}
	
	public Employee getEmployee() {
		return this.employee;
	}
	
	public MutablePeriod totalTime() {
		return this.totalTime;
	}
	
	public List<SubTimeCard> getSubTimeCardList() {
		return this.subTimeCardList;
	}
	
	public void setMasterDate(String masterDate) {
		this.masterDate = masterDate;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void setTotalTime(MutablePeriod totalTime) {
		this.totalTime = totalTime;
	}
	
	public void setSubTimeCardList(List<SubTimeCard> subTimeCardList) {
		this.subTimeCardList = subTimeCardList;
	}
	
	public void addSubTimeCardList(SubTimeCard subTimeCard) {
		this.subTimeCardList.add(subTimeCard);
	}
	
	public void removeSubTimeCardList(SubTimeCard subTimeCard) {
		this.subTimeCardList.remove(subTimeCard);
	}
	
	public void calculateMasterTime() {
		for(SubTimeCard timeCard : subTimeCardList) {
			if(!totalTime.equals(null)) {
				totalTime.mergePeriod(timeCard.totalTime);
			}else {
				totalTime = timeCard.totalTime.toMutablePeriod();
			}
		}
	}
	
}
