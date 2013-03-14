/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertchart;

/**
 *
 * @author Aidan O'Leary
 * This is a class that will be used to iterate over a listOfTasks.
 */
public class Iterator {
    
    //A field containing a object of TaskList
    private TaskList listOfTasks;
    
    //A field containing the size of the listOfTasks
    private int listSize;
    
    //A field containing a integer which represents the current task number.
    private int currentTaskNum;
    
    /*
     * A constructor for objects of Iterator.
     */
    public Iterator(TaskList listOfTasks) {
        this.listOfTasks = listOfTasks;
        listSize = listOfTasks.lengthOfTaskList();
        currentTaskNum = 0;
    }
    
    /*
     * A method that retrieves the next Task and increments the
     * currentTaskNum.
     */
    public Task getNext() {
        Task currentTask = listOfTasks.getTask(currentTaskNum);
        if(currentTaskNum < listSize) {
            currentTaskNum++;
        }
        return currentTask;
    }
    
    /*
     * A method that removes the next Task and increments the currentTaskNum.
     */
    public void removeNext() {
        listOfTasks.removeTaskIndex(currentTaskNum);
        if(currentTaskNum < listSize) {
            currentTaskNum++;
        }
    }
    
    /*
     * A accessor method to return the currentTaskNum field.
     */
    public int getCurrentNum() {
        return currentTaskNum;
    } 
    
    /*
     * A accessor method to return the listSize field.
     */
    public int getListSize() {
        return listSize;
    }
    
    /*
     * A field that checks whether all elements have been iterated over.
     */
    public boolean isFinished() {
        if(currentTaskNum < listSize) {
            return false;
        }
        else {
            return true;
        }
    }
}
