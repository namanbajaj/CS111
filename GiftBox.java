public class GiftBox {

    private double length;
    private double width;
    private double height;
    
    
    public GiftBox(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    public GiftBox getNewBox(GiftBox box, double m){
        GiftBox newBox = new GiftBox(length * m, width * m, height * m);
    
        return newBox;
    
    }
    public boolean fitsInside(GiftBox box){
        if(box.length < this.length && box.width < this.width && box.height < this.height){
            return true;
        }
    
        return false;
    }
    
    public static void main(String[] args){
        GiftBox gift       = new GiftBox(3.0, 4.0, 5.0);
    GiftBox other      = new GiftBox(2.1, 3.2, 4.3);
    GiftBox yetAnother = new GiftBox(2.0, 5.0, 4.0);
    
    System.out.println(gift.fitsInside(other));
    }
       }