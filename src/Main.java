import HealthSystem.Hospital;

public class Main {
    public static void main(String [] args){
        UserInterface userInterface = new UserInterface();
        userInterface.menu(new Hospital("Group 3"));
    }
}
