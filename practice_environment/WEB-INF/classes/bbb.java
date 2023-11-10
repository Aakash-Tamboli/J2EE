import javax.servlet.*;
import javax.servlet.http.*;

public class bbb extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
System.out.println("3");
Authenticate.isLoggedIn(request,response);
System.out.println("4");
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/some.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
System.out.println(exception);
}
}
}
