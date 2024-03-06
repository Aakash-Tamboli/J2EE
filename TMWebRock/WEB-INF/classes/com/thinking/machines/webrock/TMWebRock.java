package com.thinking.machines.webrock;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.reflect.*;
import java.io.*;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.model.*;
import com.thinking.machines.webrock.pojo.*;
import com.thinking.machines.webrock.scope.*;



public class TMWebRock extends HttpServlet
{
private ServletContext servletContext;
private WebRockModel model;

public void init(ServletConfig servletConfig) throws ServletException
{
this.servletContext=servletConfig.getServletContext();
this.model=(WebRockModel)this.servletContext.getAttribute("dataStructure");
}

public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
ServletContext servletContext=request.getServletContext();

System.out.println("DEBUG: "+request.getContextPath());
System.out.println("DEBUG: "+request.getPathInfo());
System.out.println("DEBUG: model size: "+model.dataStructure.size());

String key=request.getPathInfo();
String serviceURL=key.substring(key.indexOf("/",1));
System.out.println("Service URL: "+serviceURL);


if(model.dataStructure.containsKey(key))
{
System.out.println("God is Great key is there");
Service mainService=model.dataStructure.get(key);
String anotherServiceURL=mainService.getPath().substring(key.indexOf("/",1));
System.out.println("Another Service URL: "+anotherServiceURL);
System.out.println("[doGet] RequestType : "+mainService.getIsGetAllowed());

if(mainService.getIsGetAllowed() && serviceURL.equalsIgnoreCase(anotherServiceURL) )
{
System.out.println(1);
Method subService=mainService.getService();
System.out.println(2);
Class targetClass=mainService.getServiceClass();
System.out.println(3);
Object instantiationOfClass=targetClass.newInstance();
System.out.println(4);
// here code of injecting things or IOC starts
if(mainService.getInjectApplicationDirectory())
{
String path=servletContext.getRealPath("/"); //https://stackoverflow.com/questions/12160639/what-does-servletcontext-getrealpath-mean-and-when-should-i-use-it
System.out.println(5);
ApplicationDirectory applicationDirectory=new ApplicationDirectory(new File(path));
System.out.println(6);
Method setterMethod=targetClass.getMethod("setApplicationDirectory",ApplicationDirectory.class);
System.out.println(7);
setterMethod.invoke(instantiationOfClass,applicationDirectory);
System.out.println(8);
}
// above code of injecting things or IOC ends
subService.invoke(instantiationOfClass);
// here forward related code
if(mainService.getForwardTo()!=null && mainService.getForwardTo().length()>0)
{
RequestDispatcher requestDispatcher;
System.out.println("Forwarding: "+request.getServletPath()+key.substring(0,key.indexOf("/",1))+mainService.getForwardTo());
requestDispatcher=request.getRequestDispatcher(request.getServletPath()+key.substring(0,key.indexOf("/",1))+mainService.getForwardTo());
requestDispatcher.forward(request,response);
}
}
else
{
if(serviceURL.equalsIgnoreCase(anotherServiceURL)==false) response.sendError(HttpServletResponse.SC_FOUND);
else response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
}
}
else
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher(serviceURL);
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
System.out.println("Exception got raised in DoPost");
System.out.println(exception);
}
} // doGet ends

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
System.out.println("DEBUG: "+request.getContextPath());
System.out.println("DEBUG: "+request.getPathInfo());
System.out.println("DEBUG: model size: "+model.dataStructure.size());

String key=request.getPathInfo();
String serviceURL=key.substring(key.indexOf("/",1));
System.out.println("Service URL: "+serviceURL);

if(model.dataStructure.containsKey(key))
{
System.out.println("God is Great key is there");
Service mainService=model.dataStructure.get(key);
String anotherServiceURL=mainService.getPath().substring(key.indexOf("/",1));
System.out.println("Another Service URL: "+anotherServiceURL);
System.out.println("[doPost]RequestType : "+mainService.getIsPostAllowed());
if(mainService.getIsPostAllowed() && serviceURL.equalsIgnoreCase(anotherServiceURL) )
{
System.out.println("Service is in action");
Method subService=mainService.getService();
subService.invoke(mainService.getServiceClass().newInstance());
// here forward related code

if(mainService.getForwardTo()!=null && mainService.getForwardTo().length()>0)
{
RequestDispatcher requestDispatcher;
System.out.println("Forwarding: "+request.getServletPath()+key.substring(0,key.indexOf("/",1))+mainService.getForwardTo());
requestDispatcher=request.getRequestDispatcher(request.getServletPath()+key.substring(0,key.indexOf("/",1))+mainService.getForwardTo());
requestDispatcher.forward(request,response);
}

}
else
{
if(serviceURL.equalsIgnoreCase(anotherServiceURL)==false) response.sendError(HttpServletResponse.SC_FOUND);
else response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
}
}
else
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher(serviceURL);
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
System.out.println("Exception got raised");
System.out.println(exception);
}
} // doPost ends
} // class ends
