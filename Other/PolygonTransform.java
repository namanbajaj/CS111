/*************************************************************************
 *  Compilation:  javac PolygonTransform.java
 *  Execution:    java PolygonTransform
 *
 *  @author:
 *
 *************************************************************************/

public class PolygonTransform {


    // Returns a new array that is an exact copy of the given array. 
    // The given array is not mutated. 
    public static double[] copy(double[] array) {
        double[] arrayCopy = new double[array.length];
        for(int i = 0; i < array.length; i++){
            arrayCopy[i] = array[i];
        }

        return arrayCopy;
    }
    
    // Scales the given polygon by the factor alpha. 
    public static void scale(double[] x, double[] y, double alpha) {
        for(int i = 0; i < x.length; i++){
            x[i] = x[i] * alpha;
            y[i] = y[i] * alpha;
        }
    }
    
    // Translates the given polygon by (dx, dy). 
    public static void translate(double[] x, double[] y, double dx, double dy) {
        for(int i = 0; i < x.length; i++){
            x[i] = x[i] + dx;
            y[i] = y[i] + dy;
        }
    }
    
    // Rotates the given polygon theta degrees counterclockwise, about the origin. 
    public static void rotate(double[] x, double[] y, double theta) {
        for(int i = 0; i < x.length; i++){
            double ogX = x[i];
            x[i] = x[i] * Math.cos(Math.toRadians(theta)) - y[i] * Math.sin(Math.toRadians(theta));
            y[i] = y[i] * Math.cos(Math.toRadians(theta)) + ogX * Math.sin(Math.toRadians(theta));
        }
    }

    // Tests each of the API methods by directly calling them. 
    public static void main(String[] args) {
        StdDraw.setScale(-5.0, +5.0); 
        double[] x = { 0, 1, 1, 0 }; 
        double[] y = { 0, 0, 2, 1 }; 
        double theta = 45.0; 
        StdDraw.setPenColor(StdDraw.RED); 
        StdDraw.polygon(x, y); 
        rotate(x, y, theta); 
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(x, y);
    }
}
