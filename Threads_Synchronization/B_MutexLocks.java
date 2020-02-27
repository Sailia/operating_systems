package Threads_Synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class B_MutexLocks {

	//shared Mutex lock	
	//The ReentrantLock implements the Lock interface to provide synchronization for accessing shared resources. 
	//Give the lock to the current working thread and blocks all other threads which are trying to take a lock.
	//The name "ReentrantLock" allow threads to enter into lock on a resource more than once. 
	public static Lock lock = new ReentrantLock();

	
	//shared Integer counter
	public static int count = 0;

	
	//we define the lock and count as static, as we need one/single copy to be shared
		
	
	public static void function1(){
	    for(int i=0;i<5;i++) {
	    	try {
		    	
		    		System.out.println("function 1 trying to acquire the lock");
					
		    		lock.lock();    //acquire the lock
			    	
					System.out.println("function 1 acquired the lock");
					 
						//----------------------------------start of critical section
					   
						count++;
						
						System.out.println("function 1 updated the count to "+ count);
						
						//----------------------------------end of critical section
					
					System.out.println("function 1 released the lock");

					lock.unlock();

					Thread.sleep(1000);

		   	   	} catch (Exception e) {
		    		   e.printStackTrace();
		   	   	}
	    }
	}
		
	
	
	public static void function2(){
	    for(int j=0;j<5;j++) {
	    	try {
		    	
		    		System.out.println("function 2 trying to acquire the lock");
					
		    		lock.lock();    //acquire the lock
			    	
					System.out.println("function 2 acquired the lock");
					 
						//----------------------------------start of critical section
					   
						count++;
						
						System.out.println("function 2 updated the count to "+ count);
						
						//----------------------------------end of critical section
			    	   
					System.out.println("function 2 released the lock");

					lock.unlock();
					
					Thread.sleep(1000);

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
