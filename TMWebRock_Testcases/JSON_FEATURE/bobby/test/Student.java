package bobby.test;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.scopes.*;


@Path("/student")
public class Student
{
// When Argument is one and its complex type
@Path("/testingJSONFeature1")
public void testingJSONFeature(Faculty faculty)
{
System.out.println("Student Service Starts");
System.out.println("Faculty Name: "+faculty.getName());
System.out.println("Faculty Code: "+faculty.getId());
System.out.println("Student Service ends");
}

@Path("/testingJSONFeature2")
public void testingJSONFeature(ApplicationDirectory applicationDirectory,Faculty faculty,RequestScope requestScope,SessionScope sessionScope,ApplicationScope applicationScope)
{
System.out.println("Student Service Starts");
if(applicationDirectory!=null) System.out.println("applicationDirectory given by Framework");
if(applicationScope!=null) System.out.println("Application Scope given by Framework");
if(sessionScope!=null) System.out.println("Session Scope given by Framework");
if(requestScope!=null) System.out.println("Request Scope given by Framework");
System.out.println("Faculty Name: "+faculty.getName());
System.out.println("Faculty Code: "+faculty.getId());
System.out.println("Student Service ends");
}
}
