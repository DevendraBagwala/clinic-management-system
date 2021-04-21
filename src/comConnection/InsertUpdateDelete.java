/**
 * This is first Project of Core java i.e, Clinical management system
 * 
 * author @devendra
 */
package comConnection;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
//class is used for insert update And delete data from database
public class InsertUpdateDelete {
public static void setData(String Query, String msg){
	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);	
    logger.setLevel(Level.FINE);
    ConsoleHandler handler = new ConsoleHandler();	
    handler.setLevel(Level.FINE);
    logger.addHandler(handler);
	    
        Connection con=null;
        Statement st=null;
        try{
            con=ConnectionProvider.getCon();
            st=con.createStatement();
            st.executeUpdate(Query);
            
            if(!msg.equals("")){
                
            	System.out.println(msg);
            }
            
        }catch(Exception e){
        	
        	logger.log(Level.FINE,e.getMessage());//System.out.println(e);
        }
        finally{
        
            try{
            }catch(Exception e){
            }
        }
    }
}
