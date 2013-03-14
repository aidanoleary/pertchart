/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertchart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import no.geosoft.cc.graphics.GScene;
import no.geosoft.cc.graphics.GStyle;
import no.geosoft.cc.graphics.GWindow;

/**
 *
 * @author Aidan
 */
public class TestGraphics extends JFrame {
    private GScene scene;
    private TaskList taskList;
    
    public TestGraphics() {
        
        super("Pert Chart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        taskList = new TaskList(); 
        
        //Create the gui window
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        getContentPane().add(mainPanel);
        
        JPanel graphicsPanel = new JPanel();
        
        //Create the graphics canvas
        GWindow window = new GWindow();
        mainPanel.add(window.getCanvas(), BorderLayout.CENTER);
        
        //Create scene
        scene = new GScene(window, "scene");
        
        double w0[] = {0.0, 1500.0, 0.0};
        double w1[] = {1500.0, 1500.0, 0.0};
        double w2[] = {0.0, 0.0, 0.0};
        scene.setWorldExtent(w0, w1, w2);
        scene.shouldZoomOnResize(false);
        
        
        GStyle style = new GStyle();
        style.setForegroundColor(Color.BLUE);
        style.setBackgroundColor(new Color (255, 255, 255));
        style.setFont(new Font("Dialog", Font.BOLD, 10));
        scene.setStyle(style);
        
        /*
        TextInput input = new TextInput();
        
        while(input.getFinished() == false) {
            input.inputTaskNum();
            input.inputParentNum();
            input.inputFinished();
            Task parentTask = null;
            int parentCounter = 0;
            double xPosition = 300;
            
            
            //Checks if this is the first task. If it is it's xCoordinates
            //get set a position of 200 rather than 500.
            /*
            if(taskList.lengthOfTaskList() == 0) {
                xPosition = 200;
            }

                
            for(Task task : taskList.getTaskList()) {
                if(task.getTaskNumber() == input.getParentNum()) {
                    parentTask = task;
                    //xPosition = xPosition + parentTask.getXPosition() + 200;
                }
                if(task.getParent() == parentTask) {
                    parentCounter++;
                }
            }
            double yPosition = 500 + parentCounter * 300;
            taskList.addTask(new Task("name", input.getTaskNum(), 2, "startDate", "endDate", scene, parentTask, xPosition, yPosition));
        }
        */
        
        /*
        Task task1 = new Task("task1", 1, 2, "startDate", "endDate", scene, null, 200, 500);
        Task task2 = new Task("task2", 2, 2, "startDate", "endDate", scene, task1, 200, 500);
        Task task3 = new Task("task3", 3, 2, "startDate", "endDate", scene, task2, 200, 500);
        Task task4 = new Task("task4", 4, 2, "startDate", "endDate", scene, task2, 200, 500);
       
       */
        TextInput input = new TextInput();
        while(input.getFinished() == false) {
            double xPosition = 300;
            int parentCounter = 0;
            
            input.inputTaskNum();
            
            //An array is created to store the numbers of parent tasks of a task.
            int[] parentNums = new int[10];
                input.inputParentNum();
                int numArrayCounter = 0;
                while(input.getParentNum() != 0) {
                    parentNums[numArrayCounter] = input.getParentNum();
                    input.inputParentNum();
                    numArrayCounter++;
                }
                
                //Get the list of the tasks parents
                TaskList parentTasks = null;
                if(numArrayCounter != 0) {
                    parentTasks = new TaskList();
                    Iterator taskIt = new Iterator(taskList);
                    while(!taskIt.isFinished()) {
                        Task currentTask = taskIt.getNext();
                        for(int i = 0; i < parentNums.length; i++) {
                            if(currentTask.getTaskNumber() == parentNums[i]) {
                                parentTasks.addTask(currentTask);
                            }
                        }
                    }
                }
                
                if(parentTasks != null) {
                    Task parent = parentTasks.getTask(numArrayCounter - 1);
                    xPosition = xPosition + parent.getXPosition() + 200;
                }
                
                //******************************************* this is where I am
                for(int i = 0; i < taskList.lengthOfTaskList(); i++) {
                    
                }
                
                
                
                
                taskList.addTask(new Task("name", input.getTaskNum(), 2, "startDate", "endDate", scene, parentTasks, xPosition, 500));
                
            
            input.inputFinished();
            
        }
        
        /*
        Task task1 = new Task("task1", 1, 2, "startDate", "endDate", scene, null, 200, 500);
        
        TaskList task2Parents = new TaskList();
        task2Parents.addTask(task1);
        
        Task task2 = new Task("task2", 2, 2, "startDate", "endDate", scene, task2Parents, 500, 500);
        
        TaskList task3Parents = new TaskList();
        task3Parents.addTask(task1);
        task3Parents.addTask(task2);
        
        Task task3 = new Task("task2", 3, 2, "startDate", "endDate", scene, task3Parents, 800, 800);
        
        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);
        
        */
        
        /*
        Iterator taskIt = new Iterator(taskList);
        while(!taskIt.isFinished()) {
            Task currentTask = taskIt.getNext();
            currentTask
        }
        */
        
        pack();
        setSize (new Dimension(500, 500));
        
        
        setVisible(true);
        
    }
}
