package com.thinking.machines.hr.servlets;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
import java.io.*;
import com.google.gson.*;

public class ServletOneJSON extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter();
response.setContentType("application/json");
List<DesignationDTO> designations=null;
try
{
DesignationDAO designationDAO=new DesignationDAO();
designations=designationDAO.getAll();
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
String jsonString="{\"title\": \"NO DESIGNATION\", \"code\": -1};";
pw.print(jsonString);
pw.flush();
return;
}
Gson gson=new Gson();
String jsonString=gson.toJson(designations);
System.out.println(jsonString);
pw.print(jsonString);
pw.flush();
}catch(Exception exception)
{
System.out.println(exception);
// do nothing
}
}
}
