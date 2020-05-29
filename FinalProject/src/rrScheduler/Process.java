package rrScheduler;

public class Process {
	public static int id = 0;
	public int arrivalTime, executionTime;
	
	public Process() {
		id++;
		arrivalTime = 0;
		executionTime = 0;
	}
	
	public Process(int iD, int aT, int eT) {
		id = iD;
		arrivalTime = aT;
		executionTime = eT;
	}
	
	public int getID() {
		return id;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public int getExecutionTime() {
		return executionTime;
	}
	
	public void setID(int iD) {
		id = iD;
	}
	
	public void setArrivalTime(int aT) {
		arrivalTime = aT;
	}
	
	public void setExecutionTime(int eT) {
		executionTime = eT;
	}
	
	@Override
	
	public String toString() {
		return "id: " + id + " arrival time: " + arrivalTime + " executionTime: " + executionTime;
	}
	
	
	
	
	
	
	
	
	
}
