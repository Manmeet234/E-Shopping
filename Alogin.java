
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Alogin")
public class Alogin extends HttpServlet {
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	if(id.equals("admin@12345")&&pwd.equals("12345"))
	{
		response.sendRedirect("adminhome.html");	
		//RequestDispatcher rd=request.getRequestDispatcher("AdminHome");
		//rd.forward(request, response);			
	}	
	else
	{
		RequestDispatcher rd=request.getRequestDispatcher("Alogin.html");
		rd.include(request, response);
		out.println("<h4 style = \"color :rgb(248, 6, 6);text-align : center; margin-top:-106px;\">Invalid Id and Password<p>&#129300</P></h4>\"");
	}
  }

}
