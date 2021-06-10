public class StringManipulation{
    public static String  trimAndConcat(String A, String B){
        String A1 = A.trim();
        String B1 = B.trim();
        String c = A1.concat(B1);
        
        return c;
    }

    public static Integer getIndexOrNull(String s, String x){
        int i = s.indexOf(x);
        return i;
    }

    public static String concatSubstring(String s1, int x, int y, String s2){
        String s3 = s1.substring(x,y );
        String s4 = s3.concat(s2);
        return s4;
    }



}