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
//This is patient Class
public class Patient {
	int patientId;
	String patientName;
	String address;
	String Disease;
	Integer age;
	Integer contactNo;
    // Admin can perform operation i.e,add patient ,update patient, see patient data and delete patient data
	public void operations() {
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);	
	    logger.setLevel(Level.FINE);
	    ConsoleHandler handler = new ConsoleHandler();	
	    handler.setLevel(Level.FINE);
	    logger.addHandler(handler);

		Scanner in = new Scanner(System.in);
		System.out.println("1. Add Patient\n2. Update Patient data\n3. See Patient List\n4. Delete Patient\n5. Back");
		System.out.println("Enter choice:");

		int choice = in.nextInt();
	
		switch (choice) {

		case 1:// To add Patient data
			
			System.out.println("Enter Name:");
			patientName = in.next();

			System.out.println("Enter Address:");
			address = in.next();

			System.out.println("Enter Disease:");
			Disease = in.next();

			System.out.println("Enter Age:");
			age = in.nextInt();

			System.out.println("Enter Contact Number:");
			contactNo = in.nextInt();

			if (patientName.equals("") || address.equals("") || Disease.equals("") || age.equals("")
					|| contactNo.equals("")) {

				System.out.println("All fields are mandadatary This is required field ");
			} else {

				String Query;
				Query = "insert into patient values(patientId,'" + patientName + "', '" + address + "', '" + Disease + "', '"
						+ age + "', '" + contactNo + "')";
				InsertUpdateDelete.setData(Query, "Patient data added succesfully");
			}
			break;

		case 2://To update Patient data
			System.out.println("Enter id:");
			patientId = in.nextInt();
			
			System.out.println("Enter Name:");
			patientName = in.next();

			System.out.println("Enter Address:");
			address = in.next();

			System.out.println("Enter Disease:");
			Disease = in.next();

			System.out.println("Enter Age:");
			age = in.nextInt();

			System.out.println("Enter Contact Number:");
			contactNo = in.nextInt();
			
			String Query;
			Query = "update patient set patientName='" + patientName + "', address='" + address + "', Disease='" + Disease + "', age='"
					+ age + "', contactNo='" + contactNo + "' where patientId='"+patientId+"'";
			InsertUpdateDelete.setData(Query, "Patient data updated  succesfully");
			
			break;
			

		case 3://To see Patient list

			System.out.println("data of patient");
			System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n", "Id", "PatientName", "Address","Disease","Age","ContactNo");

			ResultSet rs = Select.getData("select * from patient");
			try {
				while (rs.next()) {

					int patientId = rs.getInt("patientId");
					patientName = rs.getString("patientName");
					address = rs.getString("address");
					Disease = rs.getString("Disease");
					age = rs.getInt("age");
					contactNo = rs.getInt("contactNo");

					System.out.printf("%-22d%-22s%-22s%-22s%-22d%-22d\n", patientId,patientName,address,Disease,age,contactNo);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.log(Level.FINE,e.getMessage());//e.printStackTrace();
			}
			break;

		case 4://To delete Patient data
			System.out.println("Enter id:");
			patientId = in.nextInt();
			
			System.out.println("Delete patient data \n press Y for yes and N for no:");
			char ch = in.next().charAt(0);
			if(ch=='Y'){
				
			
				Query = "delete from patient where patientId = '"+patientId+"'";
				InsertUpdateDelete.setData(Query, "Patient data deleted");
				
			}
			break;
				

		case 5:// Jump to Admin login Panel
			
			Admin a = new Admin();
			a.operations();
			break;

		}
	}
}
