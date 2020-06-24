import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Keeps whole information about hospital.
 * @author group3
 */
public class Hospital
{
    /** Hospital name */
    private String name;
    /** Administrator of the hospital */
    private Admin admin;
    /** Patients in the hospital */
    private TreeMap<HealthSystemUsers,HealthSystemUsers> patients;
    /** Doctors in the hospital */
    private ArrayList<HealthSystemUsers> doctors;
    /** Nurses in the hospital */
    private ArrayList<HealthSystemUsers> nurses;
    /** Pharmacists in the hospital */
    private ArrayList<HealthSystemUsers> pharmacists;
    /** Lab employees in the hospital*/
    private ArrayList<HealthSystemUsers> labEmployees;

    /**
     * Builds a hospital system with given information.
     * @param admin administrator of the hospital
     * @param name name of the hospital
     */
    public Hospital( String name)
    {
    	
        this.admin = new Admin(new PersonalData("admin", "surname", 0), "admin", "123", this);
        this.name = name;
        patients = new TreeMap<>();
        doctors = new ArrayList<>();
        nurses = new ArrayList<>();
        pharmacists = new ArrayList<>();
        labEmployees = new ArrayList<>();
    }
    
    

    /** Patients getter.
     * @return Patients
     */
    public TreeMap<HealthSystemUsers, HealthSystemUsers> getPatients() {
		return patients;
	}


	/** Doctors getter.
	 * @return Doctors
	 */
	public ArrayList<HealthSystemUsers> getDoctors() {
		return doctors;
	}


	/** Nurses getter.
	 * @return Nurses
	 */
	public ArrayList<HealthSystemUsers> getNurses() {
		return nurses;
	}


	/** Pharmacists getter.
	 * @return Pharmacist
	 */
	public ArrayList<HealthSystemUsers> getPharmacists() {
		return pharmacists;
	}



	/** Lab employees getter.
	 * @return Lab employees.
	 */
	public ArrayList<HealthSystemUsers> getLabEmployees() {
		return labEmployees;
	}





	/**
     * Returns administrator.
     * @return administrator
     */
    public Admin getAdmin() { return admin; }

    /**
     * Returns patient of the given id.
     * @param id given id
     * @return patient if patient is exist. Otherwise null
     */
    public Patient getPatientByID(int id) { return (Patient)patients.get(new User(new PersonalData(null,null,id),null,null,null)); }

    /**
     * Returns doctor of the given id.
     * @param id given id
     * @return doctor if doctor is exist. Otherwise null
     */
    public Doctor getDoctorByID(int id) { return (Doctor)getUserByID(id,doctors); }

    /**
     * Returns nurse of the given id.
     * @param id given id
     * @return nurse if nurse is exist. Otherwise null
     */
    public Nurse getNurseByID(int id) { return (Nurse)getUserByID(id,nurses); }

    /**
     * Returns pharmacist of the given id.
     * @param id given id
     * @return pharmacist if pharmacist is exist. Otherwise null
     */
    public Pharmacist getPharmacistByID(int id) { return (Pharmacist)getUserByID(id,pharmacists); }

    /**
     * Returns lab employee of the given id.
     * @param id given id
     * @return lab employee if lab employee is exist. Otherwise null
     */
    public LabEmployee getLabEmployeeByID(int id) { return (LabEmployee)getUserByID(id,labEmployees); }

    /**
     * Returns hospital status.
     * @return hospital status
     */
    public String getHospitalStats() { return name; }

    /**
     * Returns whether given id number is in the given section.
     * @param id given id number
     * @param list given section
     * @return user if user is in the system. Otherwise null
     */
    private HealthSystemUsers getUserByID(int id, List<HealthSystemUsers> list)
    {
        for(HealthSystemUsers user : list)
            if(user.getPersonalData().getID() == id)
                return user;
        return null;
    }

    /**
     * Adds given patient to the system.
     * @param patient given doctor
     * @return true if patient doesn't exist. Otherwise false
     */
    public boolean addPatient(Patient patient) { return patients.put(patient,patient) == null; }

    /**
     * Adds given doctor to the system.
     * @param doctor given doctor
     * @return true if doctor doesn't exist. Otherwise false
     */
    public boolean addDoctor(Doctor doctor) { return doctors.add(doctor); }

    /**
     * Adds given nurse to the system.
     * @param nurse given nurse
     * @return true if nurse doesn't exist. Otherwise false
     */
    public boolean addNurse(Nurse nurse) { return nurses.add(nurse); }

    /**
     * Adds given pharmacist to the system.
     * @param pharmacist given pharmacist
     * @return true if pharmacist doesn't exist. Otherwise false
     */
    public boolean addPharmacist(Pharmacist pharmacist) { return pharmacists.add(pharmacist); }

    /**
     * Adds given lab employee to the system.
     * @param labEmployee given lab employee
     * @return true if lab employee doesn't exist. Otherwise false
     */
    public boolean addLabEmployee(LabEmployee labEmployee) { return labEmployees.add(labEmployee); }
    public HealthSystemUsers removePatient(Patient patient){
        return patients.remove(patient);
    }
    
    public boolean removeDoctor(Doctor doctor){
        return doctors.remove(doctor);
    }
    public boolean removeNurse(Nurse nurse){
        return nurses.remove(nurse);
    }
    public boolean removePharmacist(Pharmacist pharmacist){
        return pharmacists.remove(pharmacist);
    }
    public boolean removeLabEmployee(LabEmployee labEmployee){
        return labEmployees.remove(labEmployee);
    }
    
    /**
     * Returns string representation of the hospital.
     * @return string representation of the hospital
     */
    @Override
    public String toString() { return getHospitalStats(); }
}
