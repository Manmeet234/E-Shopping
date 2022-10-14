
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cart")
public class cart extends HttpServlet {
	
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
		     String qr1="insert into cart values(?,?,?,?)";
	
				PreparedStatement ps1=con.prepareStatement(qr1);

				ps1.setString(1, name);
				ps1.setInt(2, price);
				ps1.setString(3, cat);
				ps1.setString(4, cmp);
							
				int i=ps1.executeUpdate();

				if(i>0)
				{
					out.println("<script>window.alert('sucessfully added to cart');</script>");
					
					RequestDispatcher rd= request.getRequestDispatcher("Uhome");
      			    rd.include(request, response);	
				}
				else
				{
					out.println("<script>window.alert('not added to cart');</script>");
				}
				con.close();
		
		} 	
				catch (Exception e) {
					out.println(e);
				}
				
				}
			}


