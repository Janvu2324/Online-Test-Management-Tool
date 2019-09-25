import java.sql.*;
import javax.swing.JOptionPane;

public class JDBC {

	public static Connection dbconnect() // throw the Exception 
	{
		// TODO Auto-generated method stub
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver"); //loading a driver Connection is a Interface it declares null value
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","TEST","TEST"); //getconnection is called that drivermanager will attempt to locate a suitable driver
		return conn;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);// connection is not null then establishing the connection using if-else statement
		    return null;
		}	

	}

}
