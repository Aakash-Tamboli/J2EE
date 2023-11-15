package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
public class Authenticate
{
private Authenticate()
{
// so that nobody will create object of this class
}
public static boolean isLoggedIn(HttpServletRequest request,HttpServletResponse response)
{
boolean usernameFound;
HttpSession httpSession=request.getSession();
String username=(String)httpSession.getAttribute("username");
if(username!=null) usernameFound=true;
else usernameFound=false;
if(usernameFound==false)
{
try
{
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
System.out.println(exception);
}
}
return usernameFound;
}
}

