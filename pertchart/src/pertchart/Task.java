/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertchart;

import no.geosoft.cc.geometry.Geometry;
import no.geosoft.cc.graphics.*;
import java.util.ArrayList;
/**
 *
 * @author Aidan O'Leary
 * 
 * This is a class that will be used to represent the a graphical object of
 * a task.
 */
public class Task extends GObject{
    
    private String name;
    private int taskNumber;
    private int numberOfDays;
    private String startDate;
    private String endDate;
    private TaskList parentList;
    private double xPosition, yPosition, xSize, ySize;
    private GSegment square;
    private ArrayList <GSegment> lineList;
    
    
    
    
    /*
     * Constructors for objects of type Task
     */
    public Task() {
        
    }
    
    /*
     * The main constructor for objects of class Task
     * 
     * @param name
     * @param taskNumber
     * @param numberOfDays
     * @param startDate
     * @param endDate
     * @param scene
     * @param parent
     * @param xPosition
     * @param yPosition
     */
    public Task(String name, int taskNumber, int numberOfDays,
                String startDate, String endDate, GScene scene, TaskList parentList, double xPosition, double yPosition) {
        
        this.name = name;
        this.taskNumber = taskNumber;
        this.numberOfDays = numberOfDays;
        this.startDate = startDate;
        this.endDate = endDate;
        this.parentList = parentList;
        
        this.yPosition = yPosition;
        xSize = 200;
        ySize = 200;
        
        square = new GSegment();
        addSegment(square);
        
        lineList = new ArrayList<GSegment> ();
        
        setStyle(new GStyle());
        //maybe change this and remove the scene field. *********************
        //
        if(parentList == null) {
            scene.add(this);
            this.xPosition = xPosition;
        }
        else {
            //Create a list of lines that represent the connections between parent
            //and child tasks.
            for(int i = 0; i < parentList.lengthOfTaskList(); i++) {
                lineList.add(new GSegment());
                addSegment(lineList.get(i));
            }
            //Set the position of the task dependent on where it's first
            //parent is located.
            Task mainParent = parentList.getTask(0);
            mainParent.add(this);
            this.xPosition = mainParent.getXPosition() + xPosition;
        }

        updateText();
    }
    
    /*
     * An accessor method for the name field.
     */
    public String getName() {
        return name;
    }
    
    /*
     * An accessor method for the taskNumber field.
     */
    public int getTaskNumber() {
        return taskNumber;
    }
    
    /*
     * An accessor method for the numberOfDays field.
     */
    public int getNumberOfDays() {
        return numberOfDays;
    }
    
    /*
     * An accessor method for the startDate field.
     */
    public String getStartDate() {
        return startDate;
    }
    
    /*
     * An accessor method for the endDate field.
     */
    public String getEndDate() {
        return endDate;
    }
    
    /*
     * An accessor method for the xPosition field.
     */
    public double getXPosition() {
        return xPosition;
    }
    
    /*
     * An accessor method for the yPosition field.
     */
    public double getYPosition() {
        return yPosition;
    }
    
    public double getXSize() {
        return xSize;
    }
    
    public double getYSize() {
        return ySize;
    }
    
    /*
     * A method that updates the text displayed by the task object.
     */
    public void updateText() {
        
        GText textName = new GText(name, GPosition.TOP);
        
        Integer num;
        num = taskNumber;
        GText textTaskNum = new GText(num.toString(), GPosition.TOP);
        
        num = numberOfDays;
        GText textNumOfDays = new GText(num.toString(), GPosition.TOP);
        
        GText textStart = new GText(startDate, GPosition.TOP);
        GText textEnd = new GText(endDate, GPosition.TOP);
        
        square.addText(textName);
        square.addText(textTaskNum);
        square.addText(textNumOfDays);
        square.addText(textStart);
        square.addText(textEnd);

    }
    
    public void draw() {
        //checks if the parentList is null and then sets the geometry of each
        //line connected to it.
        if(parentList != null) {         
            for(int i =0; i < parentList.lengthOfTaskList(); i++) {
                Task currentParent = parentList.getTask(i); 
                lineList.get(i).setGeometry(currentParent.getXPosition() + 200, currentParent.getYPosition() + 100, xPosition, yPosition + 100);
            }
        }
        
        square.setGeometryXy(Geometry.createRectangle(xPosition, yPosition, xSize, ySize));
    }
}
