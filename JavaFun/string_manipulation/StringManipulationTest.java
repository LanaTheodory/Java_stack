public class StringManipulationTest{
    public static void main(String[] args){
        StringManipulation x = new StringManipulation();
        String y = x.trimAndConcat("      String", "    trim");
        
        
        System.out.println(y);

        StringManipulation i = new StringManipulation();
        int z = i.getIndexOrNull("lana" , "n");
        System.out.println(z);


        String s = i.concatSubstring("hello", 1, 2, "world!");
        System.out.println(s);



    }



}