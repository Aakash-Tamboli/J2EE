package com.thinking.machines.hr.servlets;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
import java.io.*;

public class ServletOne extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter();
response.setContentType("text/plain");
DesignationDAO designationDAO=new DesignationDAO();
List<DesignationDTO> designations=designationDAO.getAll();
int i=0;
for(DesignationDTO designation: designations)
{
i++;
pw.print(designation.getCode()+","+designation.getTitle());
if(i<designations.size()) pw.print(",");
}
}catch(Exception exception)
{
// do nothing
}
}
}
