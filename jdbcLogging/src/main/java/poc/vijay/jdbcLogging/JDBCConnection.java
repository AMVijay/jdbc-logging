package poc.vijay.jdbcLogging;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class for JDBC Connection
 * @author Vijay
 *
 */
public class JDBCConnection {
	
	private static JDBCConnection jdbcConnection; 
	
	private static final String JDBC_URL = "jdbc:oracle:thin:@tldb1d02.tms.toyota.com:1537:AU4T";
	private static final String USER_NAME = "IPLUS_TEST_FR4_OLTP";
	private static final String PASSWORD = "changeit";
	
	/**
	 * Private Constructor.
	 */
	private JDBCConnection(){
		
	}
	
	/**
	 * Static Method for Instantiation.
	 * @return
	 */
	public static JDBCConnection getInstance(){
		if(jdbcConnection == null){
			jdbcConnection = new JDBCConnection();
		}
		return jdbcConnection;
	}
	
	/**
	 * New Connection Create Method.
	 * @return connection as java.sql.Connection.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Connection connection = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
		return connection;
	}

	/**
	 * Method to close Connection.
	 * @param connection
	 * @throws SQLException 
	 */
	public void closeConnection(Connection connection) throws SQLException{
		if(connection != null){
			connection.close();
		}
	}
}
