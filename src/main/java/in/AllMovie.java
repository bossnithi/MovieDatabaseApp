package in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AllMovie extends HttpServlet {
	

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		try {
			allmovie(res);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	void allmovie(HttpServletResponse res) throws IOException, ClassNotFoundException, SQLException {
		PrintWriter out=res.getWriter();
		ShowRecord obj=new ShowRecord();
		Connection con=obj.connect();
		String query = "Select * from cinema";
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		
	}
}
