
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Uforgetpass")
public class Uforgetpass extends HttpServlet {
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	//String name=request.getParameter("name");
	String email=request.getParameter("email");
	String p=request.getParameter("pwd");
	String p1=request.getParameter("pwd1");
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"minor","root","3132002");
		String qr=("update usersignup set pwd=(?) where email like (?)");    //("update usersignup set email=(?),pwd=(?) where name like (?)")
		PreparedStatement ps=con.prepareStatement(qr);                       
		
		ps.setString(2, email);
		ps.setString(1, p);
		
		int i=ps.executeUpdate();
		
		if(p.equals(p1))
		{		
		if(i>0)     
		{
			RequestDispatcher rd=request.getRequestDispatcher("Ulogin.html");
			rd.include(request, response);
			out.println("<h4 style = \"color :green;text-align : center; margin-top: -138px;\">Password Succesfully Forgetted<p>&#128512</P></h4>\"");
		}
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Uforgetpass.html");   //Show
			rd.include(request, response);
			out.println("<h4 style = \"color :rgb(248, 6, 6);text-align : center; margin-top: -127px;\">Password Not Forgetted try again<p>&#128544</P></h4>\"");
		}
        con.close();
	} catch (Exception e) {
		
		out.println(e);
	}
	
	}

}
