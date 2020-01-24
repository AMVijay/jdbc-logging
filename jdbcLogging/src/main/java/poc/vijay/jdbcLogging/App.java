package poc.vijay.jdbcLogging;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        try {
        	JDBCConnection jdbcConnection = JDBCConnection.getInstance();        
			Connection connection = jdbcConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from locality where locality_cd = ?1");
			preparedStatement.setString(1, "110");
			ResultSet resultSet = preparedStatement.getResultSet();
			resultSet.close();
			preparedStatement.close();
			jdbcConnection.closeConnection(connection);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
