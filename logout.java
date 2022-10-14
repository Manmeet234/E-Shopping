
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logout extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		session.invalidate();
		
		 try 
		   {
		     Class.forName("com.mysql.jdbc.Driver");
		     Connection con= DriverManager.getConnection("jdbc:mysql://Localhost:3306/"+"minor","root","3132002");
		     
					      String qurey =("delete from cart");
					
					      Statement st = con.createStatement();
					      int i=st.executeUpdate(qurey);
							if(i>0)
							{
								RequestDispatcher rd=request.getRequestDispatcher("Ulogin.html");
								rd.include(request, response);
								out.println("<script>window.alert('Logout Sucessfully');</script>");
							}
							else
							{
								RequestDispatcher rd=request.getRequestDispatcher("Ulogin.html");
								rd.include(request, response);
							}
							  
					      con.close();
		    }	 
		 
		 catch(Exception e)
		 {
			e.printStackTrace(); 
		 }
			
	}

}
