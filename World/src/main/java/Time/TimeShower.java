package Time;

import java.awt.image.RescaleOp;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;



public class TimeShower extends HttpServlet {
	public void service(ServletRequest req,ServletResponse res) throws IOException{
		try {
			
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String country = req.getParameter("country");
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.setTimeZone(TimeZone.getTimeZone(country));
		sdf.applyPattern("dd MMM yyyy HH:mm:ss z");
		RequestDispatcher rDispatcher = req.getRequestDispatcher("/TimeShow.html");
		rDispatcher.include(req, res);
		out.println("<h1>"+country+"--------"+sdf.format(Calendar.getInstance().getTime())+"</h1>");
		}
		catch (Exception eee) {
			System.out.println(eee);
		}
		
	}
		
	

}
