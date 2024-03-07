package bobby.test;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.scope.*;


@InjectApplicationDirectory
@InjectApplicationScope
@InjectSessionScope
@InjectRequestScope
@Path("/hospital")
public class Medical
{
private ApplicationDirectory applicationDirectory; 
private ApplicationScope applicationScope;
private SessionScope sessionScope;
private RequestScope requestScope;

public void setApplicationDirectory(ApplicationDirectory applicationDirectory)
{
System.out.println("I called by framework thorugh IOC concept");
this.applicationDirectory=applicationDirectory;
}

public void setApplicationScope(ApplicationScope applicationScop)
{
System.out.println("I called by framework through IOC Concept");
this.applicationScope=applicationScope;
}

public void setSessionScope(SessionScope sessionScope)
{
this.sessionScope=sessionScope;
}

public void setRequestScope(RequestContainer requestScope)
{
this.requestScope=requestScope;
}

@OnStartup(Priority=1)
public void startupFunction1()
{
System.out.println("TMWebRock Successfully executed startupfunction1 at server startup");
}

@OnStartup(Priority=2)
public void startupFunction2()
{
System.out.println("TMWebRock Successfully executed another startup function at server startup");
}

// to check it causes exception on servet Window
@OnStartup(Priority=-10)
public int startupFunction3(int a)
{
return -1;
}

@Path("/medecineTime")
@Forward("/Aakash.jsp")
public void giveMeds()
{
System.out.println("Give Meds service called by TMWebRock Framework");
if(applicationDirectory!=null) System.out.println("Application Directory is injected by TMWebRock Framework");
}
}
