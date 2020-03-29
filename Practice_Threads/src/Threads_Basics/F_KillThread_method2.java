package Threads_Basics;

public class F_KillThread_method2 {

		
	public static void function1() {
		
		while (!Thread.interrupted()) { 
			System.out.println("Thread "+ Thread.currentThread().getName()+" is running");
        	
        	//wait 1 second between the iterations
			//the interrupt cannot occur while sleeping, this will through exception.
        	/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}*/
        } 
		
	}
	
	
	public static void main(String[] args) {
		
		/*
		 	A thread is automatically destroyed when the run() method has completed. 
			But it might be required to kill/stop a thread before it has completed its life cycle. 
			Previously, methods suspend(), resume() and stop() were used to manage the execution of threads. 
			But these methods were deprecated by Java 2 because they could result in system failures. 
			
			Modern ways to suspend/stop a thread are by using a boolean flag and Thread.interrupt() method.
		 */
		
		
        /*
         * 2nd Method: Using Thread.interrupt() method: Whenever an interrupt has been sent to a thread, it should stop whatever task it is performing. 
	         * It is very likely that whenever the thread receives an interrupt, it is to be terminated. 
	         * This action can be done by using the interrupt() method. 
	         * Whenever Thread.interrput() is called, it sets a flag known as the interrupt status to true. 
	         * This means that the thread has to stop performing further execution. 
	         * The default value of this flag is false.
        */
	
        
        Thread thread1 = new Thread( 
				new Runnable() {
					public void run() {
						function1(); 
					}
				}
		);
		thread1.setName("Thread 1");
		thread1.start();
		
		try {
			Thread.sleep(2000);     //Make the main thread sleep for 2 seconds
									//In another word, let thread1 work for 2 seconds
		    
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		 * isAlive() tests if this thread is alive. 
		 * A thread is alive if it has been started and has not yet died. 
		 */
		System.out.println("Is alive? " + thread1.isAlive()); // Checks if this thread is alive
		
		
		
		thread1.interrupt();     
		
	    
		try {
			Thread.sleep(5000);     //Make the main thread sleep for 5 seconds
									//In another word, give some time for thread1 to be terminated
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Exiting thread1"); 
		
		/*
		 * isAlive() tests if this thread is alive. 
		 * A thread is alive if it has been started and has not yet died. 
		 */
		System.out.println("Is alive? " + thread1.isAlive()); // Checks if this thread is alive
		
		
	    
        //continue the work of the main thread
        
        System.out.println("Exiting the main Thread"); 
        
	}

}

