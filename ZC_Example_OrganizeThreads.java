package Threads_Basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZC_Example_OrganizeThreads {
	
	//we divide myList into two lists
	//we need to count the "key" in each half
	//we also need to calculate the average value of each half
	
	public static List<Integer> myList;      //the full list
	public static List<Integer> firstHalf;   //the first half of myList
	public static List<Integer> secondHalf;  //the second half of myList
	
	public int key    = 40;    //the search key
	
	
	//statistics for the first part
	public int Count1 = 0;
	public int Average1 = 0;
	
	//statistics for the second part
	public int Count2 = 0;
	public int Average2 = 0;
	
	
	

	public static void ProcessFirstHalf() {
		
		//Count the occurrence of "key" in the firstHalf, and update Count1
		//Calculate the average value of values stored in firstHalf, and update Average1

		
	} 
	
	
	
	public static void ProcessSecondHalf() {
		
		//Count the occurrence of "key" in the secondHalf, and update Count2
		//Calculate the average value of values stored in secondHalf, and update Average2

		
	} 
	
	
	public static void main(String[] args) {

	
		//Prepare the full list with random values, and split them into two parts
		myList = new ArrayList<Integer>(); 
		for(int i=0;i<1000000;i++)
			myList.add(new Random().nextInt(1000));
		
		firstHalf = new ArrayList<>(myList.subList(0, (myList.size()) / 2)); 
		secondHalf = new ArrayList<>(myList.subList((myList.size()) / 2, myList.size())); 
  
		
		
		
		
		
		///==================================================================================================//
		///======================================Add your code below as detailed ============================//
		///==================================================================================================//
		
        //create thread1 and execute ProcessFirstHalf()
        
        
        //create thread2 and execute ProcessSecondHalf()
        
        
		
        //start thread1 and thread2
        
        
        
        //The main thread waits for the finish of the two threads
        	//Print the two counts, and Print the overall count
        	//Print the two averages, and Print the overall average
        
		
	}

}
