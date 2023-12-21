package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AuthenticationJS extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter out=response.getWriter();
response.setContentType("text/javascript");
out.print("var isLoggedIn=false;");
boolean isLoggedIn=Authenticate.isLoggedIn(request);
if(isLoggedIn==true)
{
out.print("isLoggedIn=true;");
}
ServletContext servletContext=getServletContext();
String fileName=servletContext.getRealPath("")+File.separator+"WEB-INF"+File.separator+"js"+File.separator+"Authentication.js";
File file=new File(fileName);
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"r");

while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
out.println(randomAccessFile.readLine());
}
randomAccessFile.close();
}catch(Exception exception)
{
System.out.println(exception); // remove after testing
}
}
}
