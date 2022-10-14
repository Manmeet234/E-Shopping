
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Addressfulfilled")
public class Addressfulfilled extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String phone=request.getParameter("phone");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"minor","root","3132002");
			String qr="delete from address where phone=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, phone);
			int i=ps.executeUpdate();
			
			if(i>0)
			{	
				RequestDispatcher rd=request.getRequestDispatcher("Activeorders");
				rd.include(request, response);
			}
		
	        con.close();
		} catch (Exception e) {
			
			out.println(e);
		}
	}

}
