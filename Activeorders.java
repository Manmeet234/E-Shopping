
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

@WebServlet("/Activeorders")
public class Activeorders extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");

		try {
			Class.forName("com.mysql.jdbc.Driver");
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
					+ "	height: 100%;"
					+ " width: 100%;"		
					+ "} ");

			out.println(".tab{"
					+ "	margin-left:17px;"
		
					+ "} ");
			out.println(".else{"
					+ "	margin-left:550px;"
		            + " padding-top:200px;"		
		            + " font-size: x-large;"
					+ "} ");
				
			out.println("</style>");
			out.println("<div class='nav'>");
			out.println("<table>");
			out.println("<tr class='links'>");
			out.println("<th>");
			out.println("<a href='adminhome.html?' class='link' style=\"text-decoration: none; color: white;\">Home</a>");
			out.println("</th>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</div>");
			  
		String qr1="select * from orders";

		Statement st1=con.createStatement();

		ResultSet rs1=st1.executeQuery(qr1);
    
		  if(rs1.next())
		  {
			    out.println("<div class='back'>");
				out.println("<table  class='tab'>");         
				out.println("<th style=\"padding-left:30px;padding-right:30px;padding-top:12px;padding-bottom:12px;background-color:rgb(121, 118, 118);\">NAME</th>");
				out.println("<th style=\"padding-left:30px;padding-right:30px;padding-top:12px;padding-bottom:12px;background-color:rgb(121, 118, 118);\">PRICE</th>");
				out.println("<th style=\"padding-left:30px;padding-right:30px;padding-top:12px;padding-bottom:12px;background-color:rgb(121, 118, 118);\">CATEGORY</th>");
				out.println("<th style=\"padding-left:30px;padding-right:30px;padding-top:12px;padding-bottom:12px;background-color:rgb(121, 118, 118);\">COMPANY</th>");
				out.println("<th style=\"padding-left:10px;padding-right:10px;padding-top:12px;padding-bottom:12px;background-color:rgb(121, 118, 118);\">TOTAL Rs.</th>");
				out.println("<th style=\"padding-left:11px;padding-right:11px;padding-top:12px;padding-bottom:12px;background-color:rgb(121, 118, 118);\">DELIVERY ADDRESS</th>");
				out.println("<th style=\"padding-left:15px;padding-right:15px;padding-top:12px;padding-bottom:12px;background-color:rgb(121, 118, 118);\">ORDER STATUS</th>");
			  	  
				do
			  {
				  int total=0;
				String name=rs1.getString("name");
				int price=rs1.getInt("price");
				String cat=rs1.getString("cat");
				String cmp=rs1.getString("cmp");
				
				total=total+price;
				
				out.println("<tr>");
				out.println("<td style=\"padding-left:60px;padding-right:60px;padding-top:20px;padding-bottom:20px;background-color:rgb(148, 191, 240);\">");
				out.println(name);
				out.println("</td>");
				out.println("<td style=\"padding-left:60px;padding-right:60px;padding-top:20px;padding-bottom:20px;background-color: rgb(29, 100, 180);\">");
				out.println(price+"Rs");
				out.println("</td>");
				out.println("<td style=\"padding-left:60px;padding-right:60px;padding-top:20px;padding-bottom:20px;background-color:rgb(148, 191, 240);\">");
				out.println(cat);
				out.println("</td>");
				out.println("<td style=\"padding-left:60px;padding-right:60px;padding-top:20px;padding-bottom:20px;background-color: rgb(29, 100, 180);\">");
				out.println(cmp);
				out.println("</td>");
				out.println("<td style=\"padding-left:60px;padding-right:60px;padding-top:20px;padding-bottom:20px;background-color:rgb(148, 191, 240);\">");
				out.println(total+"Rs");
				out.println("</td>");
				out.println("<td style=\"padding-left:11px;padding-right:0px;padding-top:20px;padding-bottom:20px;background-color: rgb(29, 100, 180);\">");
				out.println("<a href='Activeorderaddress1?' class='link'  style=\"text-decoration: none;color:white;\"><b>Delivery Address</b></a>");
				out.println("</td>");
				out.println("<td style=\"padding-left:1px;padding-right:0px;padding-top:20px;padding-bottom:20px;background-color:rgb(148, 191, 240);\">");
				out.println("<a href='Orderfulfilled?name="+name+"' class='link' style=\"text-decoration: none;color:white;\"><b>Complete Order</b></a>");
				out.println("</td>");

				out.println("</tr>");
			  }while(rs1.next());
			  out.println("<br>");
			  out.println("</table>");
			  out.println("</div>");
		  }
		
         else {
        	 out.println("<div class='back' >"); 
 		    out.println("<table class='else'>");
 		    out.println("<th>");	
 	     	out.println("No Orders");
 	     	out.println("</th>");	
 	     	out.println("</table>");	
 	     	out.println("</div>");	         }
		  
		}catch (Exception e) {
			
			e.printStackTrace();
		}	
	}
}


	
