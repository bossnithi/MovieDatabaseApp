package in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddMovie extends HttpServlet implements SqlConnections {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
		
	;
		
		
		String moviename=req.getParameter("moviename");
		String movieyear=req.getParameter("movieyear");
		String movielanguage=req.getParameter("movielanguage");
		  
		
		try {
			addmovie(moviename,movieyear,movielanguage,res,req);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	
	}
	
	
	void addmovie(String moviename,String movieyear,String movielanguage,ServletResponse res,ServletRequest req) throws ClassNotFoundException, SQLException, IOException, ServletException {
		
		PrintWriter out=res.getWriter();
		AddMovie obj=new AddMovie();
		Connection con=obj.connect();
		String query = "Insert into cinema values(?,?,?)";
		PreparedStatement pst=con.prepareStatement(query);
		if(isNotNullOrEmpty(moviename) && isNotNullOrEmpty(movieyear) && isNotNullOrEmpty(movielanguage)) {
		pst.setString(1, moviename);
		pst.setString(2, movieyear);
		pst.setString(3, movielanguage);
		pst.executeUpdate();
		out.println("Movie added successfully!");
		}
		else {
			out.println("Please fill all fields..");
		}
        
	}
	 private boolean isNotNullOrEmpty(String str) {
	        return str != null && !str.isEmpty();
	    }

}
