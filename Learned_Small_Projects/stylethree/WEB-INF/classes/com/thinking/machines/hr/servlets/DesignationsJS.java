package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


public class DesignationsJS extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter();
response.setContentType("text/javascript");
DesignationDAO designationDAO=new DesignationDAO();
List<DesignationDTO> designations=designationDAO.getAll();
pw.println("function Designation()");
pw.println("{");
pw.println("var title='';");
pw.println("var code=0;");
pw.println("}");
pw.println("var designations=[];");
pw.println("var designation=null;");
int i=0;
for(DesignationDTO designation: designations)
{
pw.println("designation=new Designation();");
pw.println("designation.title=\""+designation.getTitle()+"\"");
pw.println("designation.code="+designation.getCode());
pw.println("designations["+i+"]=designation;");
i++;
}
ServletContext servletContext=getServletContext();
String fileName=servletContext.getRealPath("")+File.separator+"WEB-INF"+File.separator+"js"+File.separator+"Designations.js";
File file=new File(fileName);
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"r");
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
pw.println(randomAccessFile.readLine());
}
randomAccessFile.close();
}catch(Exception exception)
{
System.out.println(exception);
}
}
}
