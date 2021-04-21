/**
 * This is first Project of Core java i.e, Clinical management system
 * 
 * author @devendra
 */

package commanagementclinic;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
// this is Admin Class
public class Admin {
 //In this method Admin perform operation on patient,doctor,drug,lab-test, make-appointment for patient related works         
public void operations(){
	    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);	
	    logger.setLevel(Level.FINE);
	    ConsoleHandler handler = new ConsoleHandler();	
	    handler.setLevel(Level.FINE);
	    logger.addHandler(handler);
			
		Scanner in = new Scanner(System.in);
		System.out.println("------------------------Admin Pannel-------------------------");
		System.out.println("1. Patient\n2. Doctor\n3. Drugs\n4. Lab Test\n5. Make appointment\n6.Back");
		int choice =  in.nextInt();
		while(true){
		switch(choice){
		
		case 1:
			Patient p = new Patient();//In this case Patient operations are performed by Admin
			p.operations();
			break;
			
		case 2:
			DoctorOperate dO = new DoctorOperate();//In this case Doctor operations are performed by Admin
			dO.operations();
			break;
			
		case 3:
			Drugs ds = new Drugs();//In this case drug operations are performed by Admin
			ds.operations();
			break;
			
		case 4:
			LabTest lt =new LabTest();//In this case lab operations are performed by Admin
			lt.operations();
			break;
			
		case 5:
			MakeAppointment ma = new MakeAppointment();//In this case appointment operations are performed by Admin
			ma.appointPatient();
			break;
			
		case 6:
			Login l = new Login();//To jump in login console
			l.login();
			break;
			
			
			
		}
	}
	}
}
