package bobby.test;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.scopes.*;


// If SecuredAccess at Class level
// then TMWebRock considered as for all class services

@SecuredAccess(checkPost="guard.Guard",guard="guardBhaiya")
@Path("/A")
public class A
{
@Path("/someService")
public void someService()
{
System.out.println("------------------ CLASS LEVEL TESTING AttendentSystem/doSomething STARTS ------------------");
System.out.println("Guard saysL: User is logged in");
System.out.println("------------------ CLASSS LEVEL TESTING AttendentSystem/doSomething ENDS  ------------------");
}
}

/*

// If SecuredAccess at Method level 
// then TMWebRock only that particular service.
@Path("/A")
public class A
{
@SecuredAccess(checkPost="guard.Guard",guard="guardBhaiya")
@Path("/someService")
public void someService()
{
System.out.println("------------------ METHOD LEVEL TESTING AttendentSystem/doSomething STARTS ------------------");
System.out.println("User is logged in");
System.out.println("------------------ METHOD LEVEL TESTING AttendentSystem/doSomething ENDS   ------------------");
}
}

*/
