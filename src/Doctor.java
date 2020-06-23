import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Doctor extends User{
    static int currentID=0;
    private String expertise;
    private Queue<Appointment> appointments;
    /**
     * Creates a person with given information.
     * @param personalData personal data of user
     * @param loginName    login name of user
     * @param password     password of user
     * @param hospital     the hospital to which the user belongs
     */
    public Doctor(PersonalData personalData, String loginName, String password, Hospital hospital) {
        super(personalData, loginName, password, hospital);
        appointments = new LinkedList<>();
    }

    static int getNextID(){
        currentID++;
        return currentID-1;
    }

    /**
     * Creates a person with given information.
     * @param personalData personal data of user
     * @param loginName    login name of user
     * @param password     password of user
     * @param hospital     the hospital to which the user belongs
     * @param expertise    doctor's expertise
     */
    public Doctor(PersonalData personalData, String loginName, String password, Hospital hospital,String expertise){
        super(personalData, loginName, password, hospital);
        this.expertise = expertise;
        appointments = new LinkedList<>();
    }
    /**
     * Getter method for appointments
     * @return appointments object for user
     */
    public Queue<Appointment> getAppointments() {
        return appointments;
    }
    /**
     * Getter method for expertise
     * @return expertise for user
     */
    public String getExpertise() {
        return expertise;
    }
    /**
     * Sets appointments with new Appointments object
     * @param appointments new appointments object
     */
    public void setAppointments(Queue<Appointment> appointments) {
        this.appointments = appointments;
    }
    /**
     * Sets expertise
     * @param expertise new expertise for user
     */
    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
    /**
     * Adding prescription to the given patient.
     * @param patient       who needs prescription
     * @param prescription  to be added
     */
    public void addPrescription(Patient patient,Prescription prescription){
        MedicalData tempMedicalData = getPatientData(patient);
        tempMedicalData.addPrescription(prescription);
    }
    /**
     * Getter nearby appointment for user.
     * @return nearby appointment if appointment is not null, otherwise return null
     */
    public Appointment getNearbyAppointments(){
        if(appointments == null)
            return null;
        else
            return appointments.element();
    }
    /**
     * The wanted patient is founded in the hospital.
     * Returns medical data if found. Otherwise it throws the exception.
     * @param patient to be founded
     * @return patient if it is founded
     * @throws NoSuchElementException if patient is not exist in hospital
     */
    public MedicalData getPatientData(Patient patient){
        Hospital tempHospital = getHospital();
        Patient tempPatient =  tempHospital.getPatientByID(patient.getPersonalData().getID());
        if(tempPatient == null)
            throw new NoSuchElementException();
        return tempPatient.getMedicalData();
    }
}
