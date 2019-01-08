package Objects;

import java.util.ArrayList;
import java.util.List;

public class WorkOrderSuper {
	
	public String workOrderNumber;
	public Boolean multiPart;
	public String customer;
	public List<WorkOrder> workOrderList; 
	public List<PONumber> poNumberList;
	public List<InvoiceNumber> invoiceList;
	public List<DeliveryTicket> deliveryTicketList;
	public Boolean cashJob;
	public Boolean inProgress;
	
	
	public WorkOrderSuper() {
		this.workOrderNumber = null;
		this.multiPart = null;
		this.customer = null;
		this.workOrderList = new ArrayList<WorkOrder>();
		this.poNumberList = new ArrayList<PONumber>();
		this.invoiceList = new ArrayList<InvoiceNumber>();
		this.deliveryTicketList = new ArrayList<DeliveryTicket>();	
		this.cashJob = false;
	}
	
	public WorkOrderSuper(String workOrderNumber, Boolean multiPart, String customer, List<WorkOrder> workOrderList, List<PONumber> poNumberList, List<InvoiceNumber> invoiceList, List<DeliveryTicket> deliveryTicketList, Boolean cashJob) {
		this.workOrderNumber = workOrderNumber;
		this.multiPart = multiPart;
		this.customer = customer;
		this.workOrderList = workOrderList;
		this.poNumberList = poNumberList;
		this.invoiceList = invoiceList;
		this.deliveryTicketList = deliveryTicketList;
		this.cashJob = cashJob;
	}
	
	public String getWorkOrderNumber() {
		return this.workOrderNumber;
	}
	
	public Boolean getMultiPart() {
		return this.multiPart;
	}
	
	public String getCustomer() {
		return this.customer;
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
	
	public Boolean getCashJob() {
		return this.cashJob;
	}
	
	public Boolean getInProgress() {
		return this.inProgress;
	}
	
	public void setWorkOrderNumber(String workOrderNumber) {
		this.workOrderNumber = workOrderNumber;
	}
	
	public void setMultiPart(Boolean multiPart) {
		this.multiPart = multiPart;
	}
	
	public void setCustomer(String customer) {
		this.customer = customer;
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
	
	public void setCashJob(Boolean cashJob) {
		this.cashJob = cashJob;
	}
	
	public void setInProgress(Boolean inProgress) {
		this.inProgress = inProgress;
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
