public class E2B{
    public static void main(String[] args){
        int n = StdIn.readInt();

        int[][] nums = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                nums[i][j] = StdIn.readInt();
            }
        }
        
        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                System.out.print(nums[j][i] + " ");
            }
            System.out.println();
        }
    }
}