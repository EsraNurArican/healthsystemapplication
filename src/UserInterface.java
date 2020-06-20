package project;
import java.util.*;
public class UserInterface {
	
	
	public static void menu(Hospital hospital) {
		
		String c1;
		int id;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome Healthy System \n");
		
		loop : while(true) {
			System.out.println("Enter User Type Number\n"
					+ " 1-Admin\n 2-Doctor \n 3-Nurse \n 4-Lab Employee \n 5-Pharmacist \n 6-Patient \n 7-Exist");
			c1=scan.nextLine();
			c1=c1.trim();
			switch (c1) {
			case "1":
				System.out.print("Enter Password");
				c1=scan.nextLine();
				c1=c1.trim();
				c1=c1.toLowerCase();
				
				if(c1.equals(hospital.getAdmin().getPassword())) {
					System.out.println("Welcome admin\n");
					loop1 : while(true) {
						System.out.println("Enter Operation Number\n"
								+ " 1-Add Patient\n 2-Add Doctor\n 3-Add Lab Employee \n "
								+ "4-Add Nurse\n 5-Add Pharmacist\n 6-Edit Personel Data\n 7-Edit Medical Data\n"
								+ " 8-Return Main Menu\n");
						c1=scan.nextLine();
						c1=c1.trim();
						Admin admin=hospital.getAdmin();
						switch (c1) {
						case "1":
							Patient patient = new Patient(null, "", "", null);
							takeData(scan,"patient",hospital,patient);
							if(admin.addPatient(patient))
								System.out.println("DONE");
							break;
						case "2":
							Doctor doctor = new Doctor(null, null, null, null);
							takeData(scan,"doctor",hospital,doctor);
							System.out.print("Enter Doctor expertise :");
							c1=scan.nextLine();
							c1=c1.trim();
							doctor.setExpertise(c1);
							if(admin.addDoctor(doctor))
								System.out.println("DONE");
							

							break;
						case "3":
							LabEmployee labEmployee = new LabEmployee(null, null, null, null);
							takeData(scan,"lab employee",hospital,labEmployee);
							if(admin.addLabEmployee(labEmployee))
								System.out.println("DONE");
							
							
							break;
						case "4":
							Nurse nurse = new Nurse(null, null, null, null);
							takeData(scan,"nurse",hospital,nurse);
							if(admin.addNurse(nurse))
								System.out.println("DONE");
						
						
							break;
						case "5":
							Pharmacist pharmacist = new Pharmacist(null, null, null, null);
							takeData(scan,"pharmacist",hospital,pharmacist);
							if(admin.addPharmacist(pharmacist))
								System.out.println("DONE");
						
							
							break;
						case "6":
							
							//TODO : admin edit personal data
							break;
						case "7":
						//	temp.editMedicalData(new Patient(personalData, loginName, password, hospital));
							//TODO : admin add edit medical data
							break;
						case "8":
							break loop1;
						
						default:
							System.out.println("Invalid operation Number!!!. Try again\n");
							break;
						}
					}
					
					
				}
				else {
					System.out.println("Wrong Password !!! \n");
					
				}
					
				
				
				break;
			
			case "2":
				
				
				id = takeId(scan,"doctor");
				Doctor doctor = hospital.getDoctorByID(id);
				if(doctor!=null) {
					System.out.print("Enter Password :");
					c1=scan.nextLine();
					c1=c1.trim();
					if(c1.equals(doctor.getPassword())) {
						System.out.println("Welcome Dr."+doctor.getPersonalData().getName());
						loop2 : while(true) {
							System.out.println("Enter Operation Number : \n 1-Add Prescription \n "
									+ "2-See Nearby Appointment\n 3-Get Patient Data\n 4-Return Main Menu");
							c1=scan.nextLine();
							c1=c1.trim();
							switch (c1) {
							case "1":
								
								id=takeId(scan,"patient");
								Patient patient = hospital.getPatientByID(id);
								if(patient!=null) {
									// TODO : will be arranged according to the Prescription
									Prescription prescription= new Prescription();  
									doctor.addPrescription(patient, prescription);
									System.out.println("DONE");
								}
								else 
									System.out.println("Invalid id number !!! Try again \n");
								
								break;
							
							case "2":
								try {
									if(doctor.getNearbyAppointments()!=null   )
										//TODO : Appointment toString
										System.out.println(doctor.getNearbyAppointments().toString());
								} catch (Exception e) {
								
										System.out.println("There is no appointment \n");
								}
	
								break;
								
							case "3":
								try {
								
									id=takeId(scan,"patient");
									Patient patient1 = hospital.getPatientByID(id);
									System.out.println(doctor.getPatientData(patient1).toString()); //TODO : Medical data toString
									
								} catch (Exception e) {
									System.out.println("There is no patient \n");
								}
								
								break;
							case "4":
								break loop2;
								
							default:
								System.out.println("Invalid operation Number!!!. Try again\n");
								break;
							}
							
							
						}
					}
					else
						System.out.println("Wrong Password!!! Try Again \n");
					
					
					
				}
				else
					System.out.println("Invalid ID number!!! Try again\n");
				break;
				
			case "3":

				id=takeId(scan,"Nurse");
				Nurse nurse = hospital.getNurseByID(id);
				if(nurse!=null) {
					System.out.print("Enter Password :");
					c1=scan.nextLine();
					c1=c1.trim();
					if(c1.equals(nurse.getPassword())) {
						System.out.println("Welcome Nurse "+nurse.getPersonalData().getName());
						loop3 : while(true) {
							System.out.println("Enter Operation Number : \n 1-Add Operation \n 2-Return Main Menu");
							c1=scan.nextLine();
							c1=c1.trim();
							switch (c1) {
							case "1":
								
								id=takeId(scan,"patient");
								Patient patient = hospital.getPatientByID(id);
								if(patient!=null) {
									System.out.print("Enter Operation : ");
									c1=scan.nextLine();
									c1=c1.trim();
									nurse.addOperation(patient, c1);
									System.out.println("DONE");
								}
								else
									System.out.println("Invalid ID number!!! Try again\n");
								break;
							
							case "2":
								break loop3;
							default:
								System.out.println("Invalid operation Number!!!. Try again\n");
								break;
							}
							
						}
					}
					else
						System.out.println("Wrong Password!!! Try Again \n");
				}
				else
					System.out.println("Invalid ID number!!! Try again\n");
				
					
				break;
				
			case "4":
				

				id=takeId(scan,"Lab Employee");
				LabEmployee labEmployee = hospital.getLabEmployeeByID(id);
				if(labEmployee!=null) {
					System.out.print("Enter Password :");
					c1=scan.nextLine();
					c1=c1.trim();
					if(c1.equals(labEmployee.getPassword())) {
						System.out.println("Welcome "+labEmployee.getPersonalData().getName());
						loop4 : while(true) {
							System.out.println("Enter Operation Number \n 1-Add Test \n 2-Return Main Menu");
							c1=scan.nextLine();
							c1=c1.trim();
							switch(c1)
							{
								case "1":
									
									id=takeId(scan,"patient");
									Patient patient = hospital.getPatientByID(id);
									if(patient!=null) {
										System.out.print("Enter Operation : ");
										c1=scan.nextLine();
										c1=c1.trim();
										labEmployee.addTest(patient,c1);
										System.out.println("DONE");
									}
									else
										System.out.println("Invalid id number !!! Try again \n");
									break;
								case "2":
										
									break loop4;
								default:
									System.out.println("Invalid operation Number!!!. Try again\n");
									break;
							}
							
						}
						
					}
					else
						System.out.println("Wrong Password!!! Try Again \n");
				}
				else
					System.out.println("Invalid ID number!!! Try again\n");
				
					
				break;
				
			case "5":
				id=takeId(scan,"Pharmacist");
				Pharmacist pharmacist = hospital.getPharmacistByID(id);
				if(pharmacist!=null) {
					System.out.print("Enter Password :");
					c1=scan.nextLine();
					c1=c1.trim();
					if(c1.equals(pharmacist.getPassword())) {
						System.out.println("Welcome Pharmacist "+pharmacist.getPersonalData().getName());
						loop4 : while(true) {
							System.out.println("Enter Operation Number \n  1-Get Prepection \n 2-Return Main Menu");
							c1=scan.nextLine();
							c1=c1.trim();
							switch(c1)
							{
							case "1":
								//TODO : pharmacist.getPrespectionById
								break;
							case "2":
								break loop4;
							default :
								System.out.println("Invalid operation Number!!!. Try again\n");
								break;
							}
						
						
						}
					}
					else
						System.out.println("Wrong Password!!! Try Again \n");

				}
				else
					System.out.println("Invalid ID number!!! Try again\n");
				
				break;
				
			case "6":
				
				id=takeId(scan,"Patient");
				Patient patient = hospital.getPatientByID(id);
				if(patient!=null) {
					System.out.print("Enter Password :");
					c1=scan.nextLine();
					c1=c1.trim();
					if(c1.equals(patient.getPassword())) {
						System.out.println("Welcome  "+patient.getPersonalData().getName());
						loop5 : while(true) {
							System.out.print("Enter Operation Number \n 1-See Medical Data \n "
									+ "2-See Appointments \n 3-Return Main Menu");
							c1=scan.nextLine();
							c1=c1.trim();
							switch(c1)
							{
							case "1":
								if(patient.getMedicalData()!=null)
									System.out.println(patient.getMedicalData().toString());
								else
									System.out.println("No medical data has been created yet");
								break;
							case "2":
								patient.getAppointments();//TODO : get appointment for print all appointment
								
								break;
							case "3":
								
								break loop5;
							default :
								System.out.println("Invalid operation Number!!!. Try again\n");
								break;
							}
						}
					}
					else
						System.out.println("Wrong Password!!! Try Again \n");
				}
				else
					System.out.println("Invalid ID number!!! Try again\n");
				break;	
				
			case "7":
				System.out.println("Program end");
				break loop;
				
			default:
				System.out.println("Invalid operation Number!!!. Try again\n");
				break;
			}
		}
		
		scan.close();
	}
	
	
	private static int takeId(Scanner scan,String type) {
		
		String strid;
		int id;
		while(true) {
		
			System.out.print("Enter "+type+" ID number : ");
			strid= scan.nextLine();
			strid=strid.trim();
			
			try {
			   id = Integer.parseInt(strid);
			   return id;
			}
			catch (NumberFormatException e)
			{
			   System.out.println("Please enter a number !!\n");
			}
			
		}
		
	}
	
	public static void takeData(Scanner scan,String type,Hospital hospital,User user) {
		String name,surname,loginName,password;
		int id;
		
		
		System.out.print("Enter "+type+" name : ");
		name = scan.nextLine();
		name=name.trim();
		System.out.print("Enter "+type+" surname : ");
		surname= scan.nextLine();
		surname=surname.trim();
		id=takeId(scan,type);
		System.out.print("Enter "+type+" login name : ");
		loginName = scan.nextLine();
		loginName=loginName.trim();
		System.out.print("Enter "+type+" password : ");
		password=scan.nextLine();
		password=password.trim();
		
		user.setHospital(hospital);
		user.setLoginName(loginName);
		user.setPassword(password);
		user.setPersonalData(new PersonalData(name, surname, id));
		
		
	}

	
}
