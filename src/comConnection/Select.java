/**
 * This is first Project of Core java i.e, Clinical management system
 * 
 * author @devendra
 */
package comConnection;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
//class for selection
public class Select {
	public static ResultSet getData(String query) {
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);	
	    logger.setLevel(Level.FINE);
	    ConsoleHandler handler = new ConsoleHandler();	
	    handler.setLevel(Level.FINE);
	    logger.addHandler(handler);

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = ConnectionProvider.getCon();
			st = con.createStatement();
			rs = st.executeQuery(query);
			return rs;

		} catch (Exception e) {

			logger.log(Level.FINE,e.getMessage());//System.out.println(e);
			return null;
		}

	}
}
