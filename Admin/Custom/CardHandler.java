package Custom;

import java.io.File;
import java.util.List;

import Objects.Cards;
import Objects.Employee;
import Objects.EmployeeCard;

public class CardHandler {
	
	//sets up the default directory
	public final File cardDirectory = new File("\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\Cards\\Cards.JSON");
	
	public Employee getEmployeeFromCardVlaue(String cardValue) {
		//sets up all the handlers
		FileHandler fileHandler = new FileHandler();
		Cards cardList = fileHandler.getCards(cardDirectory);
		List<EmployeeCard> employeeCardList = cardList.getEmployeeCard();
		
		//looks in list to find card value in employee list
		Employee returnEmployee = null;
		for(int i = 0; i < employeeCardList.size(); i++) {
			if(employeeCardList.get(i).cardValue.equals(cardValue)) {
				returnEmployee = fileHandler.getEmployee(new File(employeeCardList.get(i).employeePath));
			}
		}
		
		return returnEmployee;
		
	}
	
}
