package bobby.test;
import com.thinking.machines.webrock.annotations.*;

@Path("/faculty")
public class Faculty
{
@GET
@Path("/knowYourFaculty")
public void getInformationAboutFaculty()
{
System.out.println("getInformationAboutFaculty is called");
}
}
