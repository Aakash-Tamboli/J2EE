import javax.servlet.*;
import javax.servlet.http.*;

public class Authenticate
{
private Authenticate()
{
// so that nobody will create object of this class
}
public static void isLoggedIn(HttpServletRequest request,HttpServletResponse response)
{
System.out.println("Is Logged In called");
HttpSession httpSession=request.getSession();
String username=(String)httpSession.getAttribute("username");
if(username!=null) return;
System.out.println("Username: "+username);
System.out.println("Username not found in session object");
try
{
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
System.out.println(exception);
}
}
}
