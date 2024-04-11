package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
import java.io.*;

public class Login extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
String username=request.getParameter("username");
String password=request.getParameter("password");
System.out.println("Username: "+username);
System.out.println("Password: "+password);
try
{
PrintWriter out=response.getWriter();
try
{
AdministratorDAO administratorDAO=new AdministratorDAO();
Administrator administrator=administratorDAO.getByUsername(username);
if(password.equalsIgnoreCase(administrator.getPassword())==false)
{
throw new DAOException("Invalid Password");
}
HttpSession httpSession=request.getSession();
httpSession.setAttribute("username",username);
out.print("VALID");
}catch(DAOException daoException)
{
out.print("INVALID");
}
}catch(Exception exception)
{
System.out.println(exception); //remove after testing
}
}
}
