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
public void init(ServletConfig servletConfig) throws ServletException
{
String JSFILENAME;
String PREFIX;
String knownFact;
ServletContext servletContext;


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

knownFact=System.getProperty("catalina.base")+File.separator+"webapps"+File.separator+"TMWebRock"+File.separator+"WEB-INF"+File.separator+"classes"+File.separator+PREFIX;


List<String> list=TMAnalyze.processToFindAllClassesName(knownFact,PREFIX);

List<Service> startupList=new ArrayList<>();

WebRockModel model=TMAnalyze.processToPopulateDataStructures(list,startupList,servletContext.getRealPath("."),JSFILENAME,false); // last argument decided, that this static method is used by TMWebRock Framework or ServiceDoc
servletContext.setAttribute("dataStructure",model);

System.out.println("Total Services in WebRockModel is: "+model.dataStructure.size());

TMExecute.executeAllStartupService(startupList);

} // init method



} // TMWebRockStarter class ends
