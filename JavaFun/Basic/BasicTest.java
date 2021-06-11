import java.util.*;

public class BasicTest{
    public static void main(String[] args){
        // Basic n = new Basic();
        // int[] N = n.count();
    
        // ArrayList<Integer> myArray = new ArrayList<Integer>();

        // ArrayList myArray  = n.countOdd();


//         for ( int i= 0; i<N.length; i++){
//             System.out.println(N[i]);
// }  

    //    for ( int i= 0; i<myArray .size(); i++){
    //         System.out.println(M[i]);
    // }
        Basic f = new Basic();
        // int x = f.countSum();

        // ArrayList odd = f.countOdd();
        // for(int i =0; i<odd.size(); i++){
        //     System.out.println(odd.get(i));
        // }

        int[] myArray = {2,10,3};
        // int maxar = f.maxArr(myArray);

        // System.out.println(maxar);

        // int avg = f.avgArr(myArray);
        // System.out.println(avg);

        // int greater = f.greaterArr(myArray , 1);
        // System.out.println(greater);

        // int[] doubarr = f.doubleArr(myArray);
        // for(int i = 0; i < doubarr.length; i++){
        //     System.out.println(doubarr[i]);

        // }

        // int[] shiftarr = f.shift(myArray);
        //   for(int i = 0; i < shiftarr.length; i++){
        //     System.out.println(shiftarr[i]);
        // }

        // int[] positive = f.posArr(myArray);
        // for(int i = 0; i < positive.length; i++){
        //    System.out.println(positive[i]);

        // }
        int[] result = f.avgMaxMin(myArray);
          for(int i = 0; i < result.length; i++){
           System.out.println(result[i]);

        }
   

       





}
}