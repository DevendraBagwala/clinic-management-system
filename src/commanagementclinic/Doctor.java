/**
 * This is first Project of Core java i.e, Clinical management system
 * 
 * author @devendra
 */

package commanagementclinic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import comConnection.InsertUpdateDelete;
import comConnection.Select;
//this is Doctor class
public class Doctor {
	private int contactNo;
	private String patientName;
	private String address;
	private String patientDisease;
	private int age;
	private String dateOfAppointment;
	private String timeOfAppointment;
	private String prescription;
	private String notes;
	private String date;
	private int patientId;
	private int appointId;
	private ResultSet r;
	private String Disease;
   //In the particular operations are doctor performed operation i.e, to see list of patient ,add prescription & note and see appointed patient also check history of patient
	public void operations(int doctorId,String doctorName) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);	
	    logger.setLevel(Level.FINE);
	    ConsoleHandler handler = new ConsoleHandler();	
	    handler.setLevel(Level.FINE);
	    logger.addHandler(handler);
		Scanner in = new Scanner(System.in);
		System.out.println("welcome doctor");
		System.out.println("-----------------------Doctor Pannel-------------------------------------------");
		System.out.println("1. List of Patient\n2. ADD prescription and notes for patient\n3. See Appointed Patient\n4. check Patient history and prescription\n5. Back");
		
		int choice = in.nextInt();
		
		switch(choice){
		
		case 1://TO see List of Patient
			System.out.println("data of patient");
			System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n", "PatientId", "PatientName", "Disease","Address","Age","ContactNo");
			
			ResultSet rs = Select.getData("select * from patient");
			try {
				while (rs.next()) {

					int patientId = rs.getInt(1);
					patientName = rs.getString(2);
					address = rs.getString(4);
					Disease = rs.getString(3);
					age = rs.getInt(5);
					contactNo = rs.getInt(6);
					
					System.out.printf("%-22d%-22s%-22s%-22s%-22d%-22d\n", patientId ,patientName,address,Disease,age,contactNo);


				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.log(Level.FINE,e.getMessage());//e.printStackTrace();
			}
			Doctor d = new Doctor();
			d.operations(doctorId,doctorName);
		    
			break;
			
		case 2://To add Prescription & note
			System.out.println("-------Add prescription and note for patient---------");
			System.out.println("Enter  Patient Name to add prescription and notes");
			patientName = in.next();
			
			rs = Select.getData("select * from patient where patientName='"+ patientName +"' ");
			try {
				while (rs.next()) {

					Disease = rs.getString("Disease");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.log(Level.FINE,e.getMessage());//e.printStackTrace();
			}

			System.out.println(" Prescription");
			prescription = in.next();
			
			System.out.println("notes for Patient");
			notes = in.next();
			
			System.out.println("Date of Prescription:");
			date = in.next();
			
		   
			String Query;
		   Query = " insert into doctorprescription values('"+doctorId+"','"+doctorName+"','"+patientName+"','"+Disease+"','"+prescription+"','"+notes+"','"+date+"','"+appointId+"')";
		   InsertUpdateDelete.setData(Query, "Prescription and Notes Added Successfully");
		   
		    d = new Doctor();
			d.operations(doctorId,doctorName);
		   
		 
			break;
			
		case 3://TO see appointed patient
			System.out.println("");
			System.out.printf("%-22s%-22s%-22s%-22s%-22s\n", "PatientName","Disease", "DoctorName", "DateOfAppointment", "TimeOfAppointment");
			rs = Select.getData("select * from appointment where doctorName='"+doctorName+"' ");
			try {
				while (rs.next()) {
					
					patientName = rs.getString("patientName");
					Disease = rs.getString(3);
					doctorName = rs.getString("doctorName");
					dateOfAppointment = rs.getString("dateOfAppointment");
					timeOfAppointment = rs.getString("timeOfAppointment");

					System.out.printf("%-22s%-22s%-22s%-22s%-22s\n", patientName,Disease, doctorName, dateOfAppointment, timeOfAppointment);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.log(Level.FINE,e.getMessage());//e.printStackTrace();
			}
			 d = new Doctor();
			d.operations(doctorId,doctorName);
			
			break;
			
		case 4://check history of patient
			System.out.println("---------------------------------History of Patient---------------------------------");
			System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s%-22s\n","AppointId","Appointed Doctor", "PatientName","Disease", "Prescription","Notes","Date");
			rs = Select.getData("select * from doctorprescription");
	         
			try {
				while (rs.next()) {
					appointId = rs.getInt("appointId");
					doctorName = rs.getString(2);
					patientName = rs.getString(3);
					patientDisease = rs.getString(4);
					prescription = rs.getString("prescription");
					notes = rs.getString("notes");
					date = rs.getString("date");
					
					
					System.out.printf("%-22d%-22s%-22s%-22s%-22s%-22s%-22s\n",appointId,doctorName, patientName,patientDisease, prescription,notes,date);
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.log(Level.FINE,e.getMessage());//e.printStackTrace();
			}
			 d = new Doctor();
			d.operations(doctorId,doctorName);
			
			break;
			
		 case 5://Tojump to doctor panel
			 Login l = new Login();//To jump in login console
			l.login();
			
			break;

		}
	}
}


