
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Saveproductinmyorder")
public class Saveproductinmyorder extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"minor","root","3132002");
		
			 String name=request.getParameter("name");
		     String p=request.getParameter("price");
		     int price=Integer.parseInt(p);
		     String cat=request.getParameter("cat");
		     String cmp=request.getParameter("cmp");
		  
			String qr="insert into orders select * from cart";     
		
			Statement st=con.createStatement();
			int i=st.executeUpdate(qr);

			if(i>0)
			{			
				RequestDispatcher rd=request.getRequestDispatcher("paymentconfirm.html");
				rd.include(request, response);
	         }
			else
			{
				out.println("not add in my order");
			}
			con.close();
	
	} 	
			catch (Exception e) {
				out.println(e);
			}
			
			}
		}
