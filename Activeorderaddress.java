
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


@WebServlet("/Activeorderaddress")
public class Activeorderaddress extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"minor","root","3132002");
			
		
//			 out.println("<a href='Activeorders?'>Orders</a>");   
			 
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
//					+ "	margin-bottom: 0px;"
					+ " font-size: large;"
					+ "	float: left;"
					+ "} ");
			out.println(".back{"
					+ " background-color: rgb(230, 225, 225);"
					+ "	background-size: cover;"				
					+ "} ");
			out.println(".link:hover{"
					+ "    background-color: orange;"
					+ "    border-radius: 8px;"
					+ "    padding-left: 10px;"
					+ "    padding-right: 10px;"
					+ "    padding-top: 2px;"
					+ "    padding-bottom: 2px;"
					+ " }");

			out.println(".tab{"
					+ "	margin-left:200px;"
		
					+ "} ");
			
			out.println("</style>");
			out.println("<div class='nav'>");
			out.println("<table >");
			out.println("<th class='innav' style=\"color: white;\">Order Status Fulfilled</th>");
			out.println("</table>");
			out.println("</div>");
		  	
			  String qr="select * from address";
			  Statement st=con.createStatement();         
			  ResultSet rs=st.executeQuery(qr);
	
			  if(rs.next())
			  {
				 do
				{	 
					    out.println("<body class='back'>");
			            out.println("<div>");
						out.println("<table  class='tab'>");
						
						out.println("<th style=\"padding-left:150px;padding-right:150px;padding-top:25px;padding-bottom:25px;background-color: rgb(29, 100, 180);\">DELIVERY ADDRESS</th>");
						out.println("<th style=\"padding-left:150px;padding-right:150px;padding-top:25px;padding-bottom:25px;background-color: rgb(29, 100, 180);\">ORDER STATUS<p style=\"font-size: small;color:white;\">click on Order Fulfilled</p></th>");
					    
					    String fullname=rs.getString("fullname");
						String phone=rs.getString("phone");
						int pincode=rs.getInt("pincode");
						String state=rs.getString("state");
						String city=rs.getString("city");
						int houseno=rs.getInt("houseno");
						String colony=rs.getString("colony");
												
						out.println("<tr style=\"padding-left:100px;padding-right:100px;padding-top:25px;padding-bottom:25px;background-color:rgb(148, 191, 240);\">");
						out.println("<td>");
						out.println("NAME  - "+fullname);
						out.println("</td>");
						out.println("</tr >");
						out.println("<tr style=\"padding-left:100px;padding-right:100px;padding-top:15px;padding-bottom:15px;background-color:rgb(16, 228, 144);\">");
						out.println("<td>");
						out.println("PHONE NO  - "+phone);
						out.println("</td>");
						out.println("</tr>");
						out.println("<tr style=\"padding-left:100px;padding-right:100px;padding-top:15px;padding-bottom:15px;background-color:rgb(148, 191, 240);\">");
						out.println("<td>");
						out.println("PINCODE NO  - "+pincode);
						out.println("</td>");
						out.println("</tr>");
						out.println("<tr style=\"padding-left:100px;padding-right:100px;padding-top:15px;padding-bottom:15px;\">");
						out.println("<td style=\"background-color:rgb(16, 228, 144);\">");
						out.println("STATE   - "+state);
						out.println("</td>");
						out.println("<td style=\"padding-left:120px;font-size: x-large;background-color:white;\">");
						out.println("<a href='Addressfulfilled?phone="+phone+"' class='link' style=\"text-decoration: none;\">Order Fulfilled</a>");							
						out.println("</td>");
						out.println("</tr>");
						out.println("<tr style=\"padding-left:100px;padding-right:100px;padding-top:15px;padding-bottom:15px;background-color:rgb(148, 191, 240);\">");
						out.println("<td>");
						out.println("CITY   - "+city);
						out.println("</td>");						
						out.println("</tr>");
						out.println("<tr style=\"padding-left:100px;padding-right:100px;padding-top:15px;padding-bottom:15px;background-color:rgb(16, 228, 144);\">");
						out.println("<td>");
						out.println("HOUSE NO   -  "+houseno);
						out.println("</td>");
						out.println("</tr>");
						out.println("<tr style=\"padding-left:100px;padding-right:100px;padding-top:15px;padding-bottom:15px;background-color:rgb(148, 191, 240);\">");
						out.println("<td>");
						out.println("COLONY NAME   - "+colony);
						out.println("</td>");					

						out.println("</tr>");
				
				 } while(rs.next());
				    out.println("</table>");
				    out.println("</div>");
				    out.println("</body>");
      		
			  con.close();
		      }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	}
			  
