package com.thinking.machines.hr.dl;
import java.math.*;
import java.util.*;

public class EmployeeDTO implements java.io.Serializable,Comparable<EmployeeDTO>
{
private String employeeId;
private String name;
private int designationCode;
private String designation;
private Date dateOfBirth;
private boolean isIndian;
private String gender;
private BigDecimal basicSalary;
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
public void setDateOfBirth(Date dateOfBirth)
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
public void setBasicSalary(BigDecimal basicSalary)
{
this.basicSalary=basicSalary;
}
public void setPANNumber(String panNumber)
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
public Date getDateOfBirth()
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
public BigDecimal getBasicSalary()
{
return this.basicSalary;
}
public String getPANNumber()
{
return this.panNumber;
}
public String getAadharCardNumber()
{
return this.aadharCardNumber;
}
public boolean equals(Object other)
{
if(!(other instanceof EmployeeDTO)) return false;
EmployeeDTO employee=(EmployeeDTO)other;
return this.employeeId.equalsIgnoreCase(employee.getEmployeeId());
}
public int hashCode()
{
return this.employeeId.hashCode();
}
public int compareTo(EmployeeDTO employee)
{
return this.employeeId.compareToIgnoreCase(employee.getEmployeeId());
}
}
