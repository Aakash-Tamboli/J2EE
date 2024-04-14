package com.thinking.machines.webrock.util;
import com.thinking.machines.webrock.model.*;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.scope.*;
import com.thinking.machines.webrock.pojo.*;
import com.thinking.machines.webrock.util.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.lang.*;
import java.lang.reflect.*;



public class TMAnalyze
{

private static boolean DELETE_PREVIOUSLY_GENERATED_JSFILE=false;

public static List<String> processToFindAllClassesName(String knownFact,String PREFIX)
{
File file=new File(knownFact);
Stack<File> stack=new Stack<>();
List<String> list=new ArrayList<>();
stack.push(file);
String str="";
File[] f;
while(!stack.empty())
{
file=stack.pop();
if(file.isFile())
{
str=file.getName();
if(str.substring(str.length()-6).equals(".class"))
{
str=file.getAbsolutePath().replaceAll(File.separator,".");
str=str.substring(str.indexOf(PREFIX));
str=str.substring(0,str.length()-6);
list.add(str);
}
}
else if(file.isDirectory())
{
f=file.listFiles();
for(File f1: f) stack.push(f1);
}
}// loop ends
return list;
} // ends processToFindAllClassesName


public static void processToEvaluateAutoWiredList(Class c,List<AutoWiredWrapper> autoWiredList)
{
// analyzing property of framework user starts
Field []props=null;
Field property=null;
String name="";
String key="";
Class type=null;

props=c.getDeclaredFields();

// autoWiredList=null;


// requestedParameterPropertyList=null;

if(props!=null && props.length!=0)
{
// autoWiredList=new ArrayList<>();
// requestedParameterPropertyList=new ArrayList<>();

for(int i=0;i<props.length;i++)
{
if(props[i].isAnnotationPresent(AutoWired.class))
{
// validation pending
property=props[i];
name=props[i].getAnnotation(AutoWired.class).name();
type=props[i].getType();
autoWiredList.add(new AutoWiredWrapper(property,name,type));
}
} // loop ends
// if(requestedParameterPropertyList.size()==0) requestedParameterPropertyList=null;
} // scanning props of Class
// analyzing property of framework user ends
} // Ends processToEvaluateAutoWiredList



public static void processToEvaluateInjectRequestParameter(Class c,List<RequestedParameterProperty> requestedParameterPropertyList)
{
// analyzing property of framework user starts
Field []props=null;
Field property=null;
String name="";
String key="";
Class type=null;

props=c.getDeclaredFields();

// autoWiredList=null;

// requestedParameterPropertyList=null;

if(props!=null && props.length!=0)
{
// autoWiredList=new ArrayList<>();
// requestedParameterPropertyList=new ArrayList<>();

for(int i=0;i<props.length;i++)
{
if(props[i].isAnnotationPresent(InjectRequestParameter.class))
{
key=props[i].getAnnotation(InjectRequestParameter.class).value();
if(key==null || key.length()==0) continue; // if user not giving key then why should I kept on my ds
type=props[i].getType();
name=props[i].getName();
requestedParameterPropertyList.add(new RequestedParameterProperty(type,key,name));
}
} // loop ends
} // scanning props of Class
// analyzing property of framework user ends
} // Ends processToEvaluateInjectRequestParameter


public static Guard processToEvaluateGuardFeature(Class c)
{

SecuredAccess securedAccess=null;
String guardClassNameWithPackage="";
String []tmp=null;
String guardClassName="";
String guardClassService="";
Parameter []ps=null;
boolean valid=false;

Class guardClass=null;
Method guardService=null;

Guard guard=null;



// Guard feature implementation starts for class level
// validation required
if(c.isAnnotationPresent(SecuredAccess.class))
{
// later on finalize the project we will break into components  hence following logic is repeating two time, where ?  see on method section
securedAccess=(SecuredAccess)c.getAnnotation(SecuredAccess.class);

guardClassNameWithPackage=securedAccess.checkPost().trim();

tmp=guardClassNameWithPackage.split("[.]"); // validation pending

guardClassName=tmp[tmp.length-1];  // validation pending

// System.out.println("With Package: "+guardClassNameWithPackage);
// System.out.println("Your Guard Class name is: "+guardClassName);

try
{
// System.out.println("Hi");
guardClass=Class.forName(guardClassNameWithPackage);
// System.out.println("Bye");
}catch(Exception exception)
{
System.out.println("Problem in your guard class name");
System.out.println("Problem: "+exception.getMessage());
}

guardClassService=securedAccess.guard().trim();

// System.out.println("Your Guard Class name is: "+guardClassService);

try
{

for(Method gs: guardClass.getDeclaredMethods())
{
// System.out.println(1);
if(guardClassService.equalsIgnoreCase(gs.getName()))
{
// System.out.println(2);
ps=gs.getParameters();
valid=true;
// System.out.println(3);
for(int i=0;i<ps.length;i++)
{
// System.out.println(4+i);
if(
!(
ps[i].getType().equals(ApplicationDirectory.class) ||
ps[i].getType().equals(ApplicationScope.class) ||
ps[i].getType().equals(SessionScope.class) ||
ps[i].getType().equals(RequestScope.class)
)
)
{
valid=false;
break;
}
}
if(valid) guardService=gs;
// System.out.println("Value of Valid: "+valid);
break;
}
}

// System.out.println("RG Headphone");

if(guardService==null) throw new Exception("Some serious mistake commit by bobby");

guard=new Guard(guardClass,guardService);

}catch(Exception exception)
{
System.out.println("Problem in your guard method name");
}
}
else
{
guard=null;
}
// Guard feature implementation ends for class level ends
return guard;
}


public static String processOfGeneratingPOJOForJS(Class c) // check later on
{
String buffer="";

buffer=buffer+"class "+c.getSimpleName()+"{\n";
Field []fields=c.getDeclaredFields();
if(fields!=null && fields.length!=0)
{
// I know POJO Generally contains props. and respective getter and setter I know \n does not effect on js code but still for clearty
buffer=buffer+"constructor(";
for(int i=0;i<fields.length;i++)
{
buffer=buffer+fields[i].getName();
if(i+1!=fields.length) buffer=buffer+",";
}
buffer=buffer+"){\n";
for(int i=0;i<fields.length;i++) buffer=buffer+"this."+fields[i].getName()+"="+fields[i].getName()+";\n";
buffer=buffer+"}\n";

for(int i=0;i<fields.length;i++)
{
buffer=buffer+"set"+StringUtility.capitalize(fields[i].getName())+"("+fields[i].getName()+"){\n";
buffer=buffer+"this."+fields[i].getName()+"="+fields[i].getName()+";\n";
buffer=buffer+"}\n";
}
}

buffer=buffer+"}\n"; // js class braces

return buffer;
}

public static String processOfGeneratingPOJOServiceForJS(Class c) // check later on private or public
{
String buffer="";
RequestParameter requestParamerter=null;

if(c.isAnnotationPresent(Path.class)==false) return ""; // I try independent each module as much as possible
Path p1=(Path)c.getAnnotation(Path.class);
String mainServicePath=p1.value().trim();
if(mainServicePath==null && mainServicePath.length()==0) return "";
if((mainServicePath.charAt(0)=='/')==false) mainServicePath="/"+mainServicePath;

buffer=buffer+"class "+c.getSimpleName()+"{\n";


Method []methods=c.getDeclaredMethods();

if(methods!=null && methods.length!=0)
{
// POJO Service generally contains the methods which act like API between dl and pl/bl hence I assume it only contains methods and logic which is slightly change for JS POJO Service because it returns promise.
// validation critera while writing algo.
// class and method both should have path annoation applied
String tmpBuffer="";
String subServicePath="";
Parameter []parameters=null;
String requestParameterValue="UNABLE TO RETERVE";

for(int i=0;i<methods.length;i++)
{
if(methods[i].isAnnotationPresent(Path.class))
{
p1=(Path)methods[i].getAnnotation(Path.class);
subServicePath=p1.value().trim();
if(subServicePath==null || subServicePath.length()==0) continue;
if((subServicePath.charAt(0)=='/')==false) subServicePath="/"+subServicePath;
tmpBuffer=tmpBuffer+methods[i].getName()+"(";
parameters=methods[i].getParameters();


if(parameters!=null && parameters.length!=0)
{
tmpBuffer=tmpBuffer+StringUtility.uncapitalize(parameters[0].getType().getSimpleName());
} // parameter part ends
tmpBuffer=tmpBuffer+"){\n";



tmpBuffer=tmpBuffer+"let promise=new Promise((resolve,reject)=>{\n";
tmpBuffer=tmpBuffer+"let address='/TMWebRock/school/"+StringUtility.uncapitalize(c.getSimpleName())+subServicePath+"';\n";

if(methods[i].isAnnotationPresent(GET.class))
{
tmpBuffer=tmpBuffer+"let methodType='GET';\n";
if(parameters!=null && parameters.length!=0)
{
if(parameters[0].isAnnotationPresent(RequestParameter.class)) 
{
requestParameterValue=parameters[0].getAnnotation(RequestParameter.class).value().trim();
}
tmpBuffer=tmpBuffer+"let dataToBeSend='"+requestParameterValue+"='+"+StringUtility.uncapitalize(parameters[0].getType().getSimpleName())+";\n";
}
else
{
tmpBuffer=tmpBuffer+"let dataToBeSend='';\n";
}
}
else
{
tmpBuffer=tmpBuffer+"let methodType='POST';\n";
tmpBuffer=tmpBuffer+"let dataToBeSend=JSON.stringify("+StringUtility.uncapitalize(parameters[0].getType().getSimpleName())+");\n";
}



tmpBuffer=tmpBuffer+"$.ajax({\n";
tmpBuffer=tmpBuffer+"url: address,\n";
tmpBuffer=tmpBuffer+"type: methodType,\n";
tmpBuffer=tmpBuffer+"data: dataToBeSend,\n";
tmpBuffer=tmpBuffer+"success: resolve,\n";
tmpBuffer=tmpBuffer+"error: reject\n";
tmpBuffer=tmpBuffer+"});\n";


tmpBuffer=tmpBuffer+"});\n";
tmpBuffer=tmpBuffer+"return promise;\n";
tmpBuffer=tmpBuffer+"}\n";
} // validation
}// loop ends
buffer=buffer+tmpBuffer;
} // if ends


buffer=buffer+"}\n";

return buffer;
}


public static void processOfClassIntoJSFile(Class c,String JSFILENAME,ServletContext servletContext) // check later on private or public
{
String jsContent;
String jsPath=servletContext.getRealPath(".")+File.separator+"WEB-INF"+File.separator+"js";
File file=new File(jsPath);
if(file.exists()==false)
{
if(file.mkdir()==false)
{
// Ideally later on I will create Exception then it may be generate exception to server window
}
else
{
file.setReadable(true);
file.setWritable(true);
}
}

jsPath=jsPath+File.separator+JSFILENAME;

file=new File(jsPath);

if(file.exists() && DELETE_PREVIOUSLY_GENERATED_JSFILE==false) // I have to re-evaluate the logic of this js file generation and deletion
{
file.delete();
DELETE_PREVIOUSLY_GENERATED_JSFILE=true;
}


if(c.isAnnotationPresent(SendPOJOToClient.class)) jsContent=processOfGeneratingPOJOForJS(c);
else jsContent=processOfGeneratingPOJOServiceForJS(c);


System.out.println("------------------------ START ----------------");

System.out.println("\n\n\n"+jsContent+"\n\n\n");

System.out.println("------------------------ END ----------------");

RandomAccessFile randomAccessFile=null;
try
{
randomAccessFile=new RandomAccessFile(file,"rw");
randomAccessFile.seek(randomAccessFile.length());
randomAccessFile.writeBytes(jsContent);
randomAccessFile.writeBytes("\n");
randomAccessFile.close();
}catch(Exception exception)
{
// Ideally later on I will create Exception then it may be generate exception to server window
}
}


private static List<RequestedParameter> processToAnalyzeParameterOfMethod(Parameter []parameter)
{
String name=null;
Class type=null;
List<RequestedParameter> requestedParameterList=null;

if(parameter!=null && parameter.length!=0)
{
requestedParameterList=new ArrayList<>();
for(int i=0;i<parameter.length;i++)
{
if(parameter[i].isAnnotationPresent(RequestParameter.class))
{
name=parameter[i].getAnnotation(RequestParameter.class).value(); // validation pending
type=parameter[i].getType();
requestedParameterList.add(new RequestedParameter(type,name,true));
}
else
{
name=""; // empty string
type=parameter[i].getType();
requestedParameterList.add(new RequestedParameter(type,name,false));
} // if-else ends
} // loop ends
} // if ends
return requestedParameterList;
} // processToAnalyzeParameterOfMethod ends


public static boolean processToAnalyzeJSONWillComeFromClientSide(Parameter []parameter,Method m,boolean isGetAllowed,boolean isPostAllowed,String str2)
{
// bug found i.e think about it if method does not have parameter then what will be the value of parameter varaible is it null or reffering to zero size array
// and if parameter variable reffering to the zero size array or null then in both condition check does your logic works fine ?
Class type=null;

if(parameter!=null)
{
if((isGetAllowed || isPostAllowed) && str2.length()>0 && m.isAnnotationPresent(Forward.class)==false && m.isAnnotationPresent(OnStartup.class)==false)
{

if(parameter.length==0)
{
if((isGetAllowed || isPostAllowed) && str2.length()>0 && m.isAnnotationPresent(Forward.class)==false && m.isAnnotationPresent(OnStartup.class)==false)
{
System.out.println("Yes JSON will might/may come from Client, not have parameter to recive I just to call");
return true;
}
}
else
{
int count=0;
for(int i=0;i<parameter.length;i++)
{
type=parameter[i].getType();
if(
!(
type.equals(ApplicationDirectory.class) ||
type.equals(ApplicationScope.class) ||
type.equals(SessionScope.class) ||
type.equals(RequestScope.class) ||
type.equals(long.class) ||
type.equals(Long.class) ||
type.equals(int.class) ||
type.equals(Integer.class) ||
type.equals(short.class) ||
type.equals(Short.class) ||
type.equals(byte.class) ||
type.equals(Byte.class) ||
type.equals(double.class) ||
type.equals(Double.class) ||
type.equals(float.class) ||
type.equals(Float.class) ||
type.equals(char.class) ||
type.equals(boolean.class) ||
type.equals(Boolean.class) ||
type.equals(String.class)
)
)
{
count++;
}
}
if(count==1)
{
System.out.println("Yes JSON will might/may come from Client, also have parameter to recive I just have to parse it and call");
// service.setIsJSONRequired(true); // it means according to docs only one parameter is different, which user want data into that.
return true;
}
else
{
// if more than 1 variable different then can i send false see guideline in sir video then decide
}
}
}
}
// piece 4.4.4 Here I think check JSON feature implementation  ends
return false;
}


public static void processToPopulateDataStructures(List<String> list,List<Service> startupList,ServletContext servletContext,String JSFILENAME)
{
Class c;
Path path;
OnStartup onStartup;
Forward forward;
String str=null;
String str2=null;
String key=null;

// String name=null; later I will remove this comment

boolean isGetAllowed=false;
boolean isPostAllowed=false;
String forwardTo=null;
int priority;
Service service=null;
Field property=null;
Class type=null;
Parameter []parameter=null;
List<RequestedParameter> requestedParameterList=null;
List<AutoWiredWrapper> autoWiredList=null;
List<RequestedParameterProperty> requestedParameterPropertyList=null;
Guard guard=null;
SecuredAccess securedAccess=null;
boolean injectApplicationDirectory=false;
boolean injectApplicationScope=false;
boolean injectSessionScope=false;
boolean injectRequestScope=false;
boolean isServiceReturns=false;


int objectCount=1; // DEBUGGING PUPOSE

WebRockModel model=new WebRockModel();

try
{


for(String classes: list)
{
c=Class.forName(classes);
if(c.isAnnotationPresent(SendPOJOToClient.class) || c.isAnnotationPresent(SendPOJOServiceToClient.class)) processOfClassIntoJSFile(c,JSFILENAME,servletContext);

autoWiredList=new ArrayList<>();
processToEvaluateAutoWiredList(c,autoWiredList);
// Why Should I keep empty list in my Service Class object that's why I nullify
if(autoWiredList.size()==0) autoWiredList=null;

requestedParameterPropertyList=new ArrayList<>();
processToEvaluateInjectRequestParameter(c,requestedParameterPropertyList);
// Why Should I keep empty list in my Service Class object that's why I nullify
if(requestedParameterPropertyList.size()==0) requestedParameterPropertyList=null;


if(c.isAnnotationPresent(Path.class))
{

// piece 1 starts
path=(Path)c.getAnnotation(Path.class);
str=path.value();
if(str.length()==0) continue;
if(str.charAt(0)!='/') str="/"+str; // for less error prone code
if(c.isAnnotationPresent(InjectApplicationDirectory.class)) injectApplicationDirectory=true;
if(c.isAnnotationPresent(InjectApplicationScope.class)) injectApplicationScope=true;
if(c.isAnnotationPresent(InjectSessionScope.class)) injectSessionScope=true;
if(c.isAnnotationPresent(InjectRequestScope.class)) injectRequestScope=true;

// piece 1 ends

// piece 2 starts

if(c.isAnnotationPresent(GET.class))
{
isGetAllowed=true;
isPostAllowed=false;
}
else if(c.isAnnotationPresent(POST.class))
{
isPostAllowed=true;
isGetAllowed=false;
}

// piece 2 ends

// piece 3 starts

guard=processToEvaluateGuardFeature(c);

// piece 3 ends


// piece 4 starts

// method loop starts
for(Method m: c.getDeclaredMethods())
{
// piece 4.1 analysis of return type starts
if(m.getReturnType().equals(void.class)) isServiceReturns=false;
else isServiceReturns=true;
// piece 4.1 analysis of return type ends



// piece 4.2 Analysis of Parameter in Method starts
parameter=m.getParameters();
requestedParameterList=TMAnalyze.processToAnalyzeParameterOfMethod(parameter);
// piece 4.2 Analysis of Parmeter in Method ends


// piece 4.3 checking The currently observing method is execute at server startup starts

if(m.isAnnotationPresent(OnStartup.class)) priority=m.getAnnotation(OnStartup.class).Priority();
else priority=-1;

// piece 4.3 checking The currently observing method is execute at server startup ends


// piece 4.4 checking The currently oberserving method have a Path annoation or not starts

if(m.isAnnotationPresent(Path.class))
{
path=m.getAnnotation(Path.class);
str2=path.value();
if(str2.length()==0) continue;
if(str2.charAt(0)!='/') str2="/"+str2;
// piece 4.4.1 checking GET OR POST Annotation on method if & only if user does not applied on class level. starts
if(c.isAnnotationPresent(GET.class)==false && c.isAnnotationPresent(POST.class)==false) // it means class level does not have niether @GET nor @POST so I have to check at method level
{
if(m.isAnnotationPresent(GET.class))
{
isGetAllowed=true;
isPostAllowed=false;
}
else if(m.isAnnotationPresent(POST.class))
{
isPostAllowed=true;
isGetAllowed=false;
}
else
{
isGetAllowed=true;
isPostAllowed=true;
}
} // piece 4.4.1 checking GET OR POST Annotation on method if & only if user does not applied on class level. ends

// piece 4.4.2 checking Does user wants to forward request after process current observing method starts

if(m.isAnnotationPresent(Forward.class))
{
forward=m.getAnnotation(Forward.class);
forwardTo=forward.value().trim();
if(forwardTo.length()==0) forwardTo=null;
if(forwardTo.charAt(0)!='/') forwardTo="/"+forwardTo;
}

// piece 4.4.2 checking Does user wants to forward request after process current observing method ends




// piece 4.4.3 Guard feature implementation at method level starts

if(guard==null) // if user does not applied Guard Annotation at Class level then This piece of code will execute
{

if(m.isAnnotationPresent(SecuredAccess.class))
{

// later on finalize the project we will break into components  hence following logic is repeating two time, where ?  see on class section
securedAccess=(SecuredAccess)m.getAnnotation(SecuredAccess.class);
String guardClassName=securedAccess.checkPost().trim();

Class guardClass=null;
try
{
guardClass=Class.forName(guardClassName);
}catch(Exception exception)
{
System.out.println("Problem in your guard class name");
}

String guardClassService=securedAccess.guard().trim();

Method guardService=null;

try
{

for(Method gs: guardClass.getDeclaredMethods())
{
if(guardClassService.equalsIgnoreCase(gs.getName()))
{
Parameter []ps=gs.getParameters();
boolean valid=true;
for(int i=0;i<ps.length;i++)
{
if(
!(
ps[i].equals(ApplicationDirectory.class) ||
ps[i].equals(ApplicationScope.class) ||
ps[i].equals(SessionScope.class) ||
ps[i].equals(RequestScope.class)
)
)
{
valid=false;
break;
}
}
if(valid) guardService=gs;
break;
}
}
if(guardService==null) throw new Exception("Some serious mistake commit by bobby");
guard=new Guard(guardClass,guardService);


}catch(Exception exception)
{
System.out.println("Problem un your guard method name");
guard=null;
}

}
else
{
guard=null;
}
}

// piece 4.4.3 Guard feature implementation at method level ends

service=new Service(c,str+str2,forwardTo,m,isServiceReturns,isGetAllowed,isPostAllowed,false,priority,injectApplicationDirectory,injectApplicationScope,injectSessionScope,injectRequestScope,autoWiredList,requestedParameterList,requestedParameterPropertyList,false,guard);

// piece 4.4.4 JSON feature implementation starts

boolean isJSONComeFromClientSide=processToAnalyzeJSONWillComeFromClientSide(parameter,m,isGetAllowed,isPostAllowed,str2);

service.setIsJSONRequired(isJSONComeFromClientSide);

// piece 4.4.4 Here I think check JSON feature implementation  ends



System.out.println("---------------------"+objectCount+"---------------------");
System.out.println("Service Object created with ");
System.out.println("ClassName: "+c.getSimpleName());
System.out.println("Full Path of service: "+str+str2);
System.out.println("Serivce Forward To: "+forwardTo);
System.out.println("Method which considerd as service: "+m.getName());
System.out.println("Is This Service returns: "+isServiceReturns);
System.out.println("For This Service GET ALLOWED: "+isGetAllowed);
System.out.println("For This Service POST ALLOwED: "+isPostAllowed);
System.out.println("Startup Service "+false);
System.out.println("prioity No: "+priority);
System.out.println("Class Required Inject Application Directory: "+injectApplicationDirectory);
System.out.println("Class Required Inject Application Scope: "+injectApplicationScope);
System.out.println("Class Required Inject Session Scope: "+injectSessionScope);
System.out.println("Class Required Inject Request Scope: "+injectRequestScope);
System.out.println("Does Class Have Property: "+autoWiredList);
System.out.println("Does Class property uses Inject Request Parameter annotation: "+requestedParameterPropertyList);
System.out.println("Does Class's Service tell that JSON will come from client side:"+service.getIsJSONRequired());
System.out.println("---------------------"+objectCount+"---------------------");
objectCount++;

model.dataStructure.put(str+str2,service);

} // piece 4.4 checking The currently oberserving method have a Path annoation or not ends
else
{
if(priority!=-1)
{
System.out.println("---------------------"+objectCount+"---------------------");
System.out.println("Service Object created with ");
System.out.println("ClassName: "+c.getSimpleName());
System.out.println("Full Path of service: "+"ONLY_FOR_STARTUP");
System.out.println("Serivce Forward To: "+"ONLY_FOR_STARTUP");
System.out.println("Method which considerd as Startup service: "+m.getName());
System.out.println("For This Service GET ALLOWED: "+false);
System.out.println("For This Service POST ALLOwED: "+false);
System.out.println("Startup Service "+true);
System.out.println("prioity No: "+priority);
System.out.println("---------------------"+objectCount+"---------------------");
objectCount++;
service=new Service(c,"ONLY_FOR_STARTUP","ONLY_FOR_STARTUP",m,false,false,false,true,priority,injectApplicationDirectory,injectApplicationScope,injectSessionScope,injectRequestScope,autoWiredList,requestedParameterList,requestedParameterPropertyList,false,null);
startupList.add(service); // think about min-heap Aakash If Sir give you instruction you can implement it
}
else
{
System.out.println("TMWebRock Framework (later on in form of exception) says I found Service Method("+m.getName()+") in Service Class("+c.getName()+") which niether have Path annotation applied nor onStartup Annotation Applied (Aknowlegdement)");
}
}
// for the sake of clarity, I set method-loop used variables to default value for next cycle
// for self refference I don't reset isGetAllowed & isPostAllowed and guard variables because if user applied annoation at class level then by mistake I break the code.
isServiceReturns=false;
parameter=null;
requestedParameterList=null;
priority=-1;
path=null;
str2=null;
forward=null;
forwardTo=null; 
} // method loop ends
// piece 4 ends
} // PATH if block ends
else
{
System.out.println("Path Annotation not Found on: "+c.getName()+" Class");
}
// for next cycle
injectApplicationDirectory=false;
injectApplicationScope=false;
injectSessionScope=false;
injectRequestScope=false;
} // outer loop ends


}catch(ClassNotFoundException cnfe)
{
System.out.println("Problem");
}



servletContext.setAttribute("dataStructure",model);
System.out.println("Total Services in HashMap is: "+model.dataStructure.size());

} // processToPopulateDataStructures

}; // Class Ends

