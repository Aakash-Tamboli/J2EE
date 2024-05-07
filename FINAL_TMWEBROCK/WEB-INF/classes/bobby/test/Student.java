package bobby.test;
import com.thinking.machines.webrock.annotations.*;


@Path("/student")
public class Student
{
@GET
@POST
@Path("/executeOnGetType")
public void someProcessOnGetTypeRequest()
{
System.out.println("SomProcessOnGetTypeRequest is called");
}

@GET
@POST
@Path("/executeOnPostType")
public void someProcessOnPostTypeRequest()
{
System.out.println("SomProcessOnPostTypeRequest is called");
}
}
