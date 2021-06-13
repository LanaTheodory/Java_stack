public class Animal{
    public String type;
    

    public Animal(){
        this.type = "animal";
        System.out.println("i am an animal");

    }
    public Animal(String name){
        this.type = name;
        System.out.println("type" + this.type);
    }

    public String getAnimal(){
        return this.type;
    }
    public void setAnimal(String name){
        this.type = name;
    }

    public static void display(){
        System.out.println("i am an animal");


    }
    
    public void printType(){
        System.out.println("type " + this.type);


    }
}