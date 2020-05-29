/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Bob
 */
public class MainEngine {
    
    public static int quantum;
    public static ArrayList<Process> process;
    
    public static void Scheduler(ArrayList<Process> pro, int quantum)
    {
        int arrivalTracker = 0;
        Process Temp = null;
        ArrayList<Process> workingList = new ArrayList<>();
        while(!workingList.isEmpty() || !pro.isEmpty())
        {
            for(int i = 0; i < pro.size(); i++)
                if(pro.get(i).getArrivalTime() <= arrivalTracker)
                    workingList.add(pro.remove(i));
            if(Temp != null)
            {
                workingList.add(Temp);
                Temp = null;
            }
            if(!workingList.isEmpty())
            {
                int execution = workingList.get(0).getExecutionTime()-quantum;
                workingList.get(0).setExecutionTime(execution);
                if(execution <= 0)
                {
                    arrivalTracker += quantum + execution;
                    System.out.println(workingList.get(0).getID()+ " " + (arrivalTracker - (quantum+execution)));
                    workingList.remove(0);
                }
                else
                {
                    arrivalTracker += quantum;
                    System.out.println(workingList.get(0).getID() + " " + (arrivalTracker - (quantum)));
                    Temp = workingList.remove(0);
                }
                
            }
        }
    }
    
    public static void Initializer()
    {
        File fil = new File("src/osfinal/input.txt");
        try
        {
            Scanner readFile = new Scanner(fil);
            
            /*First line of file that contains number of availabe slots needed
            in array and the quantum
            */
            String [] quantumAndProcesses = readFile.nextLine().split(", ");
            
            //Assign value to quantum and assign amount of memory needed for Process array
            quantum = Integer.parseInt(quantumAndProcesses[1]);
            process = new ArrayList<>();
            
            //Position of process array
            
            while(readFile.hasNextLine())
            {
                //Abstracting process info from input.txt file
                String [] processInfo = readFile.nextLine().split(", ");
                
                //Process Values
                int id = Integer.parseInt(processInfo[0]);
                int arrivalTime = Integer.parseInt(processInfo[1]);
                int executionTime = Integer.parseInt(processInfo[2]);
                
                //Creating process
                process.add(new Process(id, arrivalTime, executionTime));
            }
            readFile.close();
            
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("File does not exist");
        }
    }
    public static void main(String [] args)
    {
        //Creating threads
        Thread thread1 = new Thread(new Runnable(){
		    public void run() {
			   Initializer();  
		    }
		});
        
        Thread thread2 = new Thread(new Runnable(){
		    public void run() {
			   Scheduler(process, quantum);  
		    }
		});
        
        thread1.start();
       
        //Thread 2 waits until Thread 1 finishes
        try{
            thread1.join();
        }
        catch(InterruptedException ex)
        {
            System.out.println("can't join");
        }
        
        thread2.start();

    }
}
