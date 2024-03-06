package bobby.test;
import com.thinking.machines.webrock.annotations.*;

@Path("/student")
public class Student 
{

@GET
@Forward("/Aakash.jsp")
@Path("/add")
public void add()
{
System.out.println("Hurray [GET] TMWebRock invoke this service");
// later on
}
@POST
@Path("/add2")
public void add2()
{
System.out.println("Hurray [POST] TMWebRock invoke this service");
// later on
}
// later on
}
