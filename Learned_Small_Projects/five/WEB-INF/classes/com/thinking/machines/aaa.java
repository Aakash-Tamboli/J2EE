package com.thinking.machines;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class aaa extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
String name=request.getParameter("name");
System.out.println("Data Arrived At: aaa servlet");
System.out.println("Name: "+name);
HttpSession hs=request.getSession();
hs.setAttribute("name",name);
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
pw.println("<center>");
pw.println("<form action='/five/bbb'>");
pw.println("City: &nbsp;");
pw.println("<input type='text' id='city' name='city'>");
pw.println("<button type='submit'>Next</button>");
pw.println("</form>");
pw.println("</center>");
pw.println("</body>");
pw.println("</html>");

}catch(Exception e)
{
System.out.println(e);
}
}
}
