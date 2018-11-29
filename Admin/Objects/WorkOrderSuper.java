package Objects;

import java.util.ArrayList;
import java.util.List;

public class WorkOrderSuper {
	
	public Boolean multiPart;
	public List<WorkOrder> workOrderList; 
	public List<PONumber> poNumberList;
	public List<InvoiceNumber> invoiceList;
	public List<DeliveryTicket> deliveryTicketList;
	
	public WorkOrderSuper() {
		this.multiPart = null;
		this.workOrderList = new ArrayList<WorkOrder>();
		this.poNumberList = new ArrayList<PONumber>();
		this.invoiceList = new ArrayList<InvoiceNumber>();
		this.deliveryTicketList = new ArrayList<DeliveryTicket>();		
	}
	
	public WorkOrderSuper(Boolean multiPart, List<WorkOrder> workOrderList, List<PONumber> poNumberList, List<InvoiceNumber> invoiceList, List<DeliveryTicket> deliveryTicketList) {
		this.multiPart = multiPart;
		this.workOrderList = workOrderList;
		this.poNumberList = poNumberList;
		this.invoiceList = invoiceList;
		this.deliveryTicketList = deliveryTicketList;
	}
	
	public Boolean getMultiPart() {
		return this.multiPart;
	}
	
	public List<WorkOrder> getWorkOrderList(){
		return this.workOrderList;
	}
	
	public List<PONumber> getPoNumberList(){
		return this.poNumberList;
	}
	
	public List<InvoiceNumber> getInvoiceNumberList(){
		return this.invoiceList;
	}
	
	public List<DeliveryTicket> getDeliveryTicketList(){
		return this.deliveryTicketList;
	}
	
	public void setMultiPart(Boolean multiPart) {
		this.multiPart = multiPart;
	}
	
	public void setWorkOrderList(List<WorkOrder> workOrderList) {
		this.workOrderList = workOrderList;
	}
	
	public void setPoNumberList(List<PONumber> poNumberList) {
		this.poNumberList = poNumberList;
	}
	
	public void setInvoiceNumberList(List<InvoiceNumber> invoiceList) {
		this.invoiceList = invoiceList;
	}
	
	public void setDeliveryTicketList(List<DeliveryTicket> deliveryTicketList) {
		this.deliveryTicketList = deliveryTicketList;
	}
	
	public void addWorkOrder(WorkOrder workOrder) {
		this.workOrderList.add(workOrder);
	}
	
	public void addPoNumber(PONumber poNumber) {
		this.poNumberList.add(poNumber);
	}
	
	public void addInvoiceNumber(InvoiceNumber invoiceNumber) {
		this.invoiceList.add(invoiceNumber);
	}
	
	public void addDeliveryTicket(DeliveryTicket deliveryTicket) {
		this.deliveryTicketList.add(deliveryTicket);
	}
	
	public void removeWorkOrder(WorkOrder workOrder) {
		this.workOrderList.remove(workOrder);
	}
	
	public void removePoNumber(PONumber poNumber) {
		this.poNumberList.remove(poNumber);
	}
	
	public void removeInvoiceNumber(InvoiceNumber invoiceNumber) {
		this.invoiceList.remove(invoiceNumber);
	}
	
	public void removeDeliveryTicket(DeliveryTicket deliveryTicket) {
		this.deliveryTicketList.remove(deliveryTicket);
	}
	
	
	
	
	
}
