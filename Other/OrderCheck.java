public class OrderCheck{
    public static void main(String[] args){
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);
        int num4 = Integer.parseInt(args[3]);

        boolean increasing = (num1 < num2) && (num2 < num3) && (num3 < num4);
        boolean decreasing = (num1 > num2) && (num2 > num3) && (num3 > num4);

        System.out.println(increasing || decreasing);
    }
}