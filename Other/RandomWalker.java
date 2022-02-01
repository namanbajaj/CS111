/*************************************************************************
 *  Compilation:  javac RandomWalker.java
 *  Execution:    java RandomWalker
 *
 *  @author:
 *
 * The program RandomWalker that takes an int command-line argument n
 * and simulates the motion of a random walk for n steps. Print the
 * location at each step (including the starting point), treating the
 * starting point as the origin (0, 0). Also, print the square of the
 * final Euclidean distance from the origin.
 *
 *  % java RandomWalker 10
 * (0,0)
 * (-1,0)
 * (-1,-1)
 * (-1,-2)
 * (-1,-3)
 * (-1,-4)
 * (-1,-5)
 * (0,-5)
 * (-1,-5)
 * (-2,-5)
 * (-2,-4)
 * Squared distance = 20.0
 *
 *************************************************************************/

public class RandomWalker {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
		double squaredDistance = 0;

		while(n != -1) {
            int random = (int) (Math.random() * 4);
            
            System.out.println("(" + x + "," + y + ")");
			
			if(random == 0){ //North
                y++;
            }
			if(random == 1){ //East
                x++;
            }
			if(random == 2){ //South
                y--;
            }
			if(random == 3){ //West
                x--;
            }
                
            n--;
            
            squaredDistance = Math.pow(x, 2) + Math.pow(y, 2);
        }

        System.out.println("(" + x + "," + y + ")");


        System.out.println("Squared distance = " + squaredDistance);
    }
}