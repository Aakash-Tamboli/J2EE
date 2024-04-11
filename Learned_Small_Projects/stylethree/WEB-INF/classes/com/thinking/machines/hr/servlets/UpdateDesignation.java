package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UpdateDesignation extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
boolean isLoggedIn=Authenticate.isLoggedIn(request);
if(isLoggedIn==false) return;
try
{
PrintWriter out=response.getWriter();
response.setContentType("text/plain");
int code=Integer.parseInt(request.getParameter("code"));
String title=request.getParameter("title");
DesignationDTO designation;
DesignationDAO designationDAO=new DesignationDAO();
designation=new DesignationDTO();
designation.setCode(code);
designation.setTitle(title);
try
{
designationDAO.update(designation);
out.print("UPDATED");
}catch(DAOException daoException)
{
out.print("NOT UPDATED");
}
}catch(Exception exception)
{
System.out.println("Problem: "+exception); // after testing remove
}
}
};
