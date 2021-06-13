
public class Dog extends Animal{

    public Dog(){
        super.printType();
        System.out.println("i am a dog");
       
    }



    public static void display(){
        System.out.println("dog class");



    }
    
    public void printType(){
        System.out.println("type " + this.type);


    }

}