package com.thinking.machines.hr.beans;
import java.math.*;
import java.util.*;
import java.text.*;


public class EmployeeBean implements java.io.Serializable,Comparable<EmployeeBean>
{
private String employeeId;
private String name;
private int designationCode;
private String designation;
private String dateOfBirth;
private boolean isIndian;
private String gender;
private String basicSalary;
private String panNumber;
private String aadharCardNumber;
public void setEmployeeId(String employeeId)
{
this.employeeId=employeeId;
}
public void setName(String name)
{
this.name=name;
}
public void setDesignationCode(int designationCode)
{
this.designationCode=designationCode;
}
public void setDesignation(String designation)
{
this.designation=designation;
}
/*
Following getter/setter method, because of guidline of beans i.e accept as string,
get as String, both getter and setter should follow camel case.
*/
public void setDateOfBirth(String dateOfBirth)
{
this.dateOfBirth=dateOfBirth;
}
public void setIsIndian(boolean isIndian)
{
this.isIndian=isIndian;
}
public void setGender(String gender)
{
this.gender=gender;
}
/*
Following getter/setter method, because of guidline of beans i.e accept as string,
get as String, both getter and setter should follow camel case.
*/

public void setBasicSalary(String basicSalary)
{
this.basicSalary=basicSalary;
}
/*
Following getter/setter method, because of guidline of beans i.e accept as string,
get as String, both getter and setter should follow camel case.
*/
public void setPanNumber(String panNumber)
{
this.panNumber=panNumber;
}

public void setAadharCardNumber(String aadharCardNumber)
{
this.aadharCardNumber=aadharCardNumber;
}
public String getEmployeeId()
{
return this.employeeId;
}
public String getName()
{
return this.name;
}
public int getDesignationCode()
{
return this.designationCode;
}
public String getDesignation()
{
return this.designation;
}
/*
Following getter/setter method, because of guidline of beans i.e accept as string,
get as String, both getter and setter should follow camel case.
*/
public String getDateOfBirth()
{
return this.dateOfBirth;
}
public boolean getIsIndian()
{
return this.isIndian;
}
public String getGender()
{
return this.gender;
}
/*
Following getter/setter method, because of guidline of beans i.e accept as string,
get as String, both getter and setter should follow camel case.
*/
public String getBasicSalary()
{
return this.basicSalary;
}
public String getPanNumber()
{
return this.panNumber;
}
public String getAadharCardNumber()
{
return this.aadharCardNumber;
}
public boolean equals(Object other)
{
if(!(other instanceof EmployeeBean)) return false;
EmployeeBean employee=(EmployeeBean)other;
return this.employeeId.equalsIgnoreCase(employee.getEmployeeId());
}
public int hashCode()
{
return this.employeeId.hashCode();
}
public int compareTo(EmployeeBean employee)
{
return this.employeeId.compareToIgnoreCase(employee.getEmployeeId());
}
}
