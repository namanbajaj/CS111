/*************************************************************************
 *  Compilation:  javac RURottenTomatoes.java
 *  Execution:    java RURottenTomatoes
 *
 *  @author:
 *
 * RURottenTomatoes creates a 2 dimensional array of movie ratings 
 * from the command line arguments and displays the index of the movie 
 * that has the highest sum of ratings.
 *
 *  java RURottenTomatoes 3 2 5 2 3 3 4 1
 *  0
 *************************************************************************/

public class RURottenTomatoes {

	public static void main(String[] args) {
		int rows = Integer.parseInt(args[0]);
		int columns = Integer.parseInt(args[1]);

		int[][] movies = new int[rows][columns];

		int counter = 2;

		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				movies[i][j] = Integer.parseInt(args[counter]);
				counter++;
			}
		}

		int hS = 0;
		int hSI = 0;

		for(int i = 0; i < columns; i++) {
			int sum = 0;
			for(int j = 0; j < rows; j++) {
				sum+= movies[j][i];
			}
			
			if(sum > hS) {
				hS = sum;
				hSI = i;
			}
		}
		
		System.out.println(hSI);
	}
}