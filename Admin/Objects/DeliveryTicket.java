package Objects;

public class DeliveryTicket {
	
	public String deliveryTicketNumber;
	public Integer partAssociated;
	
	public DeliveryTicket() {
		this.deliveryTicketNumber = null;
		this.partAssociated = null; 
	}
	
	public DeliveryTicket(String poNumber, Integer partAssociated) {
		this.deliveryTicketNumber = poNumber;
		this.partAssociated = partAssociated;
	}
	
	public String getPoNumber(){
		return this.deliveryTicketNumber;
	}
	
	public Integer getPartAssociated() {
		return this.partAssociated;
	}
	
	public void setPoNumber(String poNumber) {
		this.deliveryTicketNumber = poNumber;
	}
	
	public void setPartAssociated(Integer partAssociated) {
		this.partAssociated = partAssociated;
	}
}
