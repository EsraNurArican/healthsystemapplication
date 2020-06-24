import HealthSystem.*;

import java.util.*;
public class UserInterface {
	
	
	@SuppressWarnings("static-access")
	public static void menu(Hospital hospital) {
		
		String c1,c2;
		int id;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome Healthy System \n");
		boolean fl=false;
		loop : while(true) {
			System.out.println("Enter HealthSystem.User Type Number\n"
					+ " 1-HealthSystem.Admin\n 2-HealthSystem.Doctor \n 3-HealthSystem.Nurse \n 4-Lab Employee \n 5-HealthSystem.Pharmacist \n 6-HealthSystem.Patient \n 7-Exist");
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
								+ " 1-Add HealthSystem.Patient\n 2-Remove HealthSystem.Patient \n 3-Add HealthSystem.Doctor\n 4-Remove HealthSystem.Doctor \n"
								+ " 5-Add Lab Employee \n 6-Remove Lab Employee \n"
								+ " 7-Add HealthSystem.Nurse\n 8-Remove HealthSystem.Nurse \n 9-Add HealthSystem.Pharmacist\n 10-Remove HealthSystem.Pharmacist\n"
								+ " 11-Edit Personel Data\n 12-Edit Medical Data\n"
								+ " 13-Add Announcement \n 14-Return Main Menu");
						c1=scan.nextLine();
						c1=c1.trim();
						Admin admin=hospital.getAdmin();
						switch (c1) {
						case "1":
							Patient patient = new Patient(null, "", "", null);
							id=patient.getNextID();
							takeData(scan,"patient",hospital,patient,id);
							if(admin.addPatient(patient))
								System.out.println("DONE");
							break;
						
						case "2":
							if(hospital.getPatients().size()==0)
								System.out.println("There is no patient");
							else {
								printPatient(hospital);
								id=takeId(scan, "patient");
								Patient patient1 = hospital.getPatientByID(id);
								if(patient1!=null) {
									admin.removePatient(patient1);
									System.out.println("DONE");
								}
								else
									System.out.println("Invalid ID Number!!!. Try again\n");
							}
							
							break;
							
						
							
						case "3":
							Doctor doctor = new Doctor(null, null, null, null);
							id=doctor.getNextID();
							takeData(scan,"doctor",hospital,doctor,id);
							System.out.print("Enter HealthSystem.Doctor expertise :");
							c1=scan.nextLine();
							c1=c1.trim();
							doctor.setExpertise(c1);
							if(admin.addDoctor(doctor))
								System.out.println("DONE");
							break;
							
						case "4":
							if(hospital.getDoctors().size()==0) {
								System.out.println("There is no doctor");
							}
							else {
								printUser(hospital,hospital.getDoctors());
								id=takeId(scan,"doctor");
								Doctor doctor1=hospital.getDoctorByID(id);
								if(doctor1!=null) {
									admin.removeDoctor(doctor1);
									System.out.println("DONE");
								}
								else
									System.out.println("Invalid ID Number!!!. Try again\n");
							}
							

							break;
						case "5":
							LabEmployee labEmployee = new LabEmployee(null, null, null, null);
							id=labEmployee.getNextID();
							takeData(scan,"lab employee",hospital,labEmployee,id);
							if(admin.addLabEmployee(labEmployee))
								System.out.println("DONE");
							break;
							
						case "6":
							if(hospital.getLabEmployees().size()==0)
								System.out.println("There is no lab employee");
							else {
								printUser(hospital,hospital.getLabEmployees());
								id=takeId(scan,"lab employee");
								LabEmployee labEmployee1 = hospital.getLabEmployeeByID(id);
								if(labEmployee1!=null) {
									admin.removeLabEmployee(labEmployee1);
									System.out.println("DONE");
								}
								else
									System.out.println("Invalid ID Number!!!. Try again\n");
							}
							
							
							break;
							
							
						case "7":
							Nurse nurse = new Nurse(null, null, null, null);
							id=nurse.getNextID();
							takeData(scan,"nurse",hospital,nurse,id);
							if(admin.addNurse(nurse))
								System.out.println("DONE");
						
							break;
							
						case "8":
							if(hospital.getNurses().size()==0)
								System.out.println("There is no lab employee");
							else {
								printUser(hospital,hospital.getNurses());
								id=takeId(scan,"nurse");
								Nurse nurse1 = hospital.getNurseByID(id);
								if(nurse1!=null) {
									admin.removeNurse(nurse1);
									System.out.println("DONE");
								}
								else
									System.out.println("Invalid ID Number!!!. Try again\n");
							}
							
						
							break;
							
						case "9":
							Pharmacist pharmacist = new Pharmacist(null, null, null, null,null);
							
							id=pharmacist.getNextID();
							takeData(scan,"pharmacist",hospital,pharmacist,id);
							System.out.println("Enter pharmacy name");
							c1=scan.nextLine();
							c1=c1.trim();
							pharmacist.setPharmacyName(c1);
							if(admin.addPharmacist(pharmacist))
								System.out.println("DONE");
							break;
							
						case "10":
							if(hospital.getPharmacists().size()==0)
								System.out.println("There is no pharmacist");
							else {
								printUser(hospital,hospital.getPharmacists());
								id=takeId(scan,"pharmacist");
								Pharmacist pharmacist1=hospital.getPharmacistByID(id);
								if(pharmacist1!=null) {
									admin.removePharmacist(pharmacist1);
									System.out.println("DONE");
								}
								else
									System.out.println("Invalid ID Number!!!. Try again\n");
							}
							
							
							
							break;
							
						case "11":
							
							loop7:while(true) {
								System.out.println("Enter HealthSystem.User Type Number:\n 1-HealthSystem.Doctor\n 2-HealthSystem.Nurse\n 3-Lab Employee"
										+ "\n 4-HealthSystem.Pharmacist \n 5-HealthSystem.Patient \n 6-Return HealthSystem.Admin Menu");
								c1=scan.nextLine();
								c1=c1.trim();
								switch (c1) {
								case "1":
									if(hospital.getDoctors().size()==0)
										System.out.println("There is no doctor");
									else {
										printUser(hospital,hospital.getDoctors());
										id=takeId(scan,"doctor");
										Doctor doctor2 = hospital.getDoctorByID(id);
										if(doctor2!=null) {
											System.out.print("Enter New Name : ");
											c1=scan.nextLine();
											c1=c1.trim();
											System.out.println("Enter New Surname : ");
											c2=scan.nextLine();
											c2=c2.trim();
											admin.editPersonalDataName(doctor2, c1);
											admin.editPersonalDataSurname(doctor2, c2);
											System.out.println("DONE");
										}
										else
											System.out.println("Invalid ID Number!!!. Try again\\n");
									}
																
									break;
								case "2":
									if(hospital.getNurses().size()==0)
										System.out.println("There is no nurse");
									else {
										printUser(hospital,hospital.getNurses());
										id=takeId(scan,"nurse");
										Nurse nurse2 = hospital.getNurseByID(id);
										if(nurse2!=null) {
											System.out.print("Enter New Name : ");
											c1=scan.nextLine();
											c1=c1.trim();
											System.out.println("Enter New Surname : ");
											c2=scan.nextLine();
											c2=c2.trim();
											admin.editPersonalDataName(nurse2, c1);
											admin.editPersonalDataSurname(nurse2, c2);
											System.out.println("DONE");
										}
										else
											System.out.println("Invalid ID Number!!!. Try again\n");
									}
									
									
									break;
									
								case "3":
									if(hospital.getLabEmployees().size()==0)
										System.out.println("There is no lab employee");
									else {
										printUser(hospital,hospital.getLabEmployees());
										id=takeId(scan,"lab employee");
										LabEmployee labEmployee2 = hospital.getLabEmployeeByID(id);
										if(labEmployee2!=null) {
											System.out.print("Enter New Name : ");
											c1=scan.nextLine();
											c1=c1.trim();
											System.out.println("Enter New Surname : ");
											c2=scan.nextLine();
											c2=c2.trim();
											admin.editPersonalDataName(labEmployee2, c1);
											admin.editPersonalDataSurname(labEmployee2, c2);
											System.out.println("DONE");
										}
										else
											System.out.println("Invalid ID Number!!!. Try again\n");
									}
									
									
									break;
									
								case "4":
									if(hospital.getPharmacists().size()==0)
										System.out.println("There is no pharmacist");
									else {
										printUser(hospital,hospital.getPharmacists());
										id=takeId(scan,"pharmacist");
										Pharmacist pharmacist2=hospital.getPharmacistByID(id);
										if(pharmacist2!=null) {
											System.out.print("Enter New Name : ");
											c1=scan.nextLine();
											c1=c1.trim();
											System.out.println("Enter New Surname : ");
											c2=scan.nextLine();
											c2=c2.trim();
											admin.editPersonalDataName(pharmacist2, c1);
											admin.editPersonalDataSurname(pharmacist2, c2);
											System.out.println("DONE");
										}
										else
											System.out.println("Invalid ID Number!!!. Try again\n");
									}
									
									
									break;
									
								
								case "5":
									if(hospital.getPatients().size()==0)
										System.out.println("There is no patient");
									else {
										printPatient(hospital);
										id=takeId(scan, "patient");
										Patient patient2 = hospital.getPatientByID(id);
										if(patient2!=null) {
											System.out.print("Enter New Name : ");
											c1=scan.nextLine();
											c1=c1.trim();
											System.out.println("Enter New Surname : ");
											c2=scan.nextLine();
											c2=c2.trim();
											admin.editPersonalDataName(patient2, c1);
											admin.editPersonalDataSurname(patient2, c2);
											System.out.println("DONE");
										}
										else
											System.out.println("Invalid ID Number!!!. Try again\n");
									}
									
									break;
									
								case "6":
									break loop7;
									
								default:
									System.out.println("Invalid operation Number!!!. Try again\n");
									break;
								}
							}
							
						
							
							
							break;
						case "12":
							if(hospital.getPatients().size()==0)
								System.out.println("There is no patient");
							else {
								printPatient(hospital);
								id=takeId(scan, "patient");
								Patient patient2 = hospital.getPatientByID(id);
								if(patient2!=null) {

									System.out.print("Enter Blood Type :");
									c1=scan.nextLine();
									c1=c1.trim();
									admin.editMedicalDataBloodType(patient2, c1);
									System.out.println("DONE");
								}
								else
									System.out.println("Invalid ID Number!!!. Try again\n");
							}
							
							break;
							
						case "13":
							System.out.print("Enter Announcement : ");
							c1=scan.nextLine();
							c1=c1.trim();
							for(int i=0;i<hospital.getDoctors().size();i++) {
								admin.addAnnouncement((Doctor) hospital.getDoctors().get(i), c1);
							}
							break;
							
						case "14":
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
				System.out.print("Enter HealthSystem.User Name :");
				c1=scan.nextLine();
				c1=c1.trim();
				System.out.print("Enter Password :");
				c2=scan.nextLine();
				c2=c2.trim();
				fl=true;;
				for(int i=0;i<hospital.getDoctors().size();i++) {
					if(hospital.getDoctors().get(i).verifyUser(c1, c2)) {
						fl=false;
						Doctor doctor = (Doctor) hospital.getDoctors().get(i);
						System.out.println("Welcome Dr."+doctor.getPersonalData().getName());
						try {
							doctor.printAnnouncement();
						} catch (Exception e) {
							System.out.println("There is no announcement today.");
						}
						
						
						loop2 : while(true) {
							System.out.println("Enter Operation Number : \n 1-Add HealthSystem.Prescription \n "
									+ "2-See Nearby HealthSystem.Appointment\n 3-Get HealthSystem.Patient Data\n 4-Return Main Menu");
							c1=scan.nextLine();
							c1=c1.trim();
							switch (c1) {
							case "1":
								printPatient(hospital);
								
								id=takeId(scan,"patient");
								Patient patient = hospital.getPatientByID(id);
								if(patient!=null) {
									
									System.out.println("Enter HealthSystem.Prescription : ");
									c1=scan.nextLine();
									c1=c1.trim();
									Prescription prescription= new Prescription(c1);
									doctor.addPrescription(patient, prescription);
									System.out.println("DONE");
								}
								else 
									System.out.println("Invalid id number !!! Try again \n");
								
								break;
							
							case "2":
								try {
									if(doctor.getNearbyAppointments()!=null   )
										
										System.out.println(doctor.getNearbyAppointments().toString());
								} catch (Exception e) {
								
										System.out.println("There is no appointment \n");
								}
	
								break;
								
							case "3":
								try {
									printPatient(hospital);
									id=takeId(scan,"patient");
									Patient patient1 = hospital.getPatientByID(id);
									System.out.println(doctor.getPatientData(patient1).toString()); 
									
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
				}
				
				if(fl)
					System.out.println("Wrong login name or password.Try again!!!");
				break;
				
			case "3":
				
				System.out.print("Enter HealthSystem.User Name :");
				c1=scan.nextLine();
				c1=c1.trim();
				System.out.print("Enter Password :");
				c2=scan.nextLine();
				c2=c2.trim();
				fl=true;
				for(int i=0;i<hospital.getNurses().size();i++) {
					if(hospital.getNurses().get(i).verifyUser(c1, c2)) {
						fl=false;
						Nurse nurse  = (Nurse) hospital.getNurses().get(i);
						System.out.println("Welcome HealthSystem.Nurse "+nurse.getPersonalData().getName());
						loop3 : while(true) {
							System.out.println("Enter Operation Number : \n 1-Add Operation \n 2-Return Main Menu");
							c1=scan.nextLine();
							c1=c1.trim();
							switch (c1) {
							case "1":
								printPatient(hospital);
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
				}
				if(fl)
					System.out.println("Wrong login name or password.Try again!!!");
				
					
				break;
				
			case "4":
				System.out.print("Enter HealthSystem.User Name :");
				c1=scan.nextLine();
				c1=c1.trim();
				System.out.print("Enter Password :");
				c2=scan.nextLine();
				c2=c2.trim();
				fl=true;
				for(int i=0;i<hospital.getLabEmployees().size();i++) {
					if(hospital.getLabEmployees().get(i).verifyUser(c1,c2)) {
						LabEmployee labEmployee = (LabEmployee) hospital.getLabEmployees().get(i);
						System.out.println("Welcome "+labEmployee.getPersonalData().getName());
						loop4 : while(true) {
							System.out.println("Enter Operation Number \n 1-Add Test \n 2-Return Main Menu");
							c1=scan.nextLine();
							c1=c1.trim();
							switch(c1)
							{
								case "1":
									printPatient(hospital);
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
					
				}

				
				if(fl)
					System.out.println("Wrong login name or password.Try again!!!");
				
					
				break;
				
			case "5":
				System.out.print("Enter HealthSystem.User Name :");
				c1=scan.nextLine();
				c1=c1.trim();
				System.out.print("Enter Password :");
				c2=scan.nextLine();
				c2=c2.trim();
				fl=true;
				
				for(int i=0;i<hospital.getPharmacists().size();i++) {
					if(hospital.getPharmacists().get(i).verifyUser(c1,c2)) {
						fl=false;
						Pharmacist pharmacist = (Pharmacist) hospital.getPharmacists().get(i);
						System.out.println("Welcome HealthSystem.Pharmacist "+pharmacist.getPersonalData().getName());
						loop5 : while(true) {
							System.out.println("Enter Operation Number \n  1-Get Prepection \n 2-Return Main Menu");
							c1=scan.nextLine();
							c1=c1.trim();
							switch(c1)
							{
							case "1":
								//TODO : pharmacist.getPrespectionById
								break;
							case "2":
								break loop5;
							default :
								System.out.println("Invalid operation Number!!!. Try again\n");
								break;
							}
						
						
						}
						
					}
				}
				
				if(fl)
					System.out.println("Wrong login name or password.Try again!!!");
				
				break;
				
			case "6":
				
				System.out.print("Enter HealthSystem.User Name :");
				c1=scan.nextLine();
				c1=c1.trim();
				System.out.print("Enter Password :");
				c2=scan.nextLine();
				c2=c2.trim();
				fl=true;
				for(Map.Entry<HealthSystemUsers,HealthSystemUsers> entry : hospital.getPatients().entrySet()) {
					if(entry.getKey().verifyUser(c1,c2)) {
						Patient patient = (Patient) entry.getKey();
						System.out.println("Welcome  "+patient.getPersonalData().getName());
						loop6 : while(true) {
							System.out.print("Enter Operation Number \n 1-See Medical Data \n "
									+ "2-See Appointments \n 3-Take HealthSystem.Appointment \n 4-Return Main Menu");
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
								if(patient.getAppointments()!=null) {
									for(int i=0;i<patient.getAppointments().size();i++) {
										System.out.println(patient.getAppointments().get(i).toString());
									}
									if(patient.getAppointments().size()==0)
										System.out.println("There is no appointment");
									
								}
								
								break;
								
							case "3":
									printUser(hospital,hospital.getDoctors());
									id=takeId(scan,"doctor");
									Doctor doctor=hospital.getDoctorByID(id);
									if(doctor!=null) {
										doctor.appointmentDialogue(patient);
									}
									else
										System.out.println("Invalid ID number.Try again!!!");
								
								break;
								
							case "4":
								
								break loop6;
							default :
								System.out.println("Invalid operation Number!!!. Try again\n");
								break;
							}
						}
					}
				}
				
				if(fl)
					System.out.println("Wrong login name or password.Try again!!!");
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
	
	
	/**
	 * Take ID number method
	 * @param scan Scanner
	 * @param type HealthSystem.User type
	 * @return ID number
	 */
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
	
	/** Take user data method.
	 * @param scan Scanner
	 * @param type HealthSystem.User type
	 * @param hospital HealthSystem.Hospital class
	 * @param user HealthSystem.User class
	 * @param id ID number
	 */
	private static void takeData(Scanner scan,String type,Hospital hospital,User user,int id) {
		String name,surname,loginName,password;

		
		
		System.out.print("Enter "+type+" name : ");
		name = scan.nextLine();
		name=name.trim();
		System.out.print("Enter "+type+" surname : ");
		surname= scan.nextLine();
		surname=surname.trim();
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
	/** Print patient information method.
	 * @param hospital HealthSystem.Hospital class
	 */
	private static void printPatient(Hospital hospital) {
		System.out.println("ID\tNAME\tSURNAME");
		for(Map.Entry<HealthSystemUsers,HealthSystemUsers> entry : hospital.getPatients().entrySet()) {
			System.out.println(entry.getKey().getPersonalData().getID() +"\t"
			+entry.getKey().getPersonalData().getName()+"\t"
			+entry.getKey().getPersonalData().getSurname());
		}
		
	}
	/** Print user information method.
	 * @param hospital HealthSystem.Hospital class
	 * @param user HealthSystem.User class
	 */
	private static void printUser(Hospital hospital,ArrayList<HealthSystemUsers> user) {
		System.out.println("ID\tNAME\tSURNAME");
		for(int i=0;i<user.size();i++) {
			System.out.println(user.get(i).getPersonalData().getID()+"\t"
					+user.get(i).getPersonalData().getName()+"\t"
					+user.get(i).getPersonalData().getSurname());
		}
		
	}
	
	

	
}
