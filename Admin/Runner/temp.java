package Runner;

import java.io.File;

import Custom.FileHandler;
import Objects.WorkInProgress;

public class temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WorkInProgress workInProgressList = new WorkInProgress();
		FileHandler handler = new FileHandler();
		handler.writeFile(new File("\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\WorkInProgress\\WorkInProgressList.JSON"), workInProgressList);
	}

}
