package com.thinking.machines;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.*;

public class bbb extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
String name=request.getParameter("name");
String city=request.getParameter("city");
System.out.println("Data Arrived at bbb");
System.out.println("Name: "+name);
System.out.println("City: "+city);
Cookie c1,c2;
c1=new Cookie("name",URLEncoder.encode(name));
c2=new Cookie("city",URLEncoder.encode(city));
response.addCookie(c1);
response.addCookie(c2);

PrintWriter pw;
pw=response.getWriter();

response.setContentType("text/html");

pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>My Fourth Web Application</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("Name: "+name+" <br>");
pw.println("City: "+city+" <br>");
pw.println("<a href='/four/ccc'>Next</a>");
pw.println("</body>");
pw.println("</html>");

}catch(Exception e)
{
System.out.println(e);
}
}
}
