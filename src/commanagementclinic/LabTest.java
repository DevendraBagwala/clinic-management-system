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
//This is Lab class
public class LabTest {
	int testId;
	String testName;
	Integer testRate;
   // following operation are performed by Admin i.e,Add,update,see,delete test data
	public void operations() {
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);	
	    logger.setLevel(Level.FINE);
	    ConsoleHandler handler = new ConsoleHandler();	
	    handler.setLevel(Level.FINE);
	    logger.addHandler(handler);

		Scanner in = new Scanner(System.in);
		System.out.println("1. Add Test\n2. Update Test data\n3. See Test List\n4. Delete Test Data\n5. Back");
		System.out.println("Enter choice:");

		int choice = in.nextInt();
		switch (choice) {

		case 1:// To add LabTest
			System.out.println("Enter Test Name:");
			testName = in.next();

			System.out.println("Enter Rate of Test:");
			testRate = in.nextInt();

			if (testName.equals("") || testRate.equals("")) {

				System.out.println("All fields are mandadatary");

			} else {

				String Query;
				Query = "insert into labtest values(testId, '" + testName + "', '" + testRate + "')";
				InsertUpdateDelete.setData(Query, "Lab Test Data added successfully");
			}
			break;

		case 2:// To update LabTest
			System.out.println("Enter Test id:");
			testId = in.nextInt();

			System.out.println("Enter Test Name:");
			testName = in.next();

			System.out.println("Enter Rate of Test:");
			testRate = in.nextInt();

			String Query;
			Query = "update labtest set testName='" + testName + "', testRate='" + testRate + "' where testId='"
					+ testId + "'";
			InsertUpdateDelete.setData(Query, "Test data updated successfully");

			break;

		case 3:// TO see LAb test data
			System.out.println("Data of Doctors");
			System.out.printf("%-22s%-22s%-22s\n", "TestId", "TestName", "TestRate");

			ResultSet rs = Select.getData("select * from labtest");
			try {
				while (rs.next()) {

					testId = rs.getInt(1);
					testName = rs.getString(2);
					testRate = rs.getInt(3);

					System.out.printf("%-22d%-22s%-22d\n", testId, testName, testRate);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.log(Level.FINE,e.getMessage());//e.printStackTrace();
			}
			break;
			
		case 4:// To delete LAbTestdata
			System.out.println("Enter Test id:");
			testId = in.nextInt();
			
			System.out.println(" Delete test data \n press Y for yes and N for no:");
			char ch = in.next().charAt(0);
			if(ch=='Y'){
				
			
				Query = "delete from labtest where testId = '"+testId+"'";
				InsertUpdateDelete.setData(Query, "Test data deleted");
				
			}
			break;
			
		case 5:// Jump Admin Login Panel
			Admin a = new Admin();
			a.operations();
			break;
	
			

		}

	}
}
