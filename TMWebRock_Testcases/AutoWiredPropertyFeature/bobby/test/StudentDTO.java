package bobby.test;

public class StudentDTO
{
private String name;
private int rollNumber;
private char gender;

public StudentDTO()
{
this.name="";
this.rollNumber=-1;
this.gender=' ';
}

public void setName(String name)
{
this.name=name;
}

public void setRollNumber(int rollNumber)
{
this.rollNumber=rollNumber;
}

public void setGender(char gender)
{
this.gender=gender;
}

public String getName()
{
return name;
}

public int getRollNumber()
{
return rollNumber;
}

public char getGender()
{
return gender;
}
}
