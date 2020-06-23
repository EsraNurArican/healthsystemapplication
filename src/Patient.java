import java.util.ArrayList;

public class Patient extends User {
    static int currentID=0;
    private MedicalData medicalData;
    private ArrayList<Appointment> appointments;
    /**
     * Creates a person with given information.
     * @param personalData personal data of user
     * @param loginName    login name of user
     * @param password     password of user
     * @param hospital     the hospital to which the user belongs
     */
    public Patient(PersonalData personalData, String loginName, String password, Hospital hospital) {
        super(personalData, loginName, password, hospital);
        medicalData = new MedicalData();
        appointments = new ArrayList<>();
    }

    static int getNextID(){
        currentID++;
        return currentID-1;
    }

    /**
     * Creates a person with given information.
     * @param personalData  personal data of user
     * @param loginName     login name of user
     * @param password      password of user
     * @param hospital      the hospital to which the user belongs
     * @param test          test name of user
     * @param bloodType     blood type name of user
     * @param note          note of user
     * @param operation     operation name of user
     * @param prescription  prescription object of user
     */
    public Patient(PersonalData personalData, String loginName, String password, Hospital hospital,String test,
                   String bloodType, String note, String operation, Prescription prescription){
        super(personalData, loginName, password, hospital);
        medicalData = new MedicalData(test,bloodType,note,operation,prescription);
        appointments = new ArrayList<>();
    }

    /**
     * Setter method for appointments
     * @param appointments add new appointments object
     */
    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void addAppointment(Appointment app){
        appointments.add(app);
        sortAppointments();
    }

    public void sortAppointments(){
        appointments.sort(null);
    }

    /**
     * Getter method for appointments
     * @return appointments objects
     */
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
    /**
     * Setter method for medical data
     * @param medicalData add new medical data object
     */
    public void setMedicalData(MedicalData medicalData) {
        this.medicalData = medicalData;
    }
    /**
     * Getter method for medical data
     * @return medical data objects
     */
    public MedicalData getMedicalData() {
        return medicalData;
    }
    /**
     * Prints patients appointments
     */
    public void printAppointments(){
        for(Appointment a :appointments){
            if(a.isActive()){
                System.out.println(a.toString());
            }
        }
    }
}
