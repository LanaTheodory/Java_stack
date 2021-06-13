public class ProjectTest{
public static void main(String[] args){
    Project elevatorPitch = new Project("Lana" , "student" );
    System.out.println(elevatorPitch.name + elevatorPitch.desc);

    // System.out.println(elevatorpitch.name +" , " + elevatorpitch.desc);

    elevatorPitch.setName("ghazal");
    elevatorPitch.setDesc("student");
    
    String X = elevatorPitch.getName();
    String Y = elevatorPitch.getDesc();

  

    System.out.println( X +" , " + Y );



}

}