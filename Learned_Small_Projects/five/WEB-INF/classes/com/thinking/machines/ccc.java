package com.thinking.machines;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ccc extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
System.out.println("HIIIIi");
HttpSession hs=request.getSession();
String name=(String)hs.getAttribute("name");
String city=(String)hs.getAttribute("city");
System.out.println("Data Arrived at ccc");
System.out.println("Name: "+name);
System.out.println("City: "+city);
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/html");

pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title> Data Saved</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<center>");
pw.println("<h1>God is Great</h1>");
pw.println("<h5>Data Saved</h5>");
pw.println("Name: "+name+" <br>");
pw.println("City: "+city+" <br>");
pw.println("<a href='/five/'>HOME</a>");
pw.println("</center>");
pw.println("</body>");
pw.println("</html>");

}catch(Exception e)
{
System.out.println(e);
}
}
}
