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


PREFIX=servletConfig.getInitParameter("SERVICE_PACKAGE_PREFIX");

if(PREFIX!=null && PREFIX.trim().length()>0)
{
PREFIX=PREFIX.trim();
}
else
{
System.out.println("\n\n\n\t\t\t\t SERVICE_PACKAGE_PREFIX does not specify in web.xml, please reffer docs \n\n\n\n");
return;
}

System.out.println("["+PREFIX+"]\n");

JSFILENAME=servletConfig.getInitParameter("JSFILE");

if(JSFILENAME!=null && JSFILENAME.trim().length()>0)
{
JSFILENAME=JSFILENAME.trim();
}
else
{
System.out.println("\n\n\n\t\t\t\t JSFILENAME does not specify in web.xml\n\n\n\n");
}


servletContext=servletConfig.getServletContext();

knownFact=servletContext.getRealPath(".")+File.separator+"WEB-INF"+File.separator+"classes"+File.separator+PREFIX;

System.out.println("Path with pacakge specified by user: "+knownFact);

List<String> list=TMAnalyze.processToFindAllClassesName(knownFact,PREFIX);

List<Service> startupList=new ArrayList<>();

WebRockModel model=TMAnalyze.processToPopulateDataStructures(list,startupList,servletContext.getRealPath("."),JSFILENAME,false); // last argument decided, that this static method is used by TMWebRock Framework or ServiceDoc
servletContext.setAttribute("dataStructure",model);

System.out.println("Total Services in WebRockModel is: "+model.dataStructure.size());

TMExecute.executeAllStartupService(startupList);

} // init method

} // TMWebRockStarter class ends
