package HealthSystem;

import java.util.NoSuchElementException;

public class Nurse extends User {
    static int currentID=0;
    /**
     * Creates a person with given information.
     * @param personalData personal data of user
     * @param loginName    login name of user
     * @param password     password of user
     * @param hospital     the hospital to which the user belongs
     */
    public Nurse(PersonalData personalData, String loginName, String password, Hospital hospital) {
        super(personalData, loginName, password, hospital);
    }

    public static int getNextID(){
        currentID++;
        return currentID-1;
    }

    /**
     * Adds to the operations information of the given patient.
     * @param patient   patient to add operations
     * @param operation added operations
     * @throws NoSuchElementException if patient be not exist in hospital
     */
    public void addOperation(Patient patient, String operation){
        Hospital tempHospital = getHospital();
        if(tempHospital.getPatientByID(patient.getPersonalData().getID()) == null)
            throw new NoSuchElementException();
        tempHospital.getPatientByID(patient.getPersonalData().getID()).getMedicalData().addOperations(operation);
    }
}
