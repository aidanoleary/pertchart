/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertchart;

import no.geosoft.cc.geometry.Geometry;
import no.geosoft.cc.graphics.*;
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
    private Task parent;
    private double x, y;
    private GSegment square;
    private GSegment line;
    
    
    
    
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
     * @param x
     * @param y
     */
    public Task(String name, int taskNumber, int numberOfDays,
                String startDate, String endDate, GScene scene, Task parent, double x, double y) {
        
        this.name = name;
        this.taskNumber = taskNumber;
        this.numberOfDays = numberOfDays;
        this.startDate = startDate;
        this.endDate = endDate;
        this.parent = parent;
        
        this.x = x;
        this.y = y;
        
        line = new GSegment();
        addSegment(line);
        
        square = new GSegment();
        addSegment(square);
        
        setStyle(new GStyle());
        //maybe change this and remove the scene field.
        if(parent == null) {
            scene.add(this);
        }
        else {
            parent.add(this);
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
     * An accessor method for the x coordinate field.
     */
    public double getX() {
        return x;
    }
    
    /*
     * An accessor methdo for the y coordinate field.
     */
    public double getY() {
        return y;
    }
    
    /*
     * A method that updates the text displayed by the task object.
     */
    public void updateText() {
        /*
        Integer num;
        String text = name + "\n";
        
        num = taskNumber;
        text += num.toString() + "\n";
        
        num = numberOfDays;
        text += num.toString() + "\n";
        
        text += startDate + "\n";
        text += endDate + "\n";
        
        square.addText(new GText(text, GPosition.DYNAMIC));
        */
        
        GText textName = new GText(name, GPosition.FIRST);
        
        Integer num;
        num = taskNumber;
        GText textTaskNum = new GText(num.toString());
        
        num = numberOfDays;
        GText textNumOfDays = new GText(num.toString());
        
        GText textStart = new GText(startDate);
        GText textEnd = new GText(endDate);
        
        square.addText(textName);
        square.addText(textTaskNum);
        square.addText(textNumOfDays);
        square.addText(textStart);
        square.addText(textEnd);

    }
    
    public void draw() {
        if(parent != null) {
            line.setGeometry(parent.getX(), parent.getY(), x, y);
            square.setGeometryXy(Geometry.createCircle((parent.getX() + x), y, 150.0));
        }
        
        square.setGeometryXy(Geometry.createCircle(x, y, 150.0));
    }
}
