package bobby.test;
import com.thinking.machines.webrock.annotations.*;

@Path("/student")
public class Student
{

@InjectRequestParameter("name")
private String studentName;

@InjectRequestParameter("rollNumber")
private int rollNumber;

@InjectRequestParameter("nothing")
private int i;

// setter method is compulsory to get data

public void setStudentName(String name)
{
this.studentName=name;
}
public void setRollNumber(int rollNumber)
{
this.rollNumber=rollNumber;
}

public void setI(int i)
{
this.i=i;
}

@GET
@Path("/testingInjectRequestParameterFeatureOnProperty")
@Forward("/dummy.html")
public void testingInjectRequestParameterFeatureOnProperty()
{
System.out.println("Student Service Starts");
System.out.println("Student Name: "+studentName);
System.out.println("Student Roll: "+rollNumber);
System.out.println("Value of i: "+i);
System.out.println("Student Service ends");
}
}
