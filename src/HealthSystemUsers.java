/**
 * User interface for Health System Application
 */
public interface HealthSystemUsers extends Comparable<HealthSystemUsers> {
    public Boolean verifyUser(String name,String verifyPassword);
    public  PersonalData getPersonalData();
}