package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
import java.io.*;

public class DeleteDesignation extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
boolean isLoggedIn=Authenticate.isLoggedIn(request);
if(isLoggedIn==false) return;
int code=0;
try
{
PrintWriter out=response.getWriter();
response.setContentType("text/plain");
try
{
code=Integer.parseInt(request.getParameter("code"));
}catch(NumberFormatException numberFormatException)
{
code=0;
}
try
{
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
designationDAO.delete(code);
out.print("DELETED");
}catch(DAOException daoException)
{
System.out.println("Problem: "+daoException.getMessage());
out.print(daoException.getMessage());
}
}catch(Exception exception)
{
System.out.println(exception);
}
}
};
