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
//This is appointment class
public class MakeAppointment {
	private String patientName;
	private String doctorName;
	//private String patientDisease;
	private String specialization;
	private int doctorFee;
	private String dateOfAppointment;
	private String timeOfAppointment;
	private String Disease;
	private String patientDisease;
  // To make appointment with doctor
	public void appointPatient() {
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);	
	    logger.setLevel(Level.FINE);
	    ConsoleHandler handler = new ConsoleHandler();	
	    handler.setLevel(Level.FINE);
	    logger.addHandler(handler);

		Scanner in = new Scanner(System.in);
		System.out.println("Make appointment for Patient");
		System.out.println("enter Patient Name:");
		patientName = in.next();

		System.out.println("enter doctor Name");
		doctorName = in.next();

		System.out.println("Enter Date of appointment");
		dateOfAppointment = in.next();

		System.out.println("Enter Time of appointment");
		timeOfAppointment = in.next();

		String Query;
		Query = " select patientName, Disease from patient where patientName='" + patientName + "'";
		ResultSet rs = Select.getData(Query);
		try {
			while (rs.next()) {

				patientName = rs.getString("patientName");
				Disease = rs.getString("Disease");


			}
		} catch (SQLException e) {
			logger.log(Level.FINE,e.getMessage());//System.out.println(e);

		}

		Query = " select doctorName, specialization, doctorFee from doctor where doctorName='" + doctorName + "'";
		rs = Select.getData(Query);
		try {
			while (rs.next()) {

				doctorName = rs.getString("doctorName");
				specialization = rs.getString("specialization");
				doctorFee = rs.getInt("doctorFee");


			}
		} catch (SQLException e) {

			logger.log(Level.FINE,e.getMessage());//System.out.println(e);
		}

          // insert patient data to appointment table
		Query = "insert into appointment values(appointId, '" + patientName + "', '" + Disease + "', '" + doctorName
				+ "',  '" + specialization + "', '" + doctorFee + "', '" + dateOfAppointment + "', '"
				+ timeOfAppointment + "')";
		InsertUpdateDelete.setData(Query, "Appointment Booked");
		
		Admin a = new Admin();
		a.operations();

		
	}
}
