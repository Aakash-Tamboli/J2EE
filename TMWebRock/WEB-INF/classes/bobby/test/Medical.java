package bobby.test;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.scope.*;


@InjectApplicationDirectory // it means framework user wants application directory
@Path("/hospital")
public class Medical
{
// it will clearly specify in docs

private ApplicationDirectory applicationDirectory; 
// it will clearly specify in docs that framework user must write Appropraite setter method along with approprite parameter

public void setApplicationDirectory(ApplicationDirectory applicationDirectory)
{
System.out.println("I called by framework thorugh IOC concept");
this.applicationDirectory=applicationDirectory;
}

// return type should be void and zero parameter
@OnStartup(Priority=1)
public void startupFunction1()
{
System.out.println("TMWebRock Successfully executed startupfunction1 at server startup");
}

// return type should be void and zero parameter if you break the rule the you will see message at server window
@OnStartup(Priority=2)
public void startupFunction2()
{
System.out.println("TMWebRock Successfully executed another startup function at server startup");
}

@OnStartup(Priority=-10)
public int startupFunction3(int a)
{
return -1;
}


@Path("/medecineTime")
public void giveMeds()
{
System.out.println("Give Meds service called by TMWebRock Framework");
if(applicationDirectory!=null) System.out.println("Application Directory is injected by TMWebRock Framework");
}
@Path("/doc")
public void callDoctor()
{
// later on
}
}
