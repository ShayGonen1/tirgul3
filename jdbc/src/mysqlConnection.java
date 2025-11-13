import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class mysqlConnection {

	public static void main(String[] args) 
	{
		
        try 
        {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab3db?allowLoadLocalInfile=true&serverTimezone=Asia/Jerusalem&useSSL=false", "root", "danhessen");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.3.68/test","root","Root");

            System.out.println("SQL connection succeed");
            System.out.println("*****ALL THE FLIGHTS*****");
            printFlights(conn);
            System.out.println("*****ALL THE FLIGHTS TO MANCHESTER*****");
            printFlightsToManchester(conn);
            System.out.println("*****UPDATE FLIGHT KU101 GATE TO 2*****");
            updateFlightKU101(conn);
     	} catch (SQLException ex) 
     	    {/* handle any errors*/
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            }
   	}
	
	public static void printFlights(Connection con)
	{
		Statement stmt;
		try 
		{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM flights;");
	 		while(rs.next())
	 		{
				 // Print out the values
				 System.out.println(rs.getString(1)+"  " +rs.getString(2)+"  " +rs.getString(3)+"  " +rs.getString(4)+"  " +rs.getString(5));
			} 
			rs.close();
			//stmt.executeUpdate("UPDATE course SET semestr=\"W08\" WHERE num=61309");
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	public static void printFlightsToManchester(Connection con)
	{
		Statement stmt;
		try 
		{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM flights WHERE (destination = 'Manchester');");
	 		while(rs.next())
	 		{
				 // Print out the values
				 System.out.println(rs.getString(1)+"  " +rs.getString(2)+"  " +rs.getString(3)+"  " +rs.getString(4)+"  " +rs.getString(5));
			} 
			rs.close();
			//stmt.executeUpdate("UPDATE course SET semestr=\"W08\" WHERE num=61309");
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	public static void updateFlightKU101(Connection con)
	{
		Statement stmt;
		try 
		{
			stmt = con.createStatement();
			stmt.executeUpdate("UPDATE flights SET gate = '2' WHERE flight_number = 'KU101';");
			//stmt.executeUpdate("UPDATE course SET semestr=\"W08\" WHERE num=61309");
		} catch (SQLException e) {e.printStackTrace();}
	}

	
	
	
	
	
}


