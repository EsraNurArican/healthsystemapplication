package HealthSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class MedicalData {
    private ArrayList<String> tests;    // Tests of this patient
    private String bloodType;           // Patients bloodtype
    private ArrayList<String> notes;    // Notes on the patient
    private ArrayList<String> operations;// Operations of the patient
    private Stack<Prescription> prescriptions;  //Prescriptions of the patient
    /**
     * Initializes data structures.
     */
    public MedicalData(){
        tests = new ArrayList<>();
        notes = new ArrayList<>();
        operations = new ArrayList<>();
        prescriptions = new Stack<>();
    }

    /**
     * Initializes data structures and blood type.
     * @param bloodType
     */
    public MedicalData(String bloodType){
        this.bloodType=bloodType;
        tests = new ArrayList<>();
        notes = new ArrayList<>();
        operations = new ArrayList<>();
        prescriptions = new Stack<>();
    }

    /**
     * Initilizes data structures and adds given elements.
     * @param test
     * @param bloodType
     * @param note
     * @param operation
     * @param prescription
     */
    public MedicalData(String test, String bloodType, String note, String operation, Prescription prescription){
        tests = new ArrayList<>();
        notes = new ArrayList<>();
        operations = new ArrayList<>();
        prescriptions = new Stack<>();
        tests.add(test);
        this.bloodType = bloodType;
        notes.add(note);
        operations.add(operation);
        prescriptions.add(prescription);
    }
    /**
     * Returns prescriptions.
     * @return
     */
    public Stack<Prescription> getPrescriptions() {
        return prescriptions;
    }

    /**
     * Adds prescription.
     * @param prescription
     */
    public void addPrescription(Prescription prescription){
        prescriptions.add(prescription);
    }

    /**
     * Adds new operation.
     * @param operation
     */
    public void addOperations(String operation){
        operations.add(operation);
    }
    /**
     * Adds new test.
     * @param test
     */
    public void addTest(String test){
        tests.add(test);
    }
    /**
     * Returns bloodtype.
     * @return
     */
    public String getBloodType() {
        return bloodType;
    }
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    public String toString(){
        String toReturn="";
        toReturn+="\nBlood type: "+ bloodType +" \n";
        toReturn+="\nNotes: \n";
        for (String string : notes) {
            toReturn+=string+"\n";
        }
        toReturn+="\nOperations: \n";
        for (String string : operations) {
            toReturn+=string+"\n";
        }
        toReturn+="\nTests: \n";
        for (String string : tests) {
            toReturn+=string+"\n";
        }
        toReturn+="\nPrescriptions: \n";
        Iterator<Prescription> iter = prescriptions.iterator();
        while(iter.hasNext()){
            toReturn+=iter.next().getMedications()+"\n";
        }
        return toReturn;
       
    }
}
