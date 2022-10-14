
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

@WebServlet("/Activeorderaddress1")
public class Activeorderaddress1 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"minor","root","3132002");
			
			 out.println("<style type='text/css'>");
				out.println(".nav{margin: 0px;"
						+ "    padding: 25px;"
						+ "    background-color: rgb(47, 31, 118);"
						+ "    background-size: cover;}");
				out.println("*{"
						+ "	margin: 0px;"
						+ "	padding: 0px;"
						+ "}");
				out.println(".link:hover{"
						+ "    background-color: orange;"
						+ "    border-radius: 8px;"
						+ "    padding-left: 10px;"
						+ "    padding-right: 10px;"
						+ "    padding-top: 2px;"
						+ "    padding-bottom: 2px;"
						+ " }");
				out.println(".links{"
						+ "    "
						+ "	margin-left:50px;"
						+ "	margin-bottom: 0px;"
						+ "    font-size: large;"
						+ "	float: left;"
						+ "} ");

				out.println(".back{"
						+ " background-color: rgb(230, 225, 225);"
						+ "	background-size: cover;"
						+ "} ");

				out.println(".tab{"
						+ "	margin-left:440px;"
						+ "} ");
				
				out.println("</style>");
				out.println("<div class='nav'>");
				out.println("<table>");
				out.println("<tr class='links'>");
				out.println("<th>");
				out.println("<a href='Activeorders?' class='link' style=\"text-decoration: none; color: white;\">Orders</a>");
				out.println("</th>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</div>");
			
			  String qr="select * from address";
			  Statement st=con.createStatement();         
			  ResultSet rs=st.executeQuery(qr);
			            
			  if(rs.next())
			  {			  
				 do
				{	    out.println("<body class='back'>");
					    out.println("<div >");                     //class='back'
						out.println("<table  class='tab'>");
						
						out.println("<th style=\"padding-left:150px;padding-right:150px;padding-top:25px;padding-bottom:25px;background-color: rgb(29, 100, 180);\">DELIVERY ADDRESS</th>");
					 			    
					    String fullname=rs.getString("fullname");
						String phone=rs.getString("phone");
						int pincode=rs.getInt("pincode");
						String state=rs.getString("state");
						String city=rs.getString("city");
						int houseno=rs.getInt("houseno");
						String colony=rs.getString("colony");          //rgb(16, 228, 144)
						
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
						out.println("<tr style=\"padding-left:100px;padding-right:100px;padding-top:15px;padding-bottom:15px;background-color:rgb(16, 228, 144);\">");
						out.println("<td>");
						out.println("STATE   - "+state);
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
			  
