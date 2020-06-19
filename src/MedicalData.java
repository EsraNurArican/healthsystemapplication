import java.util.ArrayList;
import java.util.Stack;

public class MedicalData {
    private ArrayList<String> tests;
    private String bloodType;
    private ArrayList<String> notes;
    private ArrayList<String> operations;
    private Stack<Prescription> prescriptions;

    public MedicalData(){
        tests = new ArrayList<>();
        notes = new ArrayList<>();
        operations = new ArrayList<>();
        prescriptions = new Stack<>();
    }
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
    public Stack<Prescription> getPrescriptions() {
        return prescriptions;
    }
    public void addPrescription(Prescription prescription){
        prescriptions.add(prescription);
    }
    public void addOperations(String operation){
        operations.add(operation);
    }
    public void addTest(String test){
        tests.add(test);
    }
}
