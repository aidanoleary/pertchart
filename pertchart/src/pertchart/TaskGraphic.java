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
public class TaskGraphic extends GObject{
    
    private Task task;
    private GText name;
    private GText taskNumber;
    private GText numberOfDays;
    private GText startDate;
    private GText endDate;
    private TaskGraphic parent;
    private double x, y;
    private GSegment square;
    private GSegment line;
    
    
    
    
    /*
     * Constructors for objects of type TaskGraphic
     */
    public TaskGraphic() {
        
    }
    
    public TaskGraphic(Task task, GScene scene, TaskGraphic parent, double x, double y) {
        this.task = task;
        /*
        name = new GText(task.getName(), GPosition.DYNAMIC);
        taskNumber = new GText(Integer.toString(task.getTaskNumber()), GPosition.DYNAMIC);
        numberOfDays = new GText(Integer.toString(task.getNumberOfDays()), GPosition.DYNAMIC);
        
        //This will need to be changed when I have set the dates fields up properly
        startDate = new GText("startDate", GPosition.DYNAMIC);
        endDate = new GText("endDate", GPosition.DYNAMIC);
        */
                
        this.parent = parent;
        
        this.x = x;
        this.y = y;
        
        line = new GSegment();
        addSegment(line);
        
        square = new GSegment();
        addSegment(square);
        
        
        square.setText(new GText("name", GPosition.MIDDLE));
        
        setStyle(new GStyle());
        //maybe change this and remove the scene field.
        if(parent == null) {
            scene.add(this);
        }
        else {
            parent.add(this);
        }
        /*
        square.addText(name);
        square.addText(taskNumber);
        square.addText(numberOfDays);
        square.addText(startDate);
        square.addText(endDate);
        */
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public void draw() {
        if(parent != null) {
            line.setGeometry(parent.getX(), parent.getY(), x, y);
        }
        
        square.setGeometryXy(Geometry.createCircle(x, y, 40.0));
    }
}
