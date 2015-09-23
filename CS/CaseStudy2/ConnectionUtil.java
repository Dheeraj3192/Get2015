import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	
	public static Connection getConnection() 
	{
		/* register driver */
		ReadConnectionAttributes readConnectionAttributes = new ReadConnectionAttributes();
		readConnectionAttributes.parseXmlFile();
		readConnectionAttributes.parseDocument();
		ConnectionAttributes connectionAttributes = readConnectionAttributes.getConnectionAttributes();
		Connection connection = null;	
		try
		{
			Class.forName(connectionAttributes.getDriver());
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Class not found Exception");
			System.exit(1);
		}
		
		/* open connection */
		try 
		{
			connection = DriverManager.getConnection(connectionAttributes.getUrl().trim(), connectionAttributes.getUsername().trim(),connectionAttributes.getPassword().trim());
		}
		catch (SQLException e) 
		{
			System.out.println("SQL exception Occured ");
			System.exit(1);
		}
		
		return connection;
	}
	
}
