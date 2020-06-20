public class Prescription {
    private String medications; // The prescription text as string
    
    /**
     * Creates prescription with given string
     * @param medications
     */
    Prescription(String medications){
        this.medications=medications;
    }
    /**
     * Returns medications string
     * @return
     */
    public String getMedications() {
        return medications;
    }
    public String toString(){
        return getMedications();
    }

}
