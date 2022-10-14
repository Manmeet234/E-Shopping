
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

@WebServlet("/Update")
public class Update extends HttpServlet {
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	String name=request.getParameter("name");
	String p=request.getParameter("price");
	int price=Integer.parseInt(p);
	String cat=request.getParameter("cat");
	String cmp=request.getParameter("cmp");
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"minor","root","3132002");
		String qr="update product set price=?,cat=?,cmp=? where name=?";
		PreparedStatement ps=con.prepareStatement(qr);
		ps.setString(4, name);
		ps.setInt(1, price);
		ps.setString(2, cat);
		ps.setString(3, cmp);
		int i=ps.executeUpdate();
		if(i>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("updatepro.html");
			rd.include(request, response);
			out.println("<h4 style = \"color :green;text-align : center; margin-top: 405px;\">Product update successfully...</h4>");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("updatepro.html");
			rd.include(request, response);
			out.println("<h4 style = \"color :red;text-align : center; margin-top: 405px;\">Product not updated fill correct Product old name...</h4>");
		}
        con.close();
	} catch (Exception e) {
		
		out.println(e);
	}
	
	}
}
