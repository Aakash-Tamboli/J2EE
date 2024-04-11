package com.thinking.machines.webrock;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.webrock.model.*;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.scope.*;
import com.thinking.machines.webrock.pojo.*;
import com.thinking.machines.webrock.util.*;
import java.lang.reflect.*;
import java.io.*;
import java.util.*;

public class TMWebRockStarter extends HttpServlet
{
private boolean DELETE_PREVIOUSLY_GENERATED_JSFILE;
private String JSFILENAME;
private String PREFIX;
private ServletContext servletContext;

private void dealingWithStartupServices(List<Service> startupList)
{
boolean notVoid=false;
boolean parametersArgs=false; // later on it will change
boolean invalidPriority=false; // I will clearly specify that priority should be start from >=0 otherwise framework will not execute startupFunction

Service service;
Class c;
Method m;
Class returnType;
Class[] parameters;
System.out.println("Size of Startup List: "+startupList.size());
Collections.sort(startupList,(Service s1,Service s2)->{
return s1.getPriority()-s2.getPriority();
});

try
{

for(int i=0;i<startupList.size();i++)
{
service=startupList.get(i);
if(service.getPriority()<0) invalidPriority=true;
c=service.getServiceClass();
m=service.getService();
returnType=m.getReturnType();
if(returnType.equals(Void.TYPE)==false) notVoid=true; // https://stackoverflow.com/questions/1924253/how-to-determine-by-reflection-if-a-method-returns-void
parameters=m.getParameterTypes();
if(parameters!=null && parameters.length!=0) parametersArgs=true;
if(notVoid || parametersArgs || invalidPriority)
{
if(notVoid)
{
System.out.println("METHOD TYPE SHOULD BE VOID Your class have :"+returnType.getSimpleName());
notVoid=false; // next cycle
}
if(parametersArgs)
{
System.out.println("YOUR METHOD SHOULD NOT TAKE ANY Args, Your method taking args");
parametersArgs=false; // next cycle
}
if(invalidPriority)
{
System.out.println("PRIORITY SHOULD BE >=0 AND REMEBER LOWER THE NUMBER HIGHER THE PRIORITY, you give priority: "+service.getPriority());
invalidPriority=false; // next cycle
}
continue;
}
m.invoke(c.newInstance());
} // loop ends
}catch(Exception exception)
{
System.out.println("LOCATION: TMWEBROCKSTARTUP -> METHOD dealingWithStartupServices");
System.out.println(exception);
}
}


public void init(ServletConfig servletConfig) throws ServletException
{

this.DELETE_PREVIOUSLY_GENERATED_JSFILE=false;
System.out.println("\n\n\n\t\t\t\t TMWebRockStarter is in action at Server Startup\n\n\n\n");


PREFIX=servletConfig.getInitParameter("SERVICE_PACKAGE_PREFIX").trim();

System.out.println("["+PREFIX+"]\n");

JSFILENAME=servletConfig.getInitParameter("JSFILE").trim();

if(JSFILENAME==null || JSFILENAME.length()==0) System.out.println("NO JSFILENAME FOUND");
else System.out.println(JSFILENAME);

servletContext=servletConfig.getServletContext();

/*
System.getProperty("cataline.base"); // resource from https://stackoverflow.com/questions/48748318/how-to-get-the-path-upto-webapps-folder-of-tomcat-in-servlet#:~:text=1%20Answer&text=String%20webApp%20%3D%20String.,the%20path%20will%20always%20work.
*/

String knownFact=System.getProperty("catalina.base")+File.separator+"webapps"+File.separator+"TMWebRock"+File.separator+"WEB-INF"+File.separator+"classes"+File.separator+PREFIX;


List<String> list=Analyze.processToFindAllClassesName(knownFact,PREFIX);

List<Service> startupList=new ArrayList<>();

Analyze.processToPopulateDataStructures(list,startupList,servletContext,JSFILENAME);

dealingWithStartupServices(startupList);


} // init method
} // TMWebRockStarter class ends
