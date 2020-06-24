package HealthSystem;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class Doctor extends User{
    static int currentID=0;
    private String expertise;
    private ArrayList<Appointment> appointments;
    final String[] appointmentSlots= {"9","10","11"};
    private Stack<String> announcement;
    /**
     * Creates a person with given information.
     * @param personalData personal data of user
     * @param loginName    login name of user
     * @param password     password of user
     * @param hospital     the hospital to which the user belongs
     */
    public Doctor(PersonalData personalData, String loginName, String password, Hospital hospital) {
        super(personalData, loginName, password, hospital);
        appointments = new ArrayList<Appointment>();
        announcement = new Stack<>();
    }
    /**
     * Print announcement
     * @throws NoSuchElementException if stack announcement is empty
     */
    public void printAnnouncement(){
        if(announcement.isEmpty())
            throw new NoSuchElementException();
        else{
            int i=1;
            while (!announcement.isEmpty()){
                System.out.println(i + announcement.pop());
                i++;
            }
        }
    }
    public void addAnnouncement(String announcemet_){
        announcement.add(announcemet_);
    }
    public static int getNextID(){
        currentID++;
        return currentID-1;
    }
    /**
     * Sorts appointments using java mergesort. 
     */
    public void sortAppointments(){
        appointments.sort(null);
    }

    /**
     * Adds given appointment.
     */
    public void addAppointment(Appointment app){
        appointments.add(app);
        sortAppointments();
    }

    /**
     * HealthSystem.Appointment dialogue for patien
     */
    public void appointmentDialogue(Patient patient){
        Integer options=0;
        Boolean timeFree=true;
        HashMap<Integer,GregorianCalendar> times = new HashMap<>();
        GregorianCalendar time= new GregorianCalendar();
        time.set(GregorianCalendar.MINUTE, 0);
        time.set(GregorianCalendar.MILLISECOND,0);
        time.set(GregorianCalendar.SECOND,0);
        for(int i=0;i<3;i++){
            time.roll(GregorianCalendar.DAY_OF_MONTH, true);
            for (String string : appointmentSlots) {
                time.set(GregorianCalendar.HOUR, Integer.parseInt(string));
                for (Appointment appointment : appointments) {
                    if(appointment.isSameTime(time)){
                        timeFree=false;
                    }
                }
                if(timeFree){
                    options++;
                    times.put(options, (GregorianCalendar)time.clone());
                    System.out.println("ID:"+ options +" Time:"+time.toZonedDateTime().format(DateTimeFormatter.ofPattern("d MMM uuuu hh:ss")));
                }
                timeFree=true;
            }
        }
        if(options==0){
            System.out.println("No available dates for this doctor.");
            return;
        }
        System.out.println("Enter id of the slot you want to take.");
        Scanner scan= new Scanner(System.in);
        Integer selected = Integer.parseInt(scan.nextLine());
        if(!times.containsKey(selected)){
            System.out.println("Invalid ID.");
            return;
        }
        System.out.println("Selected time:"+times.get(selected).toZonedDateTime().format(DateTimeFormatter.ofPattern("d MMM uuuu hh:ss")));
        new Appointment(this, patient, times.get(selected));
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
        appointments = new ArrayList<>();
    }
    /**
     * Getter method for appointments
     * @return appointments object for user
     */
    public ArrayList<Appointment> getAppointments() {
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
    public void setAppointments(ArrayList<Appointment> appointments) {
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
        sortAppointments();
        for (Appointment appointment : appointments) {
            if(appointment.isActive()){
                return appointment;
            }
        }
        return null;
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
    /**
     * Prints doctors appointments
     */
    public void printAppointments(){
        for(Appointment a :appointments){
            if(a.isActive()){
                System.out.println(a.toString());
            }
        }
    }
    public void addFriendDoctor(Doctor doctor1,Doctor doctor2){
        getHospital().addFriendDoctor(doctor1,doctor2);
    }
    public void removeFriendDoctor(Doctor doctor){
        getHospital().removeFriendDoctor(doctor);
    }
    public void printFriendDoctor(){
        System.out.println(getHospital().getFriendDoctors().toString());
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expertise: ").append(expertise).append("\n");
        stringBuilder.append("HealthSystem.Appointment: ");
        for (Appointment appointment : appointments) {
            stringBuilder.append(appointment.toString());
        }
        return stringBuilder.toString();
    }
}
