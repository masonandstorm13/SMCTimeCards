package Objects;

import java.util.ArrayList;
import java.util.List;

public class WorkOrder {
	
	public Integer part;
	public String date;
	public String phone;
	public String fax;
	public String orderedBy;
	public Boolean charge;
	public Boolean cod;
	public Boolean rush;
	public Boolean overTime;
	public String dueDate;
	public Integer qty;
	public Boolean smc;
	public Boolean motorFreight;
	public Boolean cpu;
	public Boolean ups;
	public Boolean courier;
	public String description;
	public List<Matterial> matterials;
	public List<Time> times;
	public String completeDate;
	
	public WorkOrder() {
		
		this.part = null;
		this.date = null;
		this.phone = null;
		this.fax = null;
		this.orderedBy = null;
		this.charge = null;
		this.cod = null;
		this.rush = null;
		this.overTime = null;
		this.dueDate = null;
		this.qty = null;
		this.smc = null;
		this.motorFreight = null;
		this.cpu = null;
		this.ups = null;
		this.courier = null;
		this.description = null;
		this.matterials  = new ArrayList<Matterial>();
		this.times = new ArrayList<Time>();
		this.completeDate = null;
		
	}
	
	public WorkOrder(int part, String date, String customer, String phone, String orderedBy, String fax, Boolean charge, Boolean cod, Boolean rush, 
			Boolean overTime, String dueDate, int qty, Boolean smc, Boolean motorFreight, Boolean cpu, Boolean ups, Boolean courier, String description,
			List<Matterial> matterials, List<Time> times, String completeDate) {
		
		this.part = part;
		this.date = date;
		this.phone = phone;
		this.fax = fax;
		this.orderedBy = orderedBy;
		this.charge = charge;
		this.cod = cod;
		this.rush = rush;
		this.overTime = overTime;
		this.dueDate = dueDate;
		this.qty = qty;
		this.smc = smc;
		this.motorFreight = motorFreight;
		this.cpu = cpu;
		this.ups = ups;
		this.courier = courier;
		this.description = description;
		this.matterials = matterials;
		this.times = times;
		this.completeDate = completeDate;

	}
	
	public int getPart() {
		return this.part;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getOrderedBy() {
		return this.orderedBy;
	}
	
	public String getFax() {
		return this.fax;
	}
	
	public Boolean getCharge() {
		return this.charge;
	}
	
	public Boolean getCod() {
		return this.cod;
	}
	
	public Boolean getRush() {
		return this.rush;
	}
	
	public Boolean getOverTime() {
		return this.overTime;
	}
	
	public String getDueDate() {
		return this.dueDate;
	}
	
	public int getQty() {
		return this.qty;
	}
	
	public Boolean getSmc() {
		return this.smc;
	}
	
	public Boolean getMotorFreight() {
		return this.motorFreight;
	}
	
	public Boolean getCpu() {
		return this.cpu;
	}
	
	public Boolean getUps() {
		return this.ups;
	}
	
	public Boolean getCourier() {
		return this.courier;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public List<Matterial> getMatterials(){
		return this.matterials;
	}
	
	public Matterial getMatterial(Matterial matterial) {
		return matterials.get(matterials.indexOf(matterial));
	}
	
	public List<Time> getTimes(){
		return this.times;
	}
	
	public String getCompleteDate() {
		return this.completeDate;
	}
	
	public void setPart(int part) {
		this.part = part;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setOrderedBy(String orderedBy) {
		this.orderedBy = orderedBy;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public void setCharge(Boolean charge) {
		this.charge = charge;
	}
	
	public void setCod(Boolean cod) {
		this.cod = cod;
	}
	
	public void setRush(Boolean rush) {
		this.rush = rush;
	}
	
	public void setOverTime(Boolean overTime) {
		this.overTime = overTime;
	}
	
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public void setSmc(Boolean smc) {
		this.smc = smc;
	}
	
	public void setMotorFreight(Boolean motorFreight) {
		this.motorFreight = motorFreight;
	}
	
	public void setCpu(Boolean cpu) {
		this.cpu = cpu;
	}
	
	public void setUps(Boolean ups) {
		this.ups = ups;
	}
	
	public void setCourier(Boolean courier) {
		this.courier = courier;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setMatterials(List<Matterial> matterials){
		this.matterials = matterials;
	}
	
	public void setTimes(List<Time> times){
		this.times = times;
	}
	
	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}
	
	public void addMatterial(Matterial matterial) {
		this.matterials.add(matterial);
	}
	
	public void addTime(Time time) {
		this.times.add(time);
	}
	
	public void removeMatterial(Matterial matterial) {
		this.matterials.remove(matterial);
	}
	
	public void removeTime(Time time) {
		this.times.remove(time);
	}
	
	public void replaceMatterial(Matterial oldMatterial, Matterial newMatterial) {
		this.matterials.set(this.matterials.indexOf(oldMatterial), newMatterial);
	}
}
