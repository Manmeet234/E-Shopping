
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Usignup")
public class Usignup extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"minor","root","3132002");
			String qr=("insert into usersignup values(?,?,?)");
			
			PreparedStatement ps=conn.prepareStatement(qr);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, pwd);
						
			 int i=ps.executeUpdate();
			  if(i>0)
			 {
				RequestDispatcher rd= request.getRequestDispatcher("Ulogin.html");
				rd.include(request, response);
		  //    out.println("<script>window.alert('Signedup sucessfully');</script>");
				out.println("<h4 style = \"color :green;text-align : center; margin-top: -138px;\">Signedup Succesfully Thanks for Join As<p>&#128512</P></h4>\"");
			}
			  
			else
			{
				RequestDispatcher rd= request.getRequestDispatcher("Usignup.html");
				rd.include(request, response);
				//out.println("<script>window.alert('Signup Failed');</script>");
				out.println("<h4 style = \"color :rgb(248, 6, 6);text-align : center; margin-top: -125px;\">Please Fill All Details<p>&#128544</P></h4>\"");
			}
	        conn.close();
		} catch (Exception e) {
			
			out.println(e);
		}
		
	}

}
