package bobby.test;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.scopes.*;

@Path("/student")
public class Student
{

@GET
@Path("/testFeature")
public void seeData(@RequestParameter("name  ") String name,ApplicationDirectory applicationDirectory,ApplicationScope applicationScope,SessionScope sessionScope,RequestScope requestScope)
{
System.out.println("Student Service starts");
if(name!=null) System.out.println("Yes, Name is provided by framework come from client, i.e name: "+name);
if(applicationDirectory!=null) System.out.println("Yes, ApplicationDirectory is provided");
if(applicationScope!=null) System.out.println("Yes, ApplicationScope is provided");
if(sessionScope!=null) System.out.println("Yes, SessionScope is provided");
if(requestScope!=null) System.out.println("Yes RequestScope is provided");
System.out.println("Student Service ends");
}
}
