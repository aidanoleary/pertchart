/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertchart;

import java.util.ArrayList;

/**
 *
 * @author up636800
 * This is a class that will be used to contain an array list of Tasks.
 * 
 */
public class ListOfTasks {
    
    //This is a field the will hold an array list of Task objects.
    ArrayList<Task> taskList;
    
    /*
     * Constructors for objects of the class ListOfTasks.
     */
    public ListOfTasks() {
        taskList = new ArrayList<Task>();
    }
    
    /*
     * Accessor methods for the ListOfTasks fields.
     */
    public ArrayList<Task> getTaskList() {
        return taskList;
    }
    
    /*
     * A method that allows a task to be added to the taskList field.
     */
    public void addTask(Task newTask) {
        taskList.add(newTask);
    }
    
    /*
     * A method that allows you to remove a task.
     */
    public void removeTask(Task task) {
        taskList.remove(task);
    }
    
    /*
     * A method that allows you to remove a task using the taskList 
     * index number.
     */
    public void removeTaskIndex(int taskIndex) {
        taskList.remove(taskIndex);
    }
    
    /*
     * A method that allows you to clear the taskList.
     */
    public void clearTasks() {
        taskList.clear();
    }
    
    /*
     * A method that returns a task from the TaskList. 
     */
    public Task getTask(int taskIndex) {
        Task chosenTask = taskList.get(taskIndex);
        return chosenTask;
    }
    
    /*
     * A method that returns the number of tasks.
     */
    public int lengthOfTaskList() {
        int length = taskList.size();
        return length;
    }
}
