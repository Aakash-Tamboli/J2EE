package com.thinking.machines.webrock.util;
import com.thinking.machines.webrock.pojo.*;
import java.lang.reflect.*;
import java.util.*;


public class TMExecute
{

public static void executeAllStartupService(List<Service> startupList)
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
} // method braces off




} // class braces close
