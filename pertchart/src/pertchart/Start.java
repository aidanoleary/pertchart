/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertchart;

import java.awt.*;
import javax.swing.*;

import no.geosoft.cc.geometry.Geometry;
import no.geosoft.cc.graphics.*;
/**
 *
 * @author Aidan
 */
public class Start extends JFrame{

    private GScene scene;
    private ListOfTasks taskList;
    
    public Start() {
        
        super("Pert Chart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //will need to change this **********************
        taskList = new ListOfTasks();
        
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
        
        
        //Gets the input from the user then creates the Task objects and also
        //adds them to the taskList.
        TextInput input = new TextInput();
        while(input.getFinished() == false) {
            input.inputTask();
            Task parentTask = null;
            int parentCounter = 0;
            double xPosition = 400;
            
            //Checks to see if this is the first task. If it is xPosition is 
            //set to 200.
            if(taskList.lengthOfTaskList() == 0) {
                xPosition = 200;
            }
            
            //Loops through the taskList field
            for(Task task : taskList.getTaskList()) {
                //Checks if there is a task with a task number matching the input
                //parent task number. If there is parentTask is set to that task.
                if(task.getTaskNumber() == input.getParentNum()) {
                    parentTask = task;
                }
                //Checks to see if there is already tasks with the same parent.
                //If there is the parentCounter variable is incremented.
                if(task.getParent() == parentTask) {
                    parentCounter++;
                }
            }
            
            //The yPosition is determined on how many children a parentTask has.
            //This is done using the previous parentCounter variable.
            double yPosition = 500 + parentCounter * 300;
            taskList.addTask(new Task(input.getName(), input.getTaskNum(), input.getNumOfDays(), "startDate", "endDate", scene, parentTask, xPosition, yPosition));
        }

        //Checks if more than 3 tasks have been created, if they have it changes
        //the size of the scene world extent.
        //********* this may need to be change to reflect the y axis.
        if(taskList.lengthOfTaskList() > 3) {
            double newSize = 1500 + taskList.lengthOfTaskList() * 500;
            double we0[] = {0.0, newSize, 0.0};
            double we1[] = {newSize, newSize, 0.0};
            double we2[] = {0.0, 0.0, 0.0};
            scene.setWorldExtent(we0, we1, we2);
        }
        
        pack();
        setSize (new Dimension(500, 500));
        
        /*
         * Checks if more than 3 tasks have been created, if they have it changes
         * the size of the scene world extent.
         */
        
        setVisible(true);
        
    }
}
