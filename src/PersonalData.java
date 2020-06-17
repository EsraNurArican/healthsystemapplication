/**
 * PersonalData class represents personal information such as name, surname.
 * Includes methods to change personal information.
 */
public class PersonalData {

    private String name;
    private String surname;
    private int ID;

    /**
     * Changes person's name with a new name
     * @param newName String new name parameter
     * @return changed name
     */
    public String changeName(String newName){
        name = newName;
        return name;
    }

    /**
     * Changes person's surname with a new surname
     * @param newSurname String new surname parameter
     * @return changed surname
     */
    public String changeSurname(String newSurname){
        surname = newSurname;
        return surname;
    }

    /**
     * Getter for ID information
     * @return int ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Getter for name information
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for surname information
     * @return String surname
     */
    public String getSurname() {
        return surname;
    }
}

