public class Div{
    public static void main(String[] args){
        double dividend = Double.parseDouble(args[0]);
        double divisor = Double.parseDouble(args[1]);

        if(divisor == 0){
            System.out.println("Error");
        }

        else{
            System.out.println(dividend / divisor);
        }
    }
}