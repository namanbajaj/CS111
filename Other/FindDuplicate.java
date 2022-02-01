/*************************************************************************
 *  Compilation:  javac FindDuplicate.java
 *  Execution:    java FindDuplicate
 *
 *  @author:
 *
 * FindDuplicate that reads n integer arguments from the command line 
 * into an integer array of length n, where each value is between is 1 and n, 
 * and displays true if there are any duplicate values, false otherwise.
 *
 *  % java FindDuplicate 10 8 5 4 1 3 6 7 9
 *  false
 *
 *  % java FindDuplicate 4 5 2 1 
 *  true
 *************************************************************************/

public class FindDuplicate{
    public static void main(String[] args){
        boolean foundDup = false;
        for(int i = 0; i < args.length; i++){
            int parsedNum = Integer.parseInt(args[i]);
            int compareNum = 0;

            for(int j = i + 1; j < args.length; j++){
                compareNum = Integer.parseInt(args[j]);
                if(parsedNum == compareNum){
                    foundDup = true;
                }
            }
        }

        if(!foundDup){
            System.out.println(false);
        }
        else{
            System.out.println(true);
        }
    }
}