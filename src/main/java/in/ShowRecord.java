package in;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowRecord extends HttpServlet implements SqlConnections {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		

	}
public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {

	String option=req.getParameter("option");
	String year=req.getParameter("yearOption");
	
	switch(option) {
	case "All Language":
		try {
			allmovie(res);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		break;
	case "Indian Language":
		try {
			indianLanguage(year,res);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		break;
	case "Foreign Language":
		try {
			foreignLanguage(year,res);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		break;
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

void indianLanguage(String year,HttpServletResponse res) throws IOException, ClassNotFoundException, SQLException {
	PrintWriter out=res.getWriter();
	ShowRecord obj=new ShowRecord();
	Connection con=obj.connect();
	String query1 = "SELECT * FROM cinema WHERE Language IN ('Tamil', 'malayalam') AND year=?;";
	PreparedStatement pst=con.prepareStatement(query1);
	pst.setString(1, year);
	ResultSet rs=pst.executeQuery();
	if(rs.next()) {
		
		out.println(rs.getString(2)+" "+rs.getString(1)+" "+rs.getString(3));
	}
	else {
		out.println("No Movie was found");
	}
}

void foreignLanguage(String year,ServletResponse res) throws ClassNotFoundException, SQLException, IOException {
	PrintWriter out=res.getWriter();
	ShowRecord obj=new ShowRecord();
	Connection con=obj.connect();
	String query = "SELECT * FROM cinema WHERE Language IN ('english') AND year=?;";
	PreparedStatement pst=con.prepareStatement(query);
	pst.setString(1, year);
	ResultSet rs=pst.executeQuery();
	if(rs.next()) {
		
		out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
	}
	else {
		out.println("No Movie was found");
	}
}



}
