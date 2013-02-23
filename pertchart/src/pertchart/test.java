/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertchart;

/**
 *
 * @author Aidan
 */
public class test {
    public static void main(String [] args) {
        Matrix twoDArray = new Matrix(15, 7);
        //twoDArray.printArrayOfInts();
        //twoDArray.changeAllInts();
        //twoDArray.printArrayOfInts();
        twoDArray.changeInt(3, 2);
        twoDArray.changeInt(5, 5);
        twoDArray.printArrayOfInts();
        
    }
}
