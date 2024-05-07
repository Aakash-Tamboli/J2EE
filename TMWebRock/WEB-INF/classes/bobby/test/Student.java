package bobby.test;
import com.thinking.machines.webrock.annotations.*;


@Path("/student")
public class Student
{
@GET
@POST
@Path("/executeOnGetType")
@Forward("/faculty/knowYourFaculty")
public void someProcessOnGetTypeRequest()
{
// @Forward("/abc.jsp")
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
