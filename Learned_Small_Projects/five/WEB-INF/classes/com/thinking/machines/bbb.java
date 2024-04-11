package com.thinking.machines;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class bbb extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
String city=request.getParameter("city");
System.out.println("Data Arrived at bbb servlet");
System.out.println("City: "+city);
HttpSession hs=request.getSession();
// String name=(String)hs.getAttribute("name");
// System.out.println("After Extraction name from Http Session Object: "+name);
hs.setAttribute("city",city);

PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/html");

pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>My Fifth Web Application</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("Name: "+"Dummy"+" <br>");
pw.println("City: "+city+" <br>");
pw.println("<a href='/five/ccc'>Save</a>");
pw.println("</body>");
pw.println("</html>");

}catch(Exception e)
{
System.out.println(e);
}
}
}
