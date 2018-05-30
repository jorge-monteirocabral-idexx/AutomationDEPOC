package POC.POC;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.JDBCType;


public class ConnectToDB{
 
    private static final String URL = "jdbc:mysql://localhost:3306/Automation?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String URLLYNXX = "jdbc:oracle:thin:@wmeracs3-scan.idexxi.com:1521/lnxdv01_nds";
 
    public static Connection connect() throws SQLException {
        Connection conn = null;
        try {
        	DriverManager.registerDriver (new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection(URL, "root", "04061971");
            System.out.println("connected to MYSQL");
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }	
    
    public static Connection connectLynxx()
    {
    	Connection connOracle=null; 
    		try
    		{
    	   		DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
    	   		connOracle = DriverManager.getConnection(URLLYNXX, "LYNXX", "Idexx_123");
    	   		System.out.println("Connected to Lynxx");

    		} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	return connOracle;
    }
}