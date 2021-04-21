/**
 * This is first Project of Core java i.e, Clinical management system
 * 
 * author @devendra
 */

package comConnection;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
// class for connection 
public class ConnectionProvider {
public static Connection getCon(){
	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);	
    logger.setLevel(Level.FINE);
    ConsoleHandler handler = new ConsoleHandler();	
    handler.setLevel(Level.FINE);
    logger.addHandler(handler);
	
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql:///clinic","root","");
            return con;
        
        }catch(Exception e){
        	logger.log(Level.FINE,e.getMessage()); 
            return null;
        }    
    }
}
