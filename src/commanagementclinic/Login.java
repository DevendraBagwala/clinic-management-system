/**
 * This is first Project of Core java i.e, Clinical management system
 * 
 * author @devendra
 */

package commanagementclinic;
import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import comConnection.Select;
//This is login class 
public class Login {
	String userName;
	String password;
     //This method take input as username and password from user to access  doctor/Admin  login panel
	public void login() {
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);	
	    logger.setLevel(Level.FINE);
	    ConsoleHandler handler = new ConsoleHandler();	
	    handler.setLevel(Level.FINE);
	    logger.addHandler(handler);

		Scanner in = new Scanner(System.in);
		System.out.println("------------------------Login Pannel---------------------------------");
		System.out.println("1. Admin\n2. Doctor\n3. Exit");

		int choice = in.nextInt();
		while(true){
		switch (choice) {

		case 1://Admin Login and operation 

			System.out.println("Enter Username:");
			userName = in.next();

			System.out.println("Enter Password:");
			password = in.next();

			if (userName.equals("dev") && password.equals("123")) {

				System.out.println("Login Succefully");
				Admin a = new Admin();
				try {
					a.operations();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("Incorrect username or passsword");
			}
			break;

		case 2://Doctor login  and  it' s operation
			

			System.out.println("Enter Username:");
			userName = in.next();

			System.out.println("Enter Password:");
			password = in.next();

			int check = 0;

			ResultSet rs = Select.getData("select * from doctor");
			try {
				while (rs.next()) {

					int doctorId = rs.getInt(1);
					String doctorName = rs.getString(2);
					String email = rs.getString(3);
					

					if (userName.equals(doctorName) && password.equals(email)) {

						check = 1;
						Doctor d = new Doctor();
						d.operations(doctorId,doctorName);

					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.log(Level.FINE,e.getMessage());//e.printStackTrace();
			}
			if(check==0){
				System.out.println("Incorrect username or password");
			}

			break;

		case 3:// exit from program
			System.exit(0);
		}
}
}
}
