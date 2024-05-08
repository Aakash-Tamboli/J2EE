package com.thinking.machines.webrock.util;
import com.thinking.machines.webrock.pojo.*;

// I created this utility because I use vim to create this framwork hence it is very tds task to write sop everytime with Module name So, this will help me
public class Debug
{
public static void TMWebRockDebug(String message)
{
System.out.println("TMWebRock DEBUG: "+message);
}
public static void TMServiceInfo(Service service)
{
System.out.println("Service Class Name: "+service.getServiceClass().getName());
System.out.println("Service Full Path : "+service.getPath());
System.out.println("Service Forward to url: "+service.getForwardTo());
System.out.println("Service to be serve: "+service.getService().getName());
System.out.println("Service to serve returns: "+service.getIsServiceReturns());
System.out.println("Service to serve for GET Type: "+service.getIsGetAllowed());
System.out.println("Service to serve for POST type: "+service.getIsPostAllowed());
if(service.getRunOnStartup()) System.out.println("Service to serve execute at Server Startup and its priority: "+service.getPriority());
System.out.println("Service required Inject Application Directory: "+service.getInjectApplicationDirectory());
System.out.println("Service required Inject Application Scope: "+service.getInjectApplicationScope());
System.out.println("Service required Inject Session Scope: "+service.getInjectSessionScope());
System.out.println("Service required Inject Request Scope: "+service.getInjectRequestScope());
if(service.getAutoWired()!=null)
{
System.out.println("Service have some AutoWiredProperty: ");
for(AutoWiredWrapper autoWired: service.getAutoWired())
{
System.out.println("AutoWiredProperty Name: "+autoWired.getName());
System.out.println("AutoWiredProperty Type: "+autoWired.getType().getName());
}
}
System.out.println("Service to serve required JSON: "+service.getIsJSONRequired());

}
}
