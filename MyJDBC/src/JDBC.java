import java.sql.*;

public class JDBC {

	public static void main(String[] args) throws Exception // throw the Exception 
	{
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver"); //loading a driver 
		Connection conn=null; //Connection is a Interface it declares null value
		conn= (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","HP","janu9638471151"); //getconnection is called that drivermanager will attempt to locate a suitable driver
		if(conn!=null) // connection is not null then establishing the connection using if-else statement
			System.out.println("Established Connection");
		else
			System.out.println("Not Established Connection");
		conn.close();

	}

}
