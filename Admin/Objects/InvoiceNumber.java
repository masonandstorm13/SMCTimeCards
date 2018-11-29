package Objects;

import org.joda.time.DateTime;

public class InvoiceNumber {
	
	public String invoiceNumber;
	public Integer partAssociated;
	public DateTime date;
	
	public InvoiceNumber() {
		this.invoiceNumber = null;
		this.partAssociated = null;
		this.date = null;
	}
	
	public InvoiceNumber(String poNumber, Integer partAssociated, DateTime date) {
		this.invoiceNumber = poNumber;
		this.partAssociated = partAssociated;
		this.date = date;
	}
	
	public String getPoNumber(){
		return this.invoiceNumber;
	}
	
	public Integer getPartAssociated() {
		return this.partAssociated;
	}
	
	public DateTime getDate() {
		return this.date;
	}
	
	public void setPoNumber(String poNumber) {
		this.invoiceNumber = poNumber;
	}
	
	public void setPartAssociated(Integer partAssociated) {
		this.partAssociated = partAssociated;
	}
	
	public void setDate(DateTime date) {
		this.date = date;
	}
}
