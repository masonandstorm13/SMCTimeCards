package Objects;

import java.util.ArrayList;
import java.util.List;

public class Cards {
	
	public List<EmployeeCard> EmployeeCard;
	
	public Cards() {
		this.EmployeeCard = new ArrayList<EmployeeCard>();
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
