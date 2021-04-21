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
//In this class Doctor operation are performed
public class DoctorOperate {
	int doctorId;
	String doctorName;
	String email;
	String degree;
	String specialization;
	String doctorFee;
	String address;
	String contactNo;
	

    // Admin performed following operation  on doctor i.e, add,update,see doctor list,delete doctor data 
	public void operations() {
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);	
	    logger.setLevel(Level.FINE);
	    ConsoleHandler handler = new ConsoleHandler();	
	    handler.setLevel(Level.FINE);
	    logger.addHandler(handler);
		
		Scanner in = new Scanner(System.in);
		System.out.println("1. Add Doctor\n2. Update Doctor data\n3. See Doctor List\n4. Delete Doctor\n5. Back");
		System.out.println("Enter choice:");

		int choice = in.nextInt();
		
		switch(choice){
		
		
		case 1://To add doctor data
			System.out.println("Enter Doctor Name:");
			doctorName = in.next();

			System.out.println("Enter Email Id:");
			email = in.next();

			System.out.println("Enter Degree Name:");
			degree = in.next();

			System.out.println("Enter Specialization of doctor:");
			specialization = in.next();

			System.out.println("Enter fees of doctor:");
			doctorFee = in.next();
			
			System.out.println("Enter address of doctor:");
			address = in.next();
			
			System.out.println("Enter Contact Number:");
			contactNo = in.next();
			
			if (doctorName.equals("") || email.equals("") || degree.equals("") || specialization.equals("") || doctorFee.equals("") || address.equals("")
					|| contactNo.equals("")) {

				System.out.println("All fields are mandatory");
				
			}else{
				
				String Query;
				Query = "insert into doctor values(doctorId,'" + doctorName + "', '" + email + "', '" + degree + "', '"+ specialization + "', '"+ doctorFee + "','"+ address + "', '" + contactNo + "')";
				InsertUpdateDelete.setData(Query, "Doctor data added succefully");
			}
			
			 break;
			 
		case 2://To update doctor data
			System.out.println("Enter id:");
			doctorId = in.nextInt();
			
			System.out.println("Enter Doctor Name:");
			doctorName = in.next();

			System.out.println("Enter Email Id:");
			email = in.next();

			System.out.println("Enter Degree Name:");
			degree = in.next();

			System.out.println("Enter Specialization of doctor:");
			specialization = in.next();

			System.out.println("Enter fees of doctor:");
			doctorFee = in.next();
			
			System.out.println("Enter address of doctor:");
			address = in.next();
			
			System.out.println("Enter Contact Number:");
			contactNo = in.next();
			
			String Query;
			Query = "update doctor set doctorName='" + doctorName + "', email='" + email + "', degree='" + degree + "', specialization='"+ specialization + "', doctorFee='"+ doctorFee + "', address='"+ address + "', contactNo='" + contactNo + "' where doctorId='"+doctorId+"' ";
			InsertUpdateDelete.setData(Query, "Doctor data updated succefully");
			break;


		case 3: // To see doctor list data
			System.out.println("Data of Doctors");
			System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s%-22s%-22s\n", "DoctorId", "DoctorName", "email","Degree","specialization","doctorFee","Address", "ContactNo");


			ResultSet rs = Select.getData("select * from doctor");
			try {
				while (rs.next()) {

					doctorId = rs.getInt("doctorId");
					doctorName = rs.getString("doctorName");
					email = rs.getString("email");
					degree = rs.getString("degree");
					specialization = rs.getString("specialization");
					doctorFee = rs.getString("doctorFee");
					address = rs.getString("address");
					contactNo = rs.getString("contactNo");
					
					System.out.printf("%-22d%-22s%-22s%-22s%-22s%-22s%-22s%-22s\n", doctorId,doctorName,email,degree,specialization,doctorFee,address,contactNo);


				}
			} catch (SQLException e) {
				
				logger.log(Level.FINE,e.getMessage());//System.out.println(e);
			}
			break;
		
		case 4:  // To Remove  doctor data
			System.out.println("Enter id:");
			doctorId = in.nextInt();
			
			System.out.println("Delete doctor data \n press Y for yes and N for no:");
			char ch = in.next().charAt(0);
			if(ch=='Y'){
				
			
				Query = "delete from doctor where doctorId = '"+doctorId+"'";
				InsertUpdateDelete.setData(Query, "Doctor data deleted");
				
			}
			break;
			
		case 5://Jump  to Admin login panel
			Admin a = new Admin();
			a.operations();
			break;


		}

		
	}
}
