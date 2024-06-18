package in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface SqlConnections {
	
	default Connection connect() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/Movies";
		String username="root";
		String password="9965006556";
		Connection connect =DriverManager.getConnection(url,username,password);
		return connect;
		
	}
}