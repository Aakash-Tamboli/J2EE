package bobby.test;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.scopes.*;

@InjectRequestScope
@Path("/student")
public class Student
{
private RequestScope requestScope;

public void setRequestScope(RequestScope requestScope)
{
this.requestScope=requestScope;
}

@GET
@Path("/putDataIntoRequestScope")
@Forward("/TMTest/test1")
public void putDataIntoRequestScope()
{
StudentDTO guatamStudent=new StudentDTO();
guatamStudent.setName("Guatam");
guatamStudent.setRollNumber(101);
guatamStudent.setGender('M');

StudentDTO sarthakStudent=new StudentDTO();
sarthakStudent.setName("Sarthak");
sarthakStudent.setRollNumber(102);
sarthakStudent.setGender('M');


long a=100; 
int b=1020; 
short c=12; 
byte d=3;
double e=98.43;
float f=78.32f;
char g='A';
boolean h=true;


requestScope.setAttribute("guatamStudent",guatamStudent);
requestScope.setAttribute("sarthakStudent",sarthakStudent);
requestScope.setAttribute("long",a);
requestScope.setAttribute("int",b);
requestScope.setAttribute("short",c);
requestScope.setAttribute("byte",d);
requestScope.setAttribute("double",e);
requestScope.setAttribute("float",f);
requestScope.setAttribute("char",g);
requestScope.setAttribute("boolean",h);
System.out.println("Part 1: I put data into request scope by ~Student->putDataIntoRequestScope");
}
}
