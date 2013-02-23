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
        
        GStyle style = new GStyle();
        style.setForegroundColor(new Color (0, 0, 0));
        style.setBackgroundColor(new Color (255, 255, 255));
        style.setFont(new Font("Dialog", Font.BOLD, 14));
        scene.setStyle(style);
        /*
        //CReate a graphics object
        Task task1 = new Task("task1", 1, 2);
        TaskGraphic graphic1 = new TaskGraphic(task1, scene, null, 200.0, 100.0);
        
        Task task2 = new Task("task2", 2, 3);
        TaskGraphic graphic2 = new TaskGraphic(task1, scene, graphic1, 300.0, 200.0);
        
        Task task3 = new Task("task3", 3, 4);
        TaskGraphic graphic3 = new TaskGraphic(task3, scene, graphic2, 600.0, 200.0);
        
        Task task4 = new Task("task4", 3, 4);
        TaskGraphic graphic4 = new TaskGraphic(task4, scene, graphic3, 800.0, 300.0);
        
        Task task5 = new Task("task5", 3, 4);
        TaskGraphic graphic5 = new TaskGraphic(task5, scene, graphic4, 1000.0, 400.0);
        
        Task task6 = new Task("task6", 3, 4);
        TaskGraphic graphic6 = new TaskGraphic(task6, scene, graphic5, 1200.0, 200.0);
        
        Task task7 = new Task("task7", 3, 4);
        TaskGraphic graphic7 = new TaskGraphic(task7, scene, graphic6, 1300.0, 500.0);
        */
        
        TextInput input = new TextInput();
        
        /*
        while(input.getFinished() == false) {
            input.inputTask();
            taskList.addTask(new Task(input.getName(),input.getTaskNum(),input.getParentNum(),input.getNumOfDays()));
        }
        */
        
        /*
        for(int i = 0; i < taskList.lengthOfTaskList(); i++) {
            Task currentTask = taskList.getTask(i);
            new TaskGraphic(currentTask, scene, null, )
        }
        */      
        pack();
        setSize (new Dimension(500, 500));
        setVisible(true);
        
    }
}
