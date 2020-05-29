package rrScheduler;
import java.io.File;
import java.util.Scanner;
public class MainEngine extends Process	{
	
	
	public static void Scheduler(Process[] array, int quantum) {
		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(array[i].getArrivalTime() == array[j].getArrivalTime()) {
					if(array[i].getID() > array[j].getID()) {
						System.out.println(array[j].toString());
					}
				} else if (array[i].getArrivalTime() < array[j].getArrivalTime()) {
					System.out.println(array[i].toString());
				} else if (array[i].getID() < array[j].getID()) {
					System.out.println(array[i].toString());
				}
			}
		}
	}
	
	public static void Initializer() {
		Scanner processFile;
		
		try {
			processFile = new Scanner(new File("Processes.txt"));
		} catch(Exception e) {
			System.out.println("Could not find file");
		}
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
