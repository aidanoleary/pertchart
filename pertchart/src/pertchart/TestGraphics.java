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
import no.geosoft.cc.graphics.GScene;
import no.geosoft.cc.graphics.GStyle;
import no.geosoft.cc.graphics.GWindow;

/**
 *
 * @author Aidan
 */
public class TestGraphics extends JFrame {
    private GScene scene;
    private ListOfTasks taskList;
    
    public TestGraphics() {
        
        super("Pert Chart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
        

        TextInput input = new TextInput();
        while(input.getFinished() == false) {
            input.inputTaskNum();
            input.inputParentNum();
            input.inputFinished();
            Task parentTask = null;
            int parentCounter = 0;
            double xPosition = 200;
            for(Task task : taskList.getTaskList()) {
                if(task.getTaskNumber() == input.getParentNum()) {
                    parentTask = task;
                    xPosition = xPosition + parentTask.getXPosition() + 200;
                }
                if(task.getParent() == parentTask) {
                    parentCounter++;
                }
            }
            double yPosition = 500 + parentCounter * 300;
            taskList.addTask(new Task("name", input.getTaskNum(), 2, "startDate", "endDate", scene, parentTask, xPosition, yPosition));
        }
        
        /*
        Task task1 = new Task("task1", 1, 2, "startDate", "endDate", scene, null, 200, 500);
        Task task2 = new Task("task2", 2, 2, "startDate", "endDate", scene, task1, 600, 500);
        Task task3 = new Task("task3", 3, 2, "startDate", "endDate", scene, task2, 1000, 500);
        Task task4 = new Task("task4", 4, 2, "startDate", "endDate", scene, task2, 1200, 500);
        */
        pack();
        setSize (new Dimension(500, 500));
        
        
        setVisible(true);
        
    }
}
