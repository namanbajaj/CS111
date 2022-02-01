/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author:
 *
 *************************************************************************/

public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {
        return length * Math.sqrt(3) / 2.0;
    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {
        double[] xC = {x, x + length / 2, x - length / 2};
        double[] yC = {y, y + height(length), y + height(length)};
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledPolygon(xC, yC);
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    public static void sierpinski(int n, double x, double y, double length) {
        if(n != 0)
            filledTriangle(x, y, length);

        if(n > 1)
        {
            sierpinski(n - 1, x, y + height(length), length / 2); //top
            sierpinski(n - 1, x - length / 2 , y, length / 2); //bottom left
            sierpinski(n - 1, x + length / 2, y, length / 2); //bottom right
        }
    }

    // Takes an integer command-line argument n; 
    // draws the outline of an equilateral triangle (pointed upwards) of length 1; 
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
    // draws a Sierpinski triangle of order n that fits snugly inside the outline. 
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        double[] outlineX = {0, 1, 0.5};
        double[] outlineY = {0, 0 , height(1)};
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.polygon(outlineX, outlineY);

        sierpinski(n, 0.5, 0, 0.5);

    }
}