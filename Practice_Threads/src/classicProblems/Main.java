package classicProblems;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

import classicProblems.Main.Chopstick;

public class Main {
	static int philosopher = 5; // we have 5 philosophers
	static DiningPhilosophers philosophers[] = new DiningPhilosophers[philosopher]; // these philosophers are at the dining table
	static Chopstick chopsticks[] = new Chopstick[philosopher]; // one chopstick one side of each philosopher
	
	static class Chopstick { // create class to check status of chopstick
		public Semaphore mutex = new Semaphore(1);
		
		void grab() { // create critical section of taken chopstick
			try {
				mutex.acquire();
			} catch(Throwable e) {
				e.printStackTrace(System.out); // check other ways of printing
			}
		}
		
		void release() { // release lock after chopstick process is complete
			mutex.release();
		}
		
		boolean isFree() { // checks if there is at least one chopstick thats free
			return mutex.availablePermits() > 0;
		}
	}
	
	static class DiningPhilosophers extends Thread {
		public int number;
		public Chopstick leftchopstick;
		public Chopstick rightchopstick;
		
		DiningPhilosophers(int num, Chopstick left, Chopstick right) {
			number = num;
			leftchopstick = left;
			rightchopstick = right;
		}
		
		public void run() {
			while(true) {
				leftchopstick.grab();
				System.out.println("Philosopher " + (number + 1) + " picks up left chopstick." );
				rightchopstick.grab();
				System.out.println("Philosopher " + (number + 1) + " picks up right chopstick." );
				leftchopstick.release();
				System.out.println("Philosopher " + (number + 1) + " puts down left chopstick." );
				rightchopstick.release();
				System.out.println("Philosopher " + (number + 1) + " puts down right chopstick." );
			}
		}
		
		void eat() {
			try {
				int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
				System.out.println("Philosopher" + (number +1) + " eats for " + sleepTime);
				Thread.sleep(sleepTime);
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
		
		public static void main(String args[]) {
			for(int i = 0; i < philosopher; i++) {
				chopsticks[i] = new Chopstick();
			}
			
			for(int i = 0; i < philosopher; i++) {
				philosophers[i] = new DiningPhilosophers(i, chopsticks[i], chopsticks[(i + 1) % philosopher]); // REVIEW
				philosophers[i].start(); // start grabbing and releasing (no pun intended)
			}
			
			while(true) {
				try {
					Thread.sleep(1000);
					
					boolean deadlock = true;
					for(Chopstick i : chopsticks) {
						if(i.isFree()) {
							deadlock = false;
							break;
						}
					}
					if (deadlock) {
						Thread.sleep(1000);
						System.out.println("Everyone eats");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
			}
			System.out.println("Exit the Program!");
			System.exit(0);
		}
	}

}
