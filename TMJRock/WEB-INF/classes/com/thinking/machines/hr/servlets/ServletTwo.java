package com.thinking.machines.hr.servlets;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.thinking.machines.hr.dl.*;

public class ServletTwo extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
System.out.println("Not Configured for POST type");
}
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
int code=Integer.parseInt(request.getParameter("code"));
PrintWriter pw=response.getWriter();
response.setContentType("text/plain");
try
{
DesignationDTO designationDTO=new DesignationDAO().getByCode(code);
pw.print(designationDTO.getCode()+","+designationDTO.getTitle());
}catch(DAOException exception)
{
pw.print("Invalid");
}
}catch(Exception e)
{
System.out.println("Problem "+e.getMessage());
}
}
}
