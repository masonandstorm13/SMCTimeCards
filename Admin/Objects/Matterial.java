package Objects;

public class Matterial {
	
	public String description;
	public Double cost;
	public Double charge;
	public Integer part;
	
	public Matterial() {
		
		this.description = null;
		this.cost = null;
		this.charge = null;
		this.part = null;
	
	}
	
	public Matterial(String description, Double cost, Double charge, Integer part) {
		this.description = description;
		this.cost = cost;
		this.charge = charge;
		this.part = part;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Double getCost() {
		return this.cost;
	}
	
	public Double getCharge() {
		return this.charge;
	}
	
	public Integer getPart() {
		return this.part;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	public void setCharge(Double charge) {
		this.charge = charge;
	}
	
	public void setPart(Integer part) {
		this.part = part;
	}
}

