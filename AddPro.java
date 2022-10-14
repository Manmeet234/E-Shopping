import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;

//import java.io.InputStream;
//import java.io.FileInputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddPro")
public class AddPro extends HttpServlet {
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
		String qr="insert into product values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(qr);
		ps.setString(1, name);
		ps.setInt(2, price);
		ps.setString(3, cat);
		ps.setString(4, cmp);
		
		int i=ps.executeUpdate();
		
		if(i>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("addpro.html");
			rd.include(request, response);
			out.println("<h4 style = \"color :green;text-align : center; margin-top: 398px;\">Product add successfully...</h4>\"");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("addpro.html");
			rd.include(request, response);
			out.println("<h4 style = \"color :red;text-align : center; margin-top: 398px;\">Product not added try again...</h4>\"");
		}
        con.close();
	} catch (Exception e) {
		
		out.println(e);
	}
	
	}

}
