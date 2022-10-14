
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdatePro")
public class UpdatePro extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("name");
		String p=request.getParameter("price");
		int price=Integer.parseInt(p);
		String cat=request.getParameter("cat");
		String cmp=request.getParameter("cmp");
		out.println("<form action='Update'>");
		out.println(name);
		out.print("<input type='hidden' name='name' value="+name+" /><br>");
		out.print("ENTER PRICE<input type='number' name='price' value="+price+" /><br>");
		out.print("ENTER CATEGORY<input type='text' name='cat' value="+cat+" /><br>");
		out.print("ENTER COMAPNY<input type='text' name='cmp' value="+cmp+" /><br>");
		out.print("<input type='submit' value='Update' />");
		out.print("</form>");
	}

}
