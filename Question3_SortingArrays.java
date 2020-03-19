package Threads_Synchronization_CProblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Question3_SortingArrays {


	/*
	 * In this question use mutex lock(s) or semaphore(s) to enable process synchronization
	 * 
	 * Thread 1 and thread 2 share a single buffer (1D Array), where: 
	 * thread 1 sorts the items of the buffer in ascending order 
	 * thread 2 sorts the items of the buffer in descending order 
	 *  
	 */
	
	
	// shared resources between thread 1 and thread 2 are:
	// DONOT CHANGE THESE VARIABLE
	public static int BufferSize = 10; 					//the size of the buffer
	public static int buffer[] = new int[BufferSize];	//the shared buffer
	
	
	// add any further resources you think Ascending() and Descending()functions must share below
	

	static Semaphore sem = new Semaphore(1);
	public static int count = 0;
	public static int temp = buffer[count];
	

	//--------------------------------------------end of shared resources section
	
	
	
	// this function simply displays the content of the shared buffer and which thread made the call
	// DONOT CHANGE THIS FUNCTION
	public static void displayStatus() {
		
		if(Thread.currentThread().getName().equals("ascending"))
			System.out.println("Ascending successfully sorted the array");
		else
			System.out.println("Descending successfully sorted the array");
	
		System.out.print(" the " + Thread.currentThread().getName() +" is displaying the content of the buffer: ");
		for(int i=0;i<BufferSize;i++) {
			System.out.print(buffer[i]+"  ");
		}
		System.out.println();
	}
	
	
	// this function sorts the shared buffer in ascending order
	public static void Ascending(){
	    try {
	    		
	    		System.out.println("The Ascending is trying to sort the shared buffer");
					
				    
	    		// Sort the buffer in ascending order
	    		// Call displayStatus after you sort and before release the lock
	    		// Implement the Ascending functionality in the area below
    
	    		sem.acquire();
	    		Arrays.sort(buffer, 0, buffer.length);
	    		displayStatus();
	    		sem.release();
	    		
	    		
	    		
	    		
				
				
	    		
	    		

	    		//--------------------------------------------end of Ascending function
	    		
	   	} catch (Exception e) {
	   		System.out.println("Problem with the Ascending function "+e.toString());
	   	}
	}
		
	
	
	public static void Descending(){
	    try {
    			
	    	System.out.println("The Descending is trying to sort the shared buffer");
			
		    
    		// Sort the buffer in descending order
    		// Call displayStatus after you sort and before release the lock
    		// Implement the Descending functionality in the area below
	    	sem.acquire();
	    	Collections.reverse(Arrays.asList(buffer));
			displayStatus();
			sem.release();
	    		
	    		
					

	    	//--------------------------------------------end of Descending function

	   	} catch (Exception e) {
	   		System.out.println("Problem with the Descending function "+e.toString());
	   	}
	}	
	

	
	
	
	
	// this is the main function
	// DONOT CHANGE THIS SECTION
	
	public static void main(String[] args) {

		for(int i=0;i<BufferSize;i++) {
			buffer[i] = 1 + new Random().nextInt(9);  //random value between 1 and 10
		}
		
		
		//create thread 1 to run function 1
		Thread thread1 = new Thread(new Runnable() {
			@Override
				public void run() {
		    		while(true) {
			    		try {
		
			    			Ascending();            //sort in ascending order the shared buffer
							
			    			Thread.sleep(200 + (int)(Math.random() * 500));   //random delay between 200 and 500
						
			    		} catch (Exception e) {
							System.out.println("Problem with thread 1 "+e.toString());
						}
			    	}
			  	}
		});
				
		
		
		//create thread 2 to run function 2
		Thread thread2 = new Thread(new Runnable() {
		  @Override
			public void run() {
		    	while(true) {
		    		try {
		    			
		    			Descending();            //sort in ascending order the shared buffer
						
		    			Thread.sleep(200 + (int)(Math.random() * 500));   //random delay between 200 and 500
					
		    		} catch (Exception e) {
						System.out.println("Problem with thread 2 "+e.toString());
					}
		    	}
		  	}
		});                                                                                                                                                  
						
				
		//ask the threads to start running
		thread1.setName("ascending");
		thread1.start();

		thread2.setName("descending");
		thread2.start();
		
	}

}
