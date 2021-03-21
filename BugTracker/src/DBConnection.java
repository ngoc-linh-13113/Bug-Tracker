import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private String url;
	private String username;
	private String password;
	private Connection con;
	
	public DBConnection (String url,String username, String password)
	{
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public Connection getConnection() {
		try {
			con = DriverManager.getConnection(this.url,this.username,this.password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
