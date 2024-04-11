package com.test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class One extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
ServletContext servletContext=this.getServletContext();
String path=servletContext.getRealPath("/"); // https://stackoverflow.com/questions/12160639/what-does-servletcontext-getrealpath-mean-and-when-should-i-use-it
System.out.println("Someting: "+path);
response.sendError(HttpServletResponse.SC_FOUND);
}catch(IOException ioException)
{
System.out.println(ioException);
}
}
}
