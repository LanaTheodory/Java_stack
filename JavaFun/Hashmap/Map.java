import java.util.*;

public class Map{
    public static HashMap track(){
        HashMap<String, String> trackList = new HashMap<String,String>();
        trackList.put("allOfMe", "all of me loves all of you");
        trackList.put("Hello", "Hello from the other side");
        trackList.put("fire", "fire on fire");
        trackList.put("jungle", "in the jungle the mighty jungle");

    
        String song = trackList.get("Hello");
        System.out.println(song);

        Set<String> keys = trackList.keySet();

        for(String i : keys ){
            String lyrics = trackList.get(i);

            System.out.println( i +" -" + lyrics );
          
        }


        return trackList;


    }
}