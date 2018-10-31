package Objects;

import java.util.List;

public class Cards {
	
	public List<EmployeeCard> EmployeeCard;
	
	public Cards() {
		this.EmployeeCard = null;
	}
	
	public Cards(List<EmployeeCard> EmployeeCard) {
		this.EmployeeCard = EmployeeCard;
	}
	
	public List<EmployeeCard> getEmployeeCard() {
		return this.EmployeeCard;
	}
	
	public void addEmployeeCard(EmployeeCard EmployeeCard) {
		this.EmployeeCard.add(EmployeeCard);
	}

}
