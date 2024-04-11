package xyz;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class SaveData extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/html");
String name=request.getParameter("name");
String gender=request.getParameter("gender");
System.out.println("Name: "+name);
System.out.println("Gender: "+gender);

pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>Data Saved</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<h1>Data Saved</h1>");
pw.println("<a href='/cancelButtonThing/index.html'>HOME</a>");
pw.println("</body>");
pw.println("</html>");

}catch(Exception e)
{
System.out.println(e); // remove after testing
}
}
}
