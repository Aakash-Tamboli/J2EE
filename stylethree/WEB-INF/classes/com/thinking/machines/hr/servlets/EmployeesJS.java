package com.thinking.machines.hr.servlets;
import java.util.*;
import com.thinking.machines.hr.dl.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class EmployeesJS extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter out=response.getWriter();
response.setContentType("text/javascript");
ServletContext servletContext=getServletContext();
File file=new File(servletContext.getRealPath("")+File.separator+"WEB-INF"+File.separator+"js"+File.separator+"Employees.js");
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"r");
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
out.println(randomAccessFile.readLine());
}
randomAccessFile.close();
List<EmployeeDTO> employeeList=new EmployeeDAO().getAll();
out.println("var employee=null;");
int index=0;
for(EmployeeDTO employeeBean: employeeList)
{
out.println("employee=new Employee();");
out.println("employee.employeeId=\""+employeeBean.getEmployeeId()+"\";");
out.println("employee.name=\""+employeeBean.getName()+"\";");
out.println("employee.designationCode="+employeeBean.getDesignationCode()+";");
out.println("employee.designation=\""+employeeBean.getDesignation()+"\";");
out.println("employee.dateOfBirth=\""+employeeBean.getDateOfBirth()+"\";");
out.println("employee.gender=\""+employeeBean.getGender()+"\";");
out.println("employee.isIndian="+employeeBean.getIsIndian()+";");
out.println("employee.basicSalary="+employeeBean.getBasicSalary()+";");
out.println("employee.panNumber=\""+employeeBean.getPANNumber()+"\";");
out.println("employee.aadharCardNumber=\""+employeeBean.getAadharCardNumber()+"\";");
out.println("employees["+index+"]=employee;");
index++;
}
// For Creating Combo Box for Designations
out.println("function Designation()");
out.println("{");
out.println("var title='';");
out.println("var code=0;");
out.println("}");
out.println("var designations=[];");
out.println("var designation=null;");
int i=0;
List<DesignationDTO> designations=new DesignationDAO().getAll();

for(DesignationDTO designation: designations)
{
out.println("designation=new Designation();");
out.println("designation.title=\""+designation.getTitle()+"\"");
out.println("designation.code="+designation.getCode());
out.println("designations["+i+"]=designation;");
i++;
}

}catch(Exception exception)
{
System.out.println(exception); // remove after testing
}
}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
} 
