
import java.lang.*;

public class Pythagorean {
    public static double calculateHypotenuse(int legA, int legB) {
        

        double c = Math.sqrt(Math.pow(legA,2) + Math.pow(legB,2)); 
        System.out.println(c);

        return c;
    }

    public static void main(String[] args){
        System.out.println(calculateHypotenuse(1,  3));

    }
}

