import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
public class Appointment implements Comparable<Appointment> {
    private Doctor doctor;  //Doctor on this appointment
    private Patient patient;    // Patient of appointment
    private GregorianCalendar dateJava;    //Date as Gregorian calender
    /**
     * Appointment constructor that takes a java GregorianCalender class. 
     * @param doctor
     * @param patient
     * @param cal
     */
    Appointment(Doctor doctor, Patient patient, GregorianCalendar cal){
        this.doctor=doctor;
        this.patient=patient;
        dateJava=cal;
        doctor.addAppointment(this);
        patient.addAppointment(this);
    }
    /**
     * Appointment constructor with java GregorianCalender class. 
     * Takes year and month as normal. But on months January is 0 amd December is 11.
     * @param doctor
     * @param patient
     * @param year
     * @param month
     * @param day
     * @param hour
     */
    Appointment(Doctor doctor, Patient patient, int year, int month, int day, int hour){
        dateJava=new GregorianCalendar();
        this.doctor=doctor;
        this.patient=patient;
        dateJava.set(year, month,
                     day, hour, 0, 0);
        //doctor.addAppointment(this);
        //patient.addAppointment(this);
    }

    /**
     * Returns if this appointment is yet to happen.
     * @return  True if this appointments date is greater than current date.
     */
    public Boolean isActive(){
        Boolean active;
        GregorianCalendar now = new GregorianCalendar();
        now.setTime(new Date());
        active = 0<dateJava.compareTo(now);
        return active;
    }

    /**
     * Returns date from GregorianCalender.
     * @return
     */
    public String getDateJava(){
        return dateJava.toZonedDateTime().format(DateTimeFormatter.ofPattern("d MMM uuuu hh:00"));
    }

    /**
     * Returns the doctor on this appointment.
     * @return
     */
    public Doctor getDoctor(){
        return doctor;
    }

    /**
     * Returns the patient on this appointment.
     * @return
     */
    public Patient getPatient(){
        return patient;
    }
    
    /**
     * Returns details as string.
     */
    public String toString(){
        String toReturn="";
        toReturn+="Patient name: "+patient.getPersonalData().getName()+"\n";
        toReturn+="Patient surname: "+patient.getPersonalData().getSurname()+"\n";
        toReturn+="Doctor name: "+doctor.getPersonalData().getName()+"\n";
        toReturn+="Doctor surname: "+doctor.getPersonalData().getSurname()+"\n";
        toReturn+="Appointment date:"+getDateJava()+"\n";
        return toReturn;
    }
    /**
     * Compares date with given appointment.
     */
    public int compareTo(Appointment toCompare){
        return this.dateJava.compareTo(toCompare.dateJava);
    }
    /**
     * Compares date with given date.
     */
    public int compareWithDate(GregorianCalendar date){
        return this.dateJava.compareTo(date);
    }
    /**
     * Returns if two times are the same.
     * @param toCompare
     * @return
     */
    public Boolean isSameTime(GregorianCalendar toCompare){
        //System.out.println("called");
        String thisDate= dateJava.toZonedDateTime().format(DateTimeFormatter.ofPattern("d MMM uuuu hh"));
        String otherDate = toCompare.toZonedDateTime().format(DateTimeFormatter.ofPattern("d MMM uuuu hh"));
        if(thisDate.equals(otherDate)){
            //System.out.println(thisDate+"="+otherDate);
            return true;
        }else{
           // System.out.println(thisDate+"!="+otherDate);
        }
        return false;
    }
}
