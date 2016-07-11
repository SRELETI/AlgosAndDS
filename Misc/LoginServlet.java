import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class LoginServlet extends HttpServlet {
 
  // Method to handle GET method request.
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
		
      // Set response content type
      response.setContentType("text/html");
		
      PrintWriter out = response.getWriter();
	  
	  String Username=request.getParameter("UserName");
	  String password=request.getParameter("Password");
	  boolean result=Validate.checkUser(Username);
	  if(result)
	  {
		  RequestDispatcher rs=request.getRequestDispatcher("Welcome.jsp");
		  rs.forward(request, response);
	  }
	  else
	  {
		  RequestDispatcher rs=request.getRequestDispatcher("login.jsp");
		  rs.include(request,response);
		  
	  }
  }
}