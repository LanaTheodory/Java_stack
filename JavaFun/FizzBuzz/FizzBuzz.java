public class FizzBuzz {
    public static String fizzBuzz(int number) {
        String x;
        if (number % 3 == 0){
            x = "Fizz";
            
        }
        if(number % 5 == 0){
            x = "Buzz";
        }
        if (number % 3 == 0 && number % 5 == 0){
            x = "FizzBuzz";
        }
        else {

            x = String.valueOf(number);
        }
        
        return x;
    
    }

}
