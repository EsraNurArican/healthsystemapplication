package HealthSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import DataStructures.SkipList;

/**
 * Keeps whole information about hospital.
 * @author group3
 */
public class Hospital
{
    /** HealthSystem.Hospital name */
    private String name;
    /** Administrator of the hospital */
    private Admin admin;
    /** Patients in the hospital (Red Black Tree) */
    private TreeMap<HealthSystemUsers,HealthSystemUsers> patients;
    /** Doctors in the hospital */
    private SkipList<HealthSystemUsers> doctors;
    /** Nurses in the hospital */
    private ArrayList<HealthSystemUsers> nurses;
    /** Pharmacists in the hospital */
    private ArrayList<HealthSystemUsers> pharmacists;
    /** Lab employees in the hospital*/
    private ArrayList<HealthSystemUsers> labEmployees;
    /** Family doctors in the hospital */
    private TreeMap<HealthSystemUsers,HealthSystemUsers> familyDoctors;

    /**
     * Builds a hospital system with given information.
     * @param name name of the hospital
     */
    public Hospital( String name)
    {
        this.admin = new Admin(new PersonalData("admin", "surname", 0), "admin", "123", this);
        this.name = name;
        patients = new TreeMap<>();
        doctors = new SkipList<>();
        nurses = new ArrayList<>();
        pharmacists = new ArrayList<>();
        labEmployees = new ArrayList<>();
        familyDoctors = new TreeMap<>();
    }

    /** Patients getter.
     * @return Patients
     */
    public TreeMap<HealthSystemUsers, HealthSystemUsers> getPatients() { return patients; }

	/** Doctors getter.
	 * @return Doctors
	 */
	public SkipList<HealthSystemUsers> getDoctors() { return doctors; }

	/** Nurses getter.
	 * @return Nurses
	 */
	public ArrayList<HealthSystemUsers> getNurses() { return nurses; }

	/** Pharmacists getter.
	 * @return HealthSystem.Pharmacist
	 */
	public ArrayList<HealthSystemUsers> getPharmacists() { return pharmacists; }

	/** Lab employees getter.
	 * @return Lab employees
	 */
	public ArrayList<HealthSystemUsers> getLabEmployees() { return labEmployees; }

    /**
     * Family doctors getter.
     * @return Family doctor
     */
	public TreeMap<HealthSystemUsers,HealthSystemUsers> getFamilyDoctors() { return familyDoctors; }

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
    public Doctor getDoctorByID(int id) { return (Doctor)getDoctors().find(new Doctor(new PersonalData(null,null,id),null,null,null)); }

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
     * Returns given patient's family doctor.
     * @param patient given patient
     * @return doctor if patient has a family doctor. Otherwise null
     */
    public Doctor getPatientsFamilyDoctor(Patient patient) { return (Doctor)familyDoctors.get(patient); }

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

    /**
     * Adds the given id of doctor to the given patient as a family doctor.
     * @param patient given patient
     * @param id given id
     * @return true if given patient's family doctor doesn't exist. Otherwise false
     */
    public boolean addFamilyDoctor(Patient patient, int id)
    {
        Doctor doc;
        if((doc = getDoctorByID(id)) == null)
            return false;
        return familyDoctors.put(patient,doc) == null;
    }

    /**
     * Removes given patient from the system.
     * @param patient given patient
     * @return given patient if patient is exist. Otherwise null
     */
    public HealthSystemUsers removePatient(Patient patient){ return patients.remove(patient); }

    /**
     * Removes given doctor from the system.
     * @param doctor given doctor
     * @return true if doctor is exist in the system. Otherwise false
     */
    public boolean removeDoctor(Doctor doctor){ return doctors.remove(doctor); }

    /**
     * Removes given nurse from the system.
     * @param nurse given nurse
     * @return true if nurse is exist in the system. Otherwise false
     */
    public boolean removeNurse(Nurse nurse){ return nurses.remove(nurse); }

    /**
     * Removes given pharmacist from the system.
     * @param pharmacist given pharmacist
     * @return true if pharmacist is exist in the system. Otherwise false
     */
    public boolean removePharmacist(Pharmacist pharmacist){ return pharmacists.remove(pharmacist); }

    /**
     * Removes given lab employee from the system.
     * @param labEmployee given lab employee
     * @return true if lab employee is exist in the system. Otherwise false
     */
    public boolean removeLabEmployee(LabEmployee labEmployee){ return labEmployees.remove(labEmployee); }

    /**
     * Removes given patient's family doctor from the system.
     * @param patient given patient
     * @return true if patient has a family doctor. Otherwise false
     */
    public boolean removeFamilyDoctor(Patient patient) { return familyDoctors.remove(patient) != null; }

    /**
     * Returns string representation of the hospital.
     * @return string representation of the hospital
     */
    @Override
    public String toString() { return getHospitalStats(); }
}
