package bobby.test;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.scopes.*;

@InjectApplicationDirectory
@InjectApplicationScope
@InjectSessionScope
@InjectRequestScope
@Path("/student")
public class Student
{
private ApplicationDirectory applicationDirectory;
private ApplicationScope applicationScope;
private SessionScope sessionScope;
private RequestScope requestScope;

// For Using @InjectDepedencyName setter Method must be written

public void setterApplicationDirectory(ApplicationDirectory applicationDirectory)
{
this.applicationDirectory=applicationDirectory;
}

public void setApplicationScope(ApplicationScope applicationScope)
{
this.applicationScope=applicationScope;
}

public void setSessionScope(SessionScope sessionScope)
{
this.sessionScope=sessionScope;
}

public void setRequestScope(RequestScope requestScope)
{
this.requestScope=requestScope;
}

@GET
@Path("/testingInjectDependenciesFeature")
public void testingInjectDependenciesFeature()
{
if(applicationDirectory!=null) System.out.println("application Directory refference varaible is not null, that means it's injected by framework");
if(applicationScope!=null) System.out.println("application Scope refference varaible is not null, that means it's injected by framework");
if(sessionScope!=null) System.out.println("session Scope refference varaible is not null, that means it's injected by framework");
if(requestScope!=null) System.out.println("request scope refference varaible is not null, that means it's injected by framework");
}
}
