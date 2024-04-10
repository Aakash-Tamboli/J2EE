package xyz;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class aaa extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
ServletContext servletContext=request.getServletContext();
System.out.println("Path: "+servletContext.getRealPath("."));

// String pathJS=servletContext.getRealPath(".")+"/WEB-INF/js"; in below I added / after js
String pathJS=servletContext.getRealPath(".")+"/WEB-INF/js/";
System.out.println(pathJS);
File file=new File(pathJS);

if(file.exists()==false)
{
System.out.println("Yes Directory not exists");
/*
Not Worked I checked
if(file.mkdirs()) System.out.println("Directory created");
else System.out.println("Directory not created");
*/
if(file.mkdir()) System.out.println("Directory created");
else System.out.println("Directory not created");
}

}catch(Exception e)
{
System.out.println(e); // remove after testing
}
}
}
