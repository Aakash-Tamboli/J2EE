package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;

public class AddEmployee extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
boolean isLoggedIn=Authenticate.isLoggedIn(request);
if(isLoggedIn==false) return;
try
{
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/plain");

String name=request.getParameter("name");
int designationCode=Integer.parseInt(request.getParameter("designationCode"));
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
Date dateOfBirth=simpleDateFormat.parse(request.getParameter("dateOfBirth"));
String gender=request.getParameter("gender");
BigDecimal basicSalary=new BigDecimal(request.getParameter("basicSalary"));
String isIndian=request.getParameter("isIndian");
String panNumber=request.getParameter("panNumber");
String aadharCardNumber=request.getParameter("aadharCardNumber");

EmployeeDAO employeeDAO=new EmployeeDAO();
DesignationDAO designationDAO=new DesignationDAO();

try
{
boolean designationCodeExists=designationDAO.designationCodeExists(designationCode);
boolean aadharCardNumberExists=employeeDAO.aadharCardNumberExists(aadharCardNumber);
boolean panNumberExists=employeeDAO.panNumberExists(panNumber);
if(panNumberExists || aadharCardNumberExists || designationCodeExists==false)
{
String str="";
if(panNumberExists) str=str+"PAN Exists";
if(panNumberExists && (aadharCardNumberExists || designationCodeExists==false)) str=str+",";
if(aadharCardNumberExists) str=str+"Aadhar Exists";
if((panNumberExists || aadharCardNumberExists) &&  designationCodeExists==false) str=str+",";
if(designationCodeExists==false) str=str+"Invalid Designation";
pw.print(str);
return;
}
}catch(DAOException daoException)
{
System.out.println("Something problem in employee data may be designation_code does not exists,pan or aadhar already exists"); // remove after testing
}


EmployeeDTO employee=new EmployeeDTO();
employee.setName(name);
employee.setDesignationCode(designationCode);
employee.setDateOfBirth(dateOfBirth);
employee.setGender(gender);
employee.setBasicSalary(basicSalary);
employee.setIsIndian(isIndian.equals("Y"));
employee.setPANNumber(panNumber);
employee.setAadharCardNumber(aadharCardNumber);

try
{
employeeDAO=new EmployeeDAO();
employeeDAO.add(employee);
pw.print("EMPLOYEE ADDED");
}catch(DAOException daoException)
{
System.out.println("Problem: "+daoException);
}

}catch(Exception exception)
{
System.out.println("Problem: "+exception.getMessage()); // remove after testing
}
}
}
