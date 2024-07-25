package bobby.test;
import com.thinking.machines.webrock.scopes.*;
import com.thinking.machines.webrock.annotations.*;

@Path("/TMTest")
public class TMTest
{
@AutoWired(name="guatamStudent")
private StudentDTO guatamStudent;

@AutoWired(name="sarthakStudent")
private StudentDTO sarthakStudent;

@AutoWired(name="long")
private long a; // for primitive data-type, always take wrapper class in setter method parameter 

@AutoWired(name="int")
private int b; // for primitive data-type, always take wrapper class in setter method parameter 

@AutoWired(name="short")
private short c; // for primitive data-type, always take wrapper class in setter method parameter 

@AutoWired(name="byte")
private byte d;  // for primitive data-type, always take wrapper class in setter method parameter 

@AutoWired(name="double")
private double e; // for primitive data-type, always take wrapper class in setter method parameter 

@AutoWired(name="float") 
private float f; // for primitive data-type, always take wrapper class in setter method parameter 

@AutoWired(name="char")
private char g; // for primitive data-type, always take wrapper class in setter method parameter 
@AutoWired(name="boolean")
private boolean h; // for primitive data-type, always take wrapper class in setter method parameter 


public void setGuatamStudent(StudentDTO student)
{
this.guatamStudent=student;
}

public void setSarthakStudent(StudentDTO student)
{
this.sarthakStudent=student;
}

public void setA(Long l) // for setting primitive data type wrapper class always needed in setter method parameter
{
this.a=l;
}

public void setB(Integer i) // for setting primitive data type wrapper class always needed in setter method parameter
{
this.b=i;
}

public void setC(Short shrt) // for setting primitive data type wrapper class always needed in setter method parameter
{
this.c=shrt;
}

public void setD(Byte b) // for setting primitive data type wrapper class always needed in setter method parameter
{
this.d=b;
}


public void setE(Double d) // for setting primitive data type wrapper class always needed in setter method parameter
{
this.e=d;
}


public void setF(Float f) // for setting primitive data type wrapper class always needed in setter method parameter
{
this.f=f;
}


public void setG(Character c) // // for setting primitive data type wrapper class always needed in setter method parameter
{
this.g=c;
}


public void setH(Boolean b) // for setting primitive data type wrapper class always needed in setter method parameter
{
this.h=b;
}


@GET
@Path("/test1")
@Forward("/dummy.html")
public void test1()
{

System.out.println("Part 2: I got name Service: ~TMTest->test1");
System.out.println("StudentDTO Information");
System.out.println("Student Name: "+guatamStudent.getName());
System.out.println("Student RollNumber: "+guatamStudent.getRollNumber());
System.out.println("Student gender: "+guatamStudent.getGender());

System.out.println("StudentDTO Information");
System.out.println("Student Name: "+sarthakStudent.getName());
System.out.println("Student RollNumber: "+sarthakStudent.getRollNumber());
System.out.println("Student gender: "+sarthakStudent.getGender());


System.out.println("long type: "+a);
System.out.println("int type: "+b);
System.out.println("short type: "+c);
System.out.println("byte type: "+d);
System.out.println("double type: "+e);
System.out.println("float type: "+f);
System.out.println("char type: "+f);
System.out.println("boolean type: "+h);

}
}
