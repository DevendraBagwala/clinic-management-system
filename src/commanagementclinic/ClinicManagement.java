/**
 * This is first Project of Core java i.e, Clinical management system
 * 
 * author @devendra
 */
package commanagementclinic;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
//this is clinic Managenment class
public class ClinicManagement {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        //this is user login call
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);	
	    logger.setLevel(Level.FINE);
	    ConsoleHandler handler = new ConsoleHandler();	
	    handler.setLevel(Level.FINE);
	    logger.addHandler(handler);
	    try {
		Login l = new Login();
            l.login();
	    } catch( Exception e) {
	    	logger.log(Level.FINE,e.getMessage());
	    }
	}

}
