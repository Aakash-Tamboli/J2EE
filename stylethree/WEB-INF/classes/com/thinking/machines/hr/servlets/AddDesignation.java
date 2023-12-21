package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AddDesignation extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
boolean isLoggedIn=Authenticate.isLoggedIn(request);
if(isLoggedIn==false) return;
try
{
String title=request.getParameter("title");
DesignationDTO designation;
designation=new DesignationDTO();
designation.setTitle(title);
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
PrintWriter pw=response.getWriter();
response.setContentType("text/plain");
try
{
designationDAO.add(designation);
pw.print("ADDED");
}catch(DAOException daoException)
{
pw.print("NOT ADDED");
}
}catch(Exception exception)
{
System.out.println(exception); //remove after testing
}
}
}
