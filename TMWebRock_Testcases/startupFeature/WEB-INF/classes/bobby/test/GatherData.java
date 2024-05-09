package bobby.test;
import com.thinking.machines.webrock.annotations.*;


@Path("/gatherData")
public class GatherData
{

@OnStartup(Priority=-1)
public void func1()
{
System.out.println("Func 1 got called");
}

@OnStartup(Priority=0)
public void func2()
{
System.out.println("Func 2 got called");
}


@GET
@Path("/someService")
public void someService()
{
System.out.println("Some services got called");
}
}
