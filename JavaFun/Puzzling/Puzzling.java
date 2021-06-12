
import java.util.*;

public class Puzzling{

//     public static ArrayList<Integer> listArr(int y){
//         ArrayList<Integer> list = new ArrayList<Integer>();
//         int[] newarr = { 3,5,1,2,7,9,8,13,25,32};
//         int sum=0;

//         for (int i = 0 ; i< newarr.length; i++ ){
//             sum+= newarr[i];
//             if(y < newarr[i]  ){
//                 list.add(newarr[i]);
//         }
        
//         }
//         System.out.println(sum)
//         return list;
// }
////////////////////////////////////////

//  public static ArrayList <String> shuffle( ArrayList <String> myArray){
//     Collections.shuffle(myArray);
//     ArrayList<String> list = new ArrayList<String>();


//     for(int i = 0; i < myArray.size(); i++){
//         String name = myArray.get(i);
//         System.out.println(name);
//         if(name.length() > 10 ){
//             list.add(name);
//         }
//     }

//     return list;

//  }

// public static void letters(){

   
  
//     ArrayList<Character> array = new ArrayList<Character>();

//         for(char i= 'a'; i <= 'z'; i++){
//             array.add(i);
//         }

  
//     Collections.shuffle(array);
//     System.out.println(array);

//     System.out.println(array.get(0));
    
//     System.out.println(array.get((array.size()-1)));
//     char[] vowels = {'a', 'e', 'i', 'o', 'u'}
//     for(i : vowels){
//         if(i == array.get(0)){
//             System.out.println( i + "is a vowel");
//         }
//     }

//////////////////////////////////////
// public static int[] numbers(){
//     int[] array = new int[10];
//     Random r = new Random();
//     for(int i = 0; i<10; i++){
//         array[i] = r.nextInt(100-55) +55;
//     }
//     return array;
// }
///////////////////////////////////////
// public static ArrayList <Integer> numbersTwo(){
//     ArrayList <Integer> array = new ArrayList <Integer>();

//     Random r = new Random();
//     for(int i = 0; i<10; i++){
//         array.add(r.nextInt(100-55) +55);
//     }
//     Collections.sort(array);
//     System.out.println(array);
//     System.out.println(array.get(0));
//     System.out.println(array.get(array.size()-1));
// return array;

// }
////////////////////////////////////////
public static String sentence(){
    ArrayList<Character> array = new ArrayList<Character>();

        for(char i= 'a'; i <= 'z'; i++){
            array.add(i);
        }

        Random r = new Random();
        String x = "";

    for(int i = 0; i<5; i++){
        x += array.get(r.nextInt(25));
    }

// System.out.println(x);

return x;

}

///////////////////////////////////////////////////////
public static void sentence2(){

    ArrayList<String> newarr = new ArrayList<String>();

    for(int d = 0; d<10; d++){
        
        newarr.add(sentence());
    
    }


System.out.println(newarr);


}



}