
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Show")
public class Show extends HttpServlet {
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");

	try {

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
				+ "	margin-left:74px;"
	
				+ "} ");
		out.println(".else{"
				+ "	margin-left:490px;"
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
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"minor","root","3132002");
		String qr="select * from product";
		Statement st=con.createStatement(); 
		ResultSet rs=st.executeQuery(qr);    
		if(rs.next())
		{
			out.println("<div class='back'>");
			out.println("<table  class='tab'>");          //border='1px'                    //style=\"margin-left:350px;\"     rgb(148, 191, 240)
			out.println("<th style=\"padding-left:64px;padding-right:64px;padding-top:20px;padding-bottom:20px;background-color:rgb(121, 118, 118);\">NAME</th>");
			out.println("<th style=\"padding-left:64px;padding-right:64px;padding-top:20px;padding-bottom:20px;background-color:rgb(121, 118, 118);\">PRICE</th>");
			out.println("<th style=\"padding-left:64px;padding-right:64px;padding-top:20px;padding-bottom:20px;background-color:rgb(121, 118, 118);\">CATEGORY</th>");
			out.println("<th style=\"padding-left:64px;padding-right:64px;padding-top:20px;padding-bottom:20px;background-color:rgb(121, 118, 118);\">COMPANY</th>");
			out.println("<th style=\"padding-left:40px;padding-right:40px;padding-top:20px;padding-bottom:20px;background-color:rgb(121, 118, 118);\">DELETE</th>");
			out.println("<th style=\"padding-left:40px;padding-right:40px;padding-top:20px;padding-bottom:20px;background-color:rgb(121, 118, 118);\">UPDATE</th>");
			
			do
			{
				String name=rs.getString("name");
				int price=rs.getInt("price");
				String cat=rs.getString("cat");
				String cmp=rs.getString("cmp");
				
				out.println("<tr>");
				out.println("<td  style=\"padding-left:64px;padding-right:64px;padding-top:20px;padding-bottom:20px;background-color:rgb(148, 191, 240);\">");
				out.println(name);
				out.println("</td>");
				out.println("<td style=\"padding-left:64px;padding-right:64px;padding-top:20px;padding-bottom:20px;background-color: rgb(29, 100, 180);\">");
				out.println(price+"Rs");
				out.println("</td>");
				out.println("<td style=\"padding-left:64px;padding-right:64px;padding-top:20px;padding-bottom:20px;background-color:rgb(148, 191, 240);\">");
				out.println(cat);
				out.println("</td>");
				out.println("<td style=\"padding-left:64px;padding-right:64px;padding-top:20px;padding-bottom:20px;background-color: rgb(29, 100, 180);\">");
				out.println(cmp);
				out.println("</td>");
				out.println("<td style=\"padding-left:40px;padding-right:40px;padding-top:20px;padding-bottom:20px;background-color:rgb(148, 191, 240);\">");
				out.println("<a href='Delete?name="+name+"' class='link' style=\"text-decoration: none;color:white;\"><b>Delete</b></a>");
				out.println("</td>");
				out.println("<td style=\"padding-left:40px;padding-right:40px;padding-top:20px;padding-bottom:20px;background-color: rgb(29, 100, 180);\">");
				out.println("<a href='updatepro.html?name="+name+"&price="+price+"&cat="+cat+"&cmp="+cmp+"' class='link' style=\"text-decoration: none;color:white;\"><b>Update</b></a>");  /*<a href='UpdatePro?name="+name+"&price="+price+"&cat="+cat+"&cmp="+cmp+"'>Update</a>*/
				out.println("</td>");
				out.println("</tr>");
				
			}while(rs.next());
			out.println("<br>");
			out.println("</table>");
			out.println("</div>");
		}
		else
		{   out.println("<div class='back' >"); 
		    out.println("<table class='else'>");
		    out.println("<th>");	
	     	out.println("No Listed products remaining. ");
	     	out.println("</th>");	
	     	out.println("</table>");	
	     	out.println("</div>");	
		}
		con.close();
	 }catch(Exception e)
	{
		 out.println(e);
	}
 }

}
