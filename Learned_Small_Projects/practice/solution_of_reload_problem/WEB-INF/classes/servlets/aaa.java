package servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class aaa extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
PrintWriter out;
try
{
out=response.getWriter();
response.setContentType("text/html");
String formId=request.getParameter("formId");
String vFormId="";
HttpSession httpSession=request.getSession(false);
if(httpSession==null)
{
System.out.println("Session Object does not found");
}
else
{
vFormId=(String)httpSession.getAttribute("uniqueId");
httpSession.removeAttribute("uniqueId");
}
System.out.println("Hidden Form: "+formId);
System.out.println("Session Object: "+vFormId);
out.println("<!DOCTYPE HMTL><html lang='en'><head><meta charset='utf-8'></head><body><h1>Response</h1></body></html>");
}catch(Exception exception)
{
System.out.println("Problem: "+exception.getMessage());
}
}
}
