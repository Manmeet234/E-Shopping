
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/makepayment0")
public class makepayment0 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"minor","root","3132002");
			
			  String qr="select * from cart ";
			  Statement st=con.createStatement();         
			  ResultSet rs=st.executeQuery(qr);
			  
			  out.println("<style type='text/css'>");
			  out.println(".tab1{"
						+ "	margin-left:300px;"
						+ "} ");
			  out.println(".link:hover{"
						+ "    border-radius: 8px;"
						+ "    padding-left: 10px;"
						+ "    padding-right: 10px;"
						+ "    padding-top: 2px;"
						+ "    padding-bottom: 2px;"
						+ " }");
			  out.println("</style>");
			  
			  if(rs.next())
			  {
				    out.println("<table class='tab1'>");
				    out.println("<th style=\"padding-left:170px;padding-right:100px;padding-top:20px;padding-bottom:20px;background-color: rgb(29, 100, 180);\">Product Details</th>");
				   
				    String name=rs.getString("name");
					int price=rs.getInt("price");
					String cat=rs.getString("cat");
					String cmp=rs.getString("cmp");
				 do
				{				    
					out.println("<tr>"); 
					out.println("<td>");
					out.println("MODEL NAME - "+rs.getString("name")+" , PRICE - "+rs.getInt("price")+" , PRODUCT - "+rs.getString("cat")+" , COMPANY NAME  - "+rs.getString("cmp"));
					out.println("</td>");	
					out.println("</tr>");
				
					   
				 } while(rs.next());
				 out.println("</table>");
				 out.println("<br>");
				 out.println("<div class='link' style=\"text-align:center; \">");                                 
				 out.println("<a href='Saveproductinmyorder?name="+name+"&price="+price+"&cat="+cat+"&cmp="+cmp+"'  style=\"text-decoration: none;background-color:orange;padding-left:13px;padding-right:13px;padding-top: 5px;padding-bottom: 5px;border-radius: 8px;border-style: groove; border-color:white;\"><b>Make Payment</b></a>");   
				 out.println("</div>"); 

			   }
			  else
			  {
				  RequestDispatcher rd=request.getRequestDispatcher("makepayment");
	      		  rd.include(request, response);
				//  System.out.println("No Product found in Your Card");
			  }
			  con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
