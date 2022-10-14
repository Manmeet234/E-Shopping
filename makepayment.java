
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

@WebServlet("/makepayment")
public class makepayment extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"minor","root","3132002");
			
			  String qr="select * from address";
			  Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);         //ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY
			  ResultSet rs=st.executeQuery(qr);
	            
			  out.println("<style type='text/css'>");
				out.println(".nav{margin: 0px;"
						+ "    padding: 25px;"
						+ "    background-color: rgb(47, 31, 118);"
						+ "    background-size: cover;}");
				out.println("*{"
						+ "	margin: 0px;"
						+ "	padding: 0px;"
						+ "}");
				
				out.println(".innav{"
						+ "	margin-left:510px;"
//						+ "	margin-bottom: 0px;"
						+ " font-size: large;"
						+ "	float: left;"
						+ "} ");
				out.println(".back{"
						+ " background-color: rgb(230, 225, 225);"
						+ "	background-size: cover;"
						+ "} ");
				out.println(".tab{"
						+ "	margin-left:270px;"
						+ "} ");
				out.println("</style>");
				out.println("<div class='nav'>");
				out.println("<table >");
				out.println("<th class='innav' style=\"color: white;\">Confirm Your Order Details</th>");
				out.println("</table>");
				out.println("</div>");
			  
			  if(rs.last());
				{   out.println("<body class='back'>");
					out.println("<div>");
					out.println("<br>");
					out.println("<table class='tab'>");
					out.println("<th style=\"padding-left:64px;padding-right:64px;padding-top:20px;padding-bottom:20px;background-color:rgb(148, 191, 240);\">Delivery Address</th>");
					out.println("<tr>");
					out.println("<td>");
					out.println("NAME - "+rs.getString("fullname")+" , PHONE NO. -  "+rs.getString("phone")+" , PINCODE NO. - "+rs.getInt("pincode")+" , STATE - "+rs.getString("state"));
					out.println("</td>");
					out.println("</tr>");	
					out.println("<tr>");
					out.println("<td>");
					out.println("CITY - "+rs.getString("city")+" , HOUSE NO. -  "+rs.getInt("houseno")+" , COLONY NAME - "+rs.getString("colony"));
					out.println("</td>");
					out.println("</tr>");
					out.println("</table>");
					out.println("<br>");
					
					out.println("</div>");
					out.println("</body>");
				}
				
//				      out.println("<a href='paymentconfirm.html?'>Make Payment</a>");      //  https://www.paypal.com/in/signin
//					  con.close();				   
//				       
				RequestDispatcher rd=request.getRequestDispatcher("makepayment0");
      			rd.include(request, response);
			}
			catch (Exception e) {
				
			e.printStackTrace();
			}
		}

}
				
			  
