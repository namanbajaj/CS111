public class IntCheck
{
    public static void main ( String[] args )
    {
       int x = Integer.parseInt(args[0]);

       if(x > 100){
           System.out.println("GT");
       }

       else if(x < 100){
           System.out.println("LT");
       }

       else{
           System.out.println("EQ");
       }
    }
}