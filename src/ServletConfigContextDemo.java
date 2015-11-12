import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigContextDemo extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		ServletContext context = getServletContext();
		Enumeration<String> localparams = config.getInitParameterNames();
		Enumeration<String> globalparams = context.getInitParameterNames();
		PrintWriter out = response.getWriter();
		out.println("<h1>Local values</h1>");
		while (localparams.hasMoreElements()) {
			String parameter = localparams.nextElement();
			out.println(parameter+" : "+ config.getInitParameter(parameter)+"<br>");
		}
		out.println("<h1>Global values</h1>");
		while (globalparams.hasMoreElements()) {
			String parameter = globalparams.nextElement();
			out.println(parameter+" : "+ context.getInitParameter(parameter)+"<br>");
		}
	}
}
