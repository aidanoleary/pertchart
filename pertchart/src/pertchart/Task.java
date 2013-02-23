/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertchart;

import java.util.Calendar;

/**
 *A class that is used to represent a single task 
 * @author up636800
 */
public class Task {
    /*
     * Fields containing attributes for an object of class Task.
     */
    private String name;
    private int taskNumber;
    private int parentNumber;
    private int numberOfDays;
    private Calendar startDate;
    private Calendar endDate;
    
    /*
     * Constructors for objects of the class task.
     */
    public Task() {
        
    }
    
    public Task(String name, int taskNumber, int parentNumber, int numberOfDays) {
        this.name = name;
        this.taskNumber = taskNumber;
        this.parentNumber = parentNumber;
        this.numberOfDays = numberOfDays;
        startDate = Calendar.getInstance();
        endDate = Calendar.getInstance();

    }
    
    /*
     * Accessor methods for the classes fields.
     */
    public String getName() {
        return name;
    }
    
    public int getTaskNumber() {
        return taskNumber;
    }
    
    public int getNumberOfDays() {
        return numberOfDays;
    }
    
    //Add date fields
    
    /*
     * Mutator methods for the classes fields.
     */
    public void changeName(String newName) {
        name = newName;
    }
    
    public void changeTaskNumber(int newTaskNumber) {
        taskNumber = newTaskNumber;
    }
    
    public void changeNumberOfDays(int newNumberOfDays) {
        numberOfDays = newNumberOfDays;
    }
    
    //Add date fields
    
    
    
    
    
    
    
}
