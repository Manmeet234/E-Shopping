
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

@WebServlet("/removefromcart")
public class removefromcart extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("name");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"minor","root","3132002");
			String qr="delete from cart where name=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, name);
			int i=ps.executeUpdate();
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("viewcart");    //Removeaddfromcart
				rd.include(request, response);
			
			}
//			else
//			{
//				RequestDispatcher rd=request.getRequestDispatcher("Show");
//				rd.include(request, response);
//				out.println("<h4 style = \"color :red;text-align : center; margin-top: 398px;\">Product not deleted try again..</h4>");
//			}
	        con.close();
		} catch (Exception e) {
			
			out.println(e);
		}
	}

}
