public class Admin extends User {
    /**
     * Creates a person with given information.
     * @param personalData personal data of user
     * @param loginName    login name of user
     * @param password     password of user
     * @param hospital     the hospital to which the user belongs
     */
    public Admin(PersonalData personalData, String loginName, String password, Hospital hospital) {
        super(personalData, loginName, password, hospital);
    }
    /**
     * Adds given patient to the system.
     * @param patient given doctor
     * @return true if patient doesn't exist. Otherwise false
     */
    public boolean addPatient(Patient patient){
        return getHospital().addPatient(patient);
    }
    /**
     * Adds given doctor to the system.
     * @param doctor given doctor
     * @return true if doctor doesn't exist. Otherwise false
     */
    public boolean addDoctor(Doctor doctor){
       return getHospital().addDoctor(doctor);
    }
    /**
     * Adds given lab employee to the system.
     * @param labEmployee given lab employee
     * @return true if lab employee doesn't exist. Otherwise false
     */
    public boolean addLabEmployee(LabEmployee labEmployee){
        return getHospital().addLabEmployee(labEmployee);
    }
    /**
     * Adds given nurse to the system.
     * @param nurse given nurse
     * @return true if nurse doesn't exist. Otherwise false
     */
    public boolean addNurse(Nurse nurse){
        return getHospital().addNurse(nurse);
    }
    /**
     * Adds given pharmacist to the system.
     * @param pharmacist given pharmacist
     * @return true if pharmacist doesn't exist. Otherwise false
     */
    public boolean addPharmacist(Pharmacist pharmacist){
        return getHospital().addPharmacist(pharmacist);
    }
    public void editPersonelData(Patient patient){



    }
}
