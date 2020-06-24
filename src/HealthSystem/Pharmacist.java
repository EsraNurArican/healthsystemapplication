package HealthSystem;

import java.util.ArrayList;
public class Pharmacist extends User {
    static int currentID=0;
    private String pharmacyName;
    /**
     * Creates a person with given information.
     * @param personalData personal data of user
     * @param loginName    login name of user
     * @param password     password of user
     * @param hospital     the hospital to which the user belongs
     */
    public Pharmacist(PersonalData personalData, String loginName, String password, Hospital hospital,String pharmacyName) {
        super(personalData, loginName, password, hospital);
        this.pharmacyName = pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }
    public String getPharmacyName(){
        return this.pharmacyName;
    }
    static int getNextID(){
        currentID++;
        return currentID-1;
    }
    public void printPrescription(Patient patient){
        ArrayList<Prescription> tempPrescription = patient.getMedicalData().getPrescriptions();
        int i=1;
        for (Prescription prescription : tempPrescription) {
            System.out.println(i + ") " + prescription.toString() + "\n");
            i++;
        }
    }
    @Override
    public String toString() {
        return "pharmacyName : " + pharmacyName + '\n';
    }
}
