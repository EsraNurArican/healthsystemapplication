import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
public class Appointment {
    private Doctor doctor;  //Doctor on this appointment
    private Patient patient;    // Patient of appointment
    private String date;    //Date as string
    private GregorianCalendar dateJava;    //Date as Gregorian calender

    /**
     * Appointment constructor String version
     * @param doctor
     * @param patient
     * @param date
     */
    Appointment(Doctor doctor, Patient patient, String date){
        this.doctor=doctor;
        this.patient=patient;
        this.date=date;
        //doctor.addAppointment(this);
        //patient.addAppointment(this);
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
        System.out.println("date"+getDateJava());
        return active;
    }

    /**
     * Returns date from GregorianCalender.
     * @return
     */
    public String getDateJava(){
        return dateJava.toZonedDateTime().format(DateTimeFormatter.ofPattern("d MMM uuuu"));
    }

    /**
     * Returns date from date string.
     * @return
     */
    public String getDate(){
        return date;
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
    
    public String toString(){
        String toReturn="";
        toReturn+="Patient name: "+patient.getPersonalData().getName()+"\n";
        toReturn+="Patient surname: "+patient.getPersonalData().getSurname()+"\n";
        toReturn+="Doctor name: "+doctor.getPersonalData().getName()+"\n";
        toReturn+="Doctor surname: "+doctor.getPersonalData().getSurname()+"\n";
        toReturn+="Appointment date:"+getDateJava()+"\n";
        return toReturn;
    }

}
