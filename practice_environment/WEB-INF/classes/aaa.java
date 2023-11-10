import javax.servlet.*;
import javax.servlet.http.*;

public class aaa extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
System.out.println("1");
// HttpSession httpSession=request.getSession();
// httpSession.setAttribute("username","admin");
System.out.println("2");
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/bbb");
try
{
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
System.out.println(exception);
}
System.out.println("2.5");
}
}
