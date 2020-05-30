

public class Engine {
	public static void SJF_Scheduler(Process[] inputList) {
		// add your code here ...
		// print the sorted list of processes by ID here ...
		Process[] sJF = new Process[inputList.length];
		

		for(int i = 0; i < inputList.length; i++) {
			for(int j = 0; j < inputList.length; j++) {
				if(inputList[i].executionTime < inputList[j].executionTime ) {
					if(inputList[i].arrivalTime < inputList[j].arrivalTime) {
						sJF[i] = inputList[j];
					} else {
						sJF[i] = inputList[j];
					}
				}
			}
			System.out.println("P" + getID(sJF[i].ID));
		}	
	}
	public static int getID(int id) {
		return id;
	}
	

	public static void main(String[] args) {
		Process [] ReadyProcesses = new Process[4];

		
		//add 4 processes to the ready process
		ReadyProcesses[0] = new Process(0, 5, 0);
		ReadyProcesses[1] = new Process(1, 3, 0);
		ReadyProcesses[2] = new Process(2, 8, 0);
		ReadyProcesses[3] = new Process(3, 6, 0);
		
		SJF_Scheduler(ReadyProcesses); // call your method
		//your method should print the order of: P1, P0, P3, P2
	}
}