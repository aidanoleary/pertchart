/*
 * This is a text input class that will be used to test the program
 * before the gui has been created.
 */
package pertchart;
import java.util.Scanner;
/**
 *
 * @author Aidan
 */
public class TextInput {
    private Scanner stringScanner;
    private Scanner intScanner;
    private Scanner boolScanner;
    
    private String name;
    private int taskNum;
    private int parentNum;
    private int numOfDays;
    private boolean finished;
    
    public TextInput() {
        stringScanner = new Scanner(System.in);
        intScanner = new Scanner(System.in);
        boolScanner = new Scanner(System.in);
        finished = false;
    }
    
    
    public void inputName() {
        name = stringScanner.nextLine();
    }
    
    public void inputTaskNum() {
        taskNum = intScanner.nextInt();
    }
    
    public void inputParentNum() {
        parentNum = intScanner.nextInt();
    }
    
    public void inputNumOfDays() {
        numOfDays = intScanner.nextInt();
    }
    
    public void inputFinished() {
        finished = boolScanner.nextBoolean();
    }
    
    
    public String getName() {
        return name;
    }
    
    public int getTaskNum() {
        return taskNum;
    }
    
    public int getParentNum() {
        return parentNum;
    }
    
    public int getNumOfDays() {
        return numOfDays;
    }
    
    public boolean getFinished() {
        return finished;
    }
    
    
    public void inputTask() {
        System.out.println("Enter the name of the task:\n");
        inputName();
        System.out.println("Enter the number of the task:\n");
        inputTaskNum();
        System.out.println("Enter the parent of the task, or 0 if it doesn't have one:\n");
        inputParentNum();
        System.out.println("Enter the number of days to complete the task:\n");
        inputNumOfDays();
        System.out.println("Have You finished? Enter true or false:\n");
    }
}
