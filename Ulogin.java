
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ulogin")
public class Ulogin extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		 
		     String email = request.getParameter("email");
	         String pwd = request.getParameter("pwd");
  
		try
		   {
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"minor","root","3132002");
		  
		       String qurey= ( "select * from usersignup where email=? and pwd=?");
		         
		       PreparedStatement pst = conn.prepareStatement(qurey);
			   pst.setString(1,email);
			   pst.setString(2,pwd);	   
				ResultSet rs=pst.executeQuery();
								
				if(rs.next())
				{
			
					RequestDispatcher rd= request.getRequestDispatcher("Uhome");
      			    rd.include(request, response);	
				}
			else
				{
					RequestDispatcher rd= request.getRequestDispatcher("Ulogin.html");
					rd.include(request,response );
					out.println("<h4 style = \"color :rgb(248, 6, 6);text-align : center; margin-top:-136px;\">Invalid Id and Password<p>&#129300</P></h4>\"");	 
				}
				
		        conn.close();
			}
		catch(Exception e)
		{
			System.out.println(e);
		}		
	}
	}
