package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class DeleteEmployee extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
String id=request.getParameter("id");
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/plain");
EmployeeDAO employeeDAO;
employeeDAO=new EmployeeDAO();
try
{
EmployeeDTO employee=employeeDAO.getByEmployeeId(id);
employeeDAO.delete(id);
pw.print("EMPLOYEE DELETED");
}catch(DAOException daoException)
{
pw.print("NOT DELETED");
System.out.println("Problem: "+daoException.getMessage());
}
}catch(Exception exception)
{
System.out.println(exception); // remove after testing
}
}
}
