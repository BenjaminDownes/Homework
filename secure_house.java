import java.util.Scanner;
public class secure_house{

  public static void main(String[] args) {
  Scanner input = new Scanner(System.in);
  String owner_name = args[0];
  String keys = ""; //password too get into the house
  String currentOccupancy = "";
  boolean doorOpen = false;
  String token = "";
  String name = "";
  String id_key = "" ;
  int count = 0; //keeps track of occupancy
  for(int i = 1; i < args.length; i++) {
    keys += args[i] + " ";
  }

  while(input.hasNext() == true){ //will end when input tokens end
    
    token = input.next();
    switch(token){

    case "INSERT" :
      input.next();
      name = input.next();
      id_key = input.next();
      System.out.println("KEY " + id_key + " INSERTED BY " + name);
    break;

    case "TURN" :
      if(keys.contains(id_key)){
        System.out.println("SUCCESS " + name + " TURNS KEY " + id_key);
        doorOpen = true;  
      }
      else if (id_key.equals("POLICE_SECRET_KEY")){
        System.out.println("SUCCESS " + name + " TURNS KEY " + id_key);
        doorOpen = true;  
      }
      else if (id_key.equals("FIREFIGHTER_SECRET_KEY")){
        System.out.println("SUCCESS " + name + " TURNS KEY " + id_key);
        doorOpen = true;
      }
      else{
        System.out.println("FAILURE " + name + " UNABLE TO TURN KEY " + id_key);
      }
      break;

    case "ENTER" :
      if(doorOpen == true){
        System.out.println("ACCESS ALLOWED");
        currentOccupancy += name + " ";
        count += 1;
        doorOpen = false; //lock door
      }
      else {
        System.out.println("ACCESS DENIED");
        }
    
    break;

    case "WHO'S" :
      if (count == 0 ){
        System.out.println("NOBODY HOME");
      }
      else{
        System.out.println(currentOccupancy);
      }
    
    break;
    case "CHANGE" :
      
      if(name.equals(owner_name)){
        input.next();
        input.next();
        keys += " " + input.next(); //get to work for n # of keys
        System.out.println("OK");
      }
      else {  //current user is not the owner
        System.out.println("ACCESS DENIED");
      }
    break;
    case "LEAVE" :
      if(currentOccupancy.contains(name)){
        currentOccupancy.replace(name, "");
        System.out.println("OK");
        count -= 1;
      }
      else{
        System.out.println(name + " NOT HERE");
      }
    break;

    default :
    }//end of switch  
    }
  }
}




  

  
  
