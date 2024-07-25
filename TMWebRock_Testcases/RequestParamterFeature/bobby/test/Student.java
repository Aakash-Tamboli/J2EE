package bobby.test;
import com.thinking.machines.webrock.annotations.*;

@Path("/student")
public class Student
{

@GET
@Path("/seeData")
public void seeData(@RequestParameter("   ") String name,char gender,@RequestParameter("rollNumber") int rollNumber,@RequestParameter("I.Q") String studentIQ)
{
System.out.println("Student Service starts");
System.out.println("Name: "+name);
System.out.println("RollNumber: "+rollNumber);
System.out.println("Gender: "+gender);
System.out.println("I.Q: "+studentIQ);
System.out.println("Student Service ends");
}
}
