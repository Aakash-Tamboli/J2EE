package xyz.pqr;
import javax.servlet.*;
import javax.servlet.http.*;

public class aaa extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
System.out.println("Jar works");
try
{
response.sendError(response.SC_NOT_FOUND);
}catch(Exception exception)
{

}
}
}
