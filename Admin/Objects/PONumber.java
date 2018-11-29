package Objects;

public class PONumber {
	
	public String poNumber;
	public Integer partAssociated ;
	
	public PONumber() {
		this.poNumber = null;
		this.partAssociated = null; 
	}
	
	public PONumber(String poNumber, Integer partAssociated) {
		this.poNumber = poNumber;
		this.partAssociated = partAssociated;
	}
	
	public String getPoNumber(){
		return this.poNumber;
	}
	
	public Integer getPartAssociated() {
		return this.partAssociated;
	}
	
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	
	public void setPartAssociated(Integer partAssociated) {
		this.partAssociated = partAssociated;
	}
}

