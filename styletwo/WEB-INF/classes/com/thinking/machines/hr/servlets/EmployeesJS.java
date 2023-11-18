package com.thinking.machines.hr.servlets;
import java.util.*;
import com.thinking.machines.hr.bl.*;
import com.thinking.machines.hr.beans.*;
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
File file=new File(servletContext.getRealPath("")+File.separator+"WEB-INF"++"js"+File.separator+"Employees.js");
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"r");
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
out.println(randomAccessFile.readLine());
}
randomAccessFile.close();
List<EmployeeBean> employeeBeans=new EmployeeBL().getAll();
out.println("var employee=null;");
int index=0;
for(EmployeeBean employeeBean: employeeBeans)
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
out.println("employee.panNumber=\""+employeeBean.getPanNumber()+"\";");
out.println("employee.aadharCardNumber=\""+employeeBean.getAadharCardNumber()+"\";");
out.println("employees["+index+"]=employee;");
index++;
}
}catch(Exception exception)
{
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Error.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception ex)
{
// do nothing
}
}
}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
} 
