package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;

public class Logout extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
HttpSession httpSession=request.getSession();
String username=(String)httpSession.getAttribute("username");
if(username!=null)
{
httpSession.removeAttribute("username");
}
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
System.out.println(exception); // remove after testing
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}
