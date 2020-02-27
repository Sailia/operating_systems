package Threads_Synchronization;

import java.util.concurrent.*;


public class C_Semaphore {

	
	//semaphore lock
	//counting semaphore with two instances, change the number of instances and track the acquire/release sequence

	public static Semaphore semaphore = new Semaphore(2);
		
	
	
	public static void function1(){
	    for(int i=0;i<5;i++) {
	    	try {
		    	
		    		System.out.println("function 1 trying to acquire the lock");
			    	
		    		semaphore.acquire();
			        
		    		System.out.println("function 1 acquired the lock");
					
		    		System.out.println("number of Locks remaining >> " +semaphore.availablePermits());

					System.out.println("function 1 Locks Released");

					semaphore.release();

					System.out.println("number of Locks remaining >> " +semaphore.availablePermits());

		   	   	} catch (Exception e) {
		    		   e.printStackTrace();
		   	   	}
	    }
	}
		
	
	
	public static void function2(){
	    for(int j=0;j<5;j++) {
	    	try {
		    	
		    		System.out.println("function 2 trying to acquire the lock");
			    	
		    		semaphore.acquire();
			        
		    		System.out.println("function 2 acquired the lock");
					
		    		System.out.println("number of Locks remaining >> " +semaphore.availablePermits());

					System.out.println("function 2 Locks Released");

					semaphore.release();

					System.out.println("number of Locks remaining >> " +semaphore.availablePermits());

		   	   	} catch (Exception e) {
		    		   e.printStackTrace();
		   	   	}
	    }
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create thread 1 to run function 1
		Thread thread1 = new Thread(new Runnable() {
		    @Override
		    public void run() {
			   function1();   
		    }
		});
				
		
		
		//create thread 2 to run function 2
		Thread thread2 = new Thread(new Runnable() {
		  @Override
		    public void run() {
		        function2();   
		    }
		});
						
				
		//ask the threads to start running
		thread1.start();
		
		thread2.start();
		
	}

}
