package bobby.test;
import com.thinking.machines.webrock.scope.*;
import com.thinking.machines.webrock.annotations.*;

/*
// This is for unit testcase where we apply SecuredAccess at Class level remember if something is applied on class level then TMWebRock considered as for all class memembers
@SecuredAccess(checkPost="abc.pqr.LMN",guard="efgh")
@Path("/attendenceSystem")
public class AttendenceSystem
{
@Path("/doSomething")
public void doSomething()
{
System.out.println("AttendentSystem/doSomething STARTS");
System.out.println("User is logged in");
System.out.println("AttendentSystem/doSomething ENDS");
}
}
*/

// This is for unit testcase where we apply SecuredAccess at Method level remember if something is applied on class level then TMWebRock considered as for all class memembers
@Path("/attendenceSystem")
public class AttendenceSystem
{
@SecuredAccess(checkPost="abc.pqr.LMN",guard="efgh")
@Path("/doSomething")
public void doSomething()
{
System.out.println("------------------ METHOD LEVEL TESTING AttendentSystem/doSomething STARTS ------------------");
System.out.println("User is logged in");
System.out.println("------------------ METHOD LEVEL TESTING AttendentSystem/doSomething ENDS   ------------------");
}
}
