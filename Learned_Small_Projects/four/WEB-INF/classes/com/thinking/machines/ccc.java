package com.thinking.machines;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.*;

public class ccc extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
String name="";
String city="";
Cookie[] cookies=request.getCookies();
if(cookies!=null)
{
Cookie c;
for(int i=0;i<cookies.length;i++)
{
c=cookies[i];
if(c.getName().equals("name"))
{
name=URLDecoder.decode(c.getValue());
}
else if(c.getName().equals("city"))
{
city=URLDecoder.decode(c.getValue());
}
}
}
System.out.println("Data Arrived at ccc");
System.out.println("Name: "+name);
System.out.println("CityL "+city);

PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/html");

pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>Data Saved</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<h1>God is Great</h1>");
pw.println("<h2>Finally I did it</h2>");
pw.println("Name: "+name+" <br>");
pw.println("City: "+city+" <br>");
pw.println("<h6>Data Saved</h6>");
pw.println("</body>");
pw.println("</html>");

}catch(Exception e)
{
System.out.println(e);
}
}
}
