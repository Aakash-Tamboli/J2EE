package xyz;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class CancelServlet extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter();
response.setContentType("text/html");

pw.println("<!DOCTYPE HTML>");
pw.println("<html lan='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>Home</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<h1>God is Great</h1>");
pw.println("<h2>Welcome</h2>");
pw.println("<a href='/cancelButtonThing/index.html'>HOME</a>");
pw.println("</body>");
pw.println("</html>");


}catch(Exception e)
{
System.out.println(e); // remove after testing
}
}
}
