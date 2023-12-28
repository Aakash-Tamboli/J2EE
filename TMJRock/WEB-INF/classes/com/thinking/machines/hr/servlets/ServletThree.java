package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.thinking.machines.hr.dl.*;

public class ServletThree extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
System.out.println("Servlet Three is not configured for GET Type Request");
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
String firstName=request.getParameter("firstName");
String lastName=request.getParameter("lastName");
int age=Integer.parseInt(request.getParameter("age"));
PrintWriter out=response.getWriter();
response.setContentType("text/plain");
out.print(firstName+","+lastName+","+age);
}catch(Exception exception)
{
System.out.println("Problem At Server Side: "+exception.getMessage());
}
}
}
