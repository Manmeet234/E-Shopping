
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

@WebServlet("/Address1")
public class Address1 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		     Connection con= DriverManager.getConnection("jdbc:mysql://Localhost:3306/minor","root","3132002");
		     
		        String fullname=request.getParameter("fullname");
				String phone=request.getParameter("phone");
				String p2=request.getParameter("pincode");
				int pincode=Integer.parseInt(p2);
				String state=request.getParameter("state");
				String city=request.getParameter("city");
				String p3=request.getParameter("houseno");
				int houseno=Integer.parseInt(p3);
				String colony=request.getParameter("colony");
		     
		     String qr="insert into address values(?,?,?,?,?,?,?)";
	    	  
	          PreparedStatement ps=con.prepareStatement(qr);
	          ps.setString(1, fullname);
	          ps.setString(2, phone);
	          ps.setInt(3, pincode);
	          ps.setString(4, state);
	          ps.setString(5, city);
	          ps.setInt(6, houseno);
	          ps.setString(7, colony);
	          
	          int i=ps.executeUpdate();
	          if(i>0)
	  		{
	        	
	  			RequestDispatcher rd=request.getRequestDispatcher("paymentconfirm.html");     
	  			rd.include(request, response);	  			
	  		}
	  		else
	  		{
	  			RequestDispatcher rd=request.getRequestDispatcher("address.html");
	  			rd.include(request, response);
	  			out.println("<h4 style = \"color :red;text-align : center; margin-top: 398px;\">Address not save try again...</h4>\"");
	  		}
	          con.close();
	  	} catch (Exception e) {
	  		
	  		out.println(e);
	  	}
	  	
	  	}

	  }

