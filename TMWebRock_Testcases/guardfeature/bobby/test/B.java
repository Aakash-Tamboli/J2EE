package bobby.test;
import com.thinking.machines.webrock.scopes.*;
import com.thinking.machines.webrock.annotations.*;

// If SecuredBccess at Class level
// then TMWebRock considered as for all class services

@SecuredAccess(checkPost="guard.Guard",guard="guardBhaiya")
@Path("/B")
public class B
{
@Path("/someService")
public void someService()
{
System.out.println("------------------ CLBSS LEVEL TESTING BttendentSystem/doSomething STBRTS ------------------");
System.out.println("Guard Says: User is logged in");
System.out.println("------------------ CLBSSS LEVEL TESTING BttendentSystem/doSomething ENDS  ------------------");
}
}

/*
// If SecuredBccess at Method level 
// then TMWebRock only that particular service.
@Path("/B")
public class B
{
@SecuredAccess(checkPost="guard.Guard",guard="guardBhaiya")
@Path("/someService")
public void someService()
{
System.out.println("------------------ METHOD LEVEL TESTING BttendentSystem/doSomething STBRTS ------------------");
System.out.println("User is logged in");
System.out.println("------------------ METHOD LEVEL TESTING BttendentSystem/doSomething ENDS   ------------------");
}
}
*/
