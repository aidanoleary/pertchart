/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertchart;

/**
 *
 * @author Aidan
 * This is a class that will contain a field which contains a 2d array which will be
 * used to represent which tasks are connected to each other.
 */
public class Matrix {
    //A field that holds the number of rows the 2d array will have.
    private int rows;
    
    //A field that holds the number of columns the 2d array will have.
    private int columns;
    
    //This is a field that contains a 2 dimensional array of boolean values.
    private boolean[][] arrayOfBooleans;
    
    //This is a field that contains a 2 dimensional array of integer values,
    //1's and 0's.
    private int[][] arrayOfInts;
    
    /*
     * Constructors for objects of Class Matrix.
     */
    public Matrix() {
        
    }
    
    public Matrix(int numberOfRows, int numberOfColumns) {
        rows = numberOfRows;
        columns = numberOfColumns;
        arrayOfBooleans = new boolean[rows][columns];
        arrayOfInts = new int[rows][columns];
    }
    
    /*
     * Accessor methods for fields of the ConnectivityMatrix Class.
     */
    public boolean[][] getArrayOfBooleans() {
        return arrayOfBooleans;
    }
    
    public int[][] getArrayOfInts() {
        return arrayOfInts;
    }
    
    /*
     * A method that changes the value of one of the items within the 
     * arrayOfBooleans field.
     */
    public void changeBoolean(int row, int column, boolean value) {
        arrayOfBooleans[row][column] = value; 
    }
    
    public void changeInt(int row, int column) {
        if(arrayOfInts[row][column] == 0) {
            arrayOfInts[row][column] = 1;
        }
        else {
            arrayOfInts[row][column] = 0;
        }
    }
    
    /*
     * A method that changes all the values of the arrayOfBooleans field.
     */
    public void changeAllBooleans() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(arrayOfBooleans[i][j] == false) {
                    arrayOfBooleans[i][j] = true;
                }
                else {
                    arrayOfBooleans[i][j] = false;
                }
            }
        }
    }
    
    /*
     * A method that changes all the values of the arrayOfInts field.
     */
    public void changeAllInts() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(arrayOfInts[i][j] == 0) {
                    arrayOfInts[i][j] = 1;
                }
                else {
                    arrayOfInts[i][j] = 0;
                }
            }
        }
    }
    
    /*
     * A method that prints out the arrayOfBooleans two dimensional array.
     */
    public void printArrayOfBooleans() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                System.out.print(arrayOfBooleans[i][j]);
                System.out.print(" ");
            }
            
            System.out.println();
        }
    }
    
    /*
     * A method that prints out the arrayOfInts two dimensional array.
     */
    public void printArrayOfInts() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                System.out.print(arrayOfInts[i][j]);
                System.out.print(" ");
            }
            
            System.out.println();
        }
        
    }
}
