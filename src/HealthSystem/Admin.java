package HealthSystem;

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
    public void addFriendDoctor(Doctor doctor1,Doctor doctor2){
        getHospital().addFriendDoctor(doctor1,doctor2);
    }
    public void removeFriendDoctor(Doctor doctor){
        getHospital().removeFriendDoctor(doctor);
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
    /**
     * Remove HealthSystem.Patient
     * @param patient that is removed
     * @return removed patient
     */
    public HealthSystemUsers removePatient(Patient patient){
        return getHospital().removePatient(patient);
    }
    /**
     * Remove HealthSystem.Doctor
     * @param doctor that is removed
     * @return true if remove is successful, otherwise false
     */
    public boolean removeDoctor(Doctor doctor){
        return getHospital().removeDoctor(doctor);
    }
    /**
     * Remove HealthSystem.Nurse
     * @param nurse that is removed
     * @return true if remove is successful, otherwise false
     */
    public boolean removeNurse(Nurse nurse){
        return getHospital().removeNurse(nurse);
    }
    /**
     * Remove HealthSystem.Pharmacist
     * @param pharmacist that is removed
     * @return true if remove is successful, otherwise false
     */
    public boolean removePharmacist(Pharmacist pharmacist){
        return getHospital().removePharmacist(pharmacist);
    }
    /**
     * Remove Lab Employee
     * @param labEmployee that is removed
     * @return true if remove is successful, otherwise false
     */
    public boolean removeLabEmployee(LabEmployee labEmployee){
        return getHospital().removeLabEmployee(labEmployee);
    }

    /**
     * Edit Personal Data (name)
     * @param user whose personal data name information will be updated
     * @param name new name
     */
    public void editPersonalDataName(User user,String name){
        PersonalData temp = user.getPersonalData();
        temp.changeName(name);
    }
    /**
     * Edit Personal Data (surname)
     * @param user whose personal data surname information will be updated
     * @param surname new surname
     */
    public void editPersonalDataSurname(User user,String surname){
        PersonalData temp = user.getPersonalData();
        temp.changeSurname(surname);
    }
    /**
     * Edit medical data (Blood type)
     * @param patient whose personal data name information will be updated
     * @param bloodType new blood type
     */
    public void editMedicalDataBloodType(Patient patient,String bloodType){
        MedicalData temp = patient.getMedicalData();
        temp.setBloodType(bloodType);
    }
    /**
     * Add announcement
     * @param doctor whose new announcement will be added
     * @param announcement new announcement
     */
    public void addAnnouncement(Doctor doctor,String announcement){
        doctor.addAnnouncement(announcement);
    }
    public void printFriendDoctor(){
        System.out.println(getHospital().getFriendDoctors().toString());
    }
}
