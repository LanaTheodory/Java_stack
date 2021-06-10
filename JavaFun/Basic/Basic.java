import java.util.ArrayList;

public class Basic{
    public static int[] count(){
        int[] newarray;
        newarray = new int[255];
        for (int i = 0; i < 255; i++){
            newarray[i] = i+1;

        }
    return newarray;
    }

//  public static ArrayList countOdd(){
//       ArrayList<Integer> myArray = new ArrayList<Integer>();
      
//         for (int i = 0; i < 255; i++){
//             if ((i+1) % 2 != 0){
//             myArray.add(i+1);
//             }
    
//         }
//         return myArray;



    public static int countSum(){
        int sum = 0;
        
        
        for (int c = 0; c < 255; c++){
            sum += c;
            System.out.println("new number :" + c + " " + "sum is:" + sum );

        }
    return sum;
    }

    /////////////////////////////////////
     public static int[] count(){
        int[] newarray;
        
        for (int i = 0; i < 255; i++){
            newarray[i] = i+1;

        }
    return newarray;
    }


}


    

   
