package guard;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.scopes.*;

/*
@InjectApplicationDirectory
@InjectApplicationScope
@InjectSessionScope
@InjectRequestScope
public class Guard
{
private ApplicationDirectory applicationDirectory;
private ApplicationScope applicationScope;
private SessionScope sessionScope;
private RequestScope requestScope;

// setter method is must as per docs
public void setApplicationDirectory(ApplicationDirectory applicationDirectory)
{
System.out.println("ApplicationDirectory Injected By Framework");
this.applicationDirectory=applicationDirectory;
}

public void setApplicationScope(ApplicationScope applicationScope)
{
System.out.println("ApplicationScope Injected By Framework");
this.applicationScope=applicationScope;
}

public void setSessionScope(SessionScope sessionScope)
{
System.out.println("Session Scope Injected By Framework");
this.sessionScope=sessionScope;
}

public void setRequestScope(RequestScope requestScope)
{
System.out.println("Request Scope Injected By Framework");
this.requestScope=requestScope;
}

public void guardBhaiya()
{
String isAuthenticated=(String)sessionScope.getAttribute("isUserAuthenticated");
// as per docs I have to throw SecurityException
if(isAuthenticated==null) throw new SecurityException("User not logged in");
}
}
*/
 
// Testcase-2
public class Guard
{
public void guardBhaiya(ApplicationDirectory applicationDirectory,ApplicationScope applicationScope,SessionScope sessionScope,RequestScope requestScope)
{
String isAuthenticated=(String)sessionScope.getAttribute("isUserAuthenticated");
// as per docs I have to throw SecurityException
if(isAuthenticated==null) throw new SecurityException("User not logged in");
else System.out.println("User is authenticated");
}
}

