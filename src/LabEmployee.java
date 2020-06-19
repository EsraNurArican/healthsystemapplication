import java.util.NoSuchElementException;

public class LabEmployee extends User {

    /**
     * Creates a person with given information.
     * @param personalData personal data of user
     * @param loginName    login name of user
     * @param password     password of user
     * @param hospital     the hospital to which the user belongs
     */
    public LabEmployee(PersonalData personalData, String loginName, String password, Hospital hospital) {
        super(personalData, loginName, password, hospital);
    }
    /**
     * Adds to the test information of the given patient.
     * @param patient   patient to add test
     * @param test added test
     * @throws NoSuchElementException if patient be not exist in hospital
     */
    public void addTest(Patient patient, String test){
        Hospital tempHospital = getHospital();
        if(tempHospital.getPatientByID(patient.getPersonalData().getID()) == null)
            throw new NoSuchElementException();
        tempHospital.getPatientByID(patient.getPersonalData().getID()).getMedicalData().addTest(test);
    }
}
