package Threads_Basics;

public class A_MainThread {
	
	public static void main(String[] args) { //one function thread only
		
		System.out.println("Set/Get information about the Main Thread.....");
		
		/*
		 * When a Java program starts up, one thread begins running immediately. 
		 * This is usually called the main thread of our program
		 * , it is the one that is executed when our program begins.
		 */
		
		// We can, at any time, print the name of the running thread (which is the main thread in this sketch)
		System.out.println(Thread.currentThread().getName()); 
        
        // We can, at any time, print the priority of the running thread (which is the main thread in this sketch)
		/*
		 * The priority for a thread is in range of 1 (min) to 10 (max), the default priority is 5
		 * Thread with highest priority will get execution chance prior to other threads. 
		 * Default priority for all other threads depends on the priority of parent thread, and the priority of the thread can be changed at anytime. 
		 */
        
		System.out.println("Main thread priority : " + Thread.currentThread().getPriority()); 

        
		//To access the current thread (e.g., to change the priority or name), you need to call Thread.currentThread()
        Thread.currentThread().setName("Our Main Thread");
        Thread.currentThread().setPriority(10); 
        System.out.println("Main thread Name : "     + Thread.currentThread().getName()); 
		System.out.println("Main thread priority : " + Thread.currentThread().getPriority()); 
		
	    System.out.println("Exiting the main Thread"); 
	    
	}

}
