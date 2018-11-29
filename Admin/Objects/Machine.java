package Objects;

public class Machine {
	
	public String code;
	public String name;
	public Double cost;
	public String brand;
	public String type;
	public String serialNumber;
	public Boolean active;
	
	public Machine() {
		this.code = null;
		this.name = null;
		this.cost = null;
		this.brand = null;
		this.type = null;
		this.serialNumber = null;
		this.active = null;
	}
	
	public Machine(String code, String name, Double cost, String brand, String type, String serialNumber, Boolean active) {
		this.code = code;
		this.name = name;
		this.cost = cost;
		this.brand = brand;
		this.type = type;
		this.serialNumber = serialNumber;
		this.active = active;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Double getCost() {
		return this.cost;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getSerialNumber() {
		return this.serialNumber;
	}
	
	public Boolean getActive() {
		return this.active;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
}
