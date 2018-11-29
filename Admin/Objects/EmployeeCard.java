package Objects;

public class EmployeeCard {

	public String cardValue;
	public String employeePath;
	
	public EmployeeCard() {
		this.cardValue = null;
		this.employeePath = null;
	}
	
	public EmployeeCard(String cardValue, String employeePath) {
		this.cardValue = cardValue;
		this.employeePath = employeePath;
	}
	
	public String getCardValue() {
		return this.cardValue;
	}
	
	public void setCardValue(String cardValue) {
		this.cardValue = cardValue;
	}
	
	public String getEmployeePath() {
		return this.employeePath;
	}
	
	public void setEmployeePath(String employeePath) {
		this.employeePath = employeePath;
	}
}
