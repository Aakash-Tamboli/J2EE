package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import com.thinking.machines.hr.dl.*;

public class UpdateEmployee extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/plain");
String id=request.getParameter("id");
String name=request.getParameter("name");
int designationCode=Integer.parseInt(request.getParameter("designationCode"));
String dateOfBirth=request.getParameter("dateOfBirth");
String gender=request.getParameter("gender");
String tmp=request.getParameter("isIndian");
boolean isIndian=false;
if(tmp.equals("Y")) isIndian=true;
BigDecimal basicSalary=new BigDecimal(request.getParameter("basicSalary"));
String panNumber=request.getParameter("panNumber");
String aadharCardNumber=request.getParameter("aadharCardNumber");
EmployeeDAO employeeDAO=new EmployeeDAO();
DesignationDAO designationDAO=new DesignationDAO();
EmployeeDTO employee=new EmployeeDTO();

employee.setEmployeeId(id);
employee.setName(name);
employee.setDesignationCode(designationCode);
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
employee.setDateOfBirth(simpleDateFormat.parse(dateOfBirth));
employee.setGender(gender);
employee.setIsIndian(isIndian);
employee.setBasicSalary(basicSalary);
employee.setPANNumber(panNumber);
employee.setAadharCardNumber(aadharCardNumber);


/*
DEBUGGING
System.out.println("Id: "+employee.getEmployeeId());
System.out.println("Name: "+employee.getName());
System.out.println("Designation Code: "+employee.getDesignationCode());
System.out.println("Date Of Birth: "+employee.getDateOfBirth());
System.out.println("Gender: "+employee.getGender());
System.out.println("Is Indian: "+employee.getIsIndian());
System.out.println("Basic Salary: "+employee.getBasicSalary());
System.out.println("PAN: "+employee.getPANNumber());
System.out.println("AADHAR: "+employee.getAadharCardNumber());
*/

try
{
employeeDAO.update(employee);
pw.print("EMPLOYEE UPDATED");
}catch(DAOException daoException)
{
System.out.println("DAO PROBLEM: "+daoException.getMessage());
pw.print(daoException.getMessage());
}

}catch(Exception exception)
{
System.out.println("SERVER Problem: "+exception.getMessage()); // remove after testing
}
}
}
