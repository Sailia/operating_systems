/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osfinal;

/**
 *
 * @author Bob
 */
public class Process{
    public static int ID;
    private int arrivalTime;
    private int executionTime;
    
    public Process()
    {
        ID++;
        arrivalTime = 0;
        executionTime = 0;
    }
    public Process(int ID, int aTime, int eTime)
    {
        this.ID = ID;
        arrivalTime = aTime;
        executionTime = eTime;
    } 
    //Get Methods
    public int getID()
    {
        return ID;
    }
    public int getArrivalTime()
    {
        return arrivalTime;
    }
    public int getExecutionTime()
    {
        return executionTime;
    }
    //Set Methods
    public void setID(int ID)
    {
        this.ID = ID;
    }
    public void setArrivalTime(int aTime)
    {
        arrivalTime = aTime;
    }
    public void setExecutionTime(int eTime)
    {
        executionTime = eTime;
    }
    
    public String toString()
    {
        return ID + " " + arrivalTime + " " + executionTime;
    }
            
}
