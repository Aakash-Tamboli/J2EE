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
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/html");

String name=request.getParameter("name");
int designationCode=Integer.parseInt(request.getParameter("designationCode"));
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
Date dateOfBirth=simpleDateFormat.parse(request.getParameter("dateOfBirth"));
String gender=request.getParameter("gender");
BigDecimal basicSalary=new BigDecimal(request.getParameter("basicSalary"));
String isIndian=request.getParameter("isIndian");
if(isIndian==null) isIndian="N";
String panNumber=request.getParameter("panNumber");
String aadharCardNumber=request.getParameter("aadharCardNumber");
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
EmployeeDAO employeeDAO=new EmployeeDAO();
employeeDAO.add(employee);


pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>HR Application</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- Main Container Start here-->");
pw.println("<div style='width:90hw;height:auto;border:1px solid black'>");
pw.println("<!-- Header Starts Here-->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");
pw.println("<img src='/styleone/images/tm.png' style='float:left;width:40px;height:40px'>");
pw.println("<div style='margin-top:9px;margin-bottom:9px;font-size:20pt'>");
pw.println("Thinking Machines");
pw.println("</div>");
pw.println("</div>");
pw.println("<!-- Header Ends Here-->");
pw.println("<!-- Content-Section Starts here-->");
pw.println("<div style='width:90hw;height:70vh;margin:5px;border:1px solid white'>");
pw.println("<!-- Left Pannel Starts Here -->");
pw.println("<div style='height:60vh;margin:5px;float:left;padding:5px;border:1px solid black'>");
pw.println("<a href='/styleone/designationsView'>Designations</a> <br>");
pw.println("<a href='/styleone/employeesView'>Employees</a><br><br>");
pw.println("<a href='/styleone/index.html'> HOME </a>");
pw.println("</div>");
pw.println("<!-- left Pannel Ends Here-->");
pw.println("<!-- Right Pannel Starts Here -->");
pw.println("<div style='height:60vh;margin-left:140px;margin-right:5px;margin-bottom:px;margin-top:5px;padding:5px;border:1px solid black'>");
pw.println("<h3>Notification</h3>");
pw.println("Employee Added <br>");
pw.println("<form action='/styleone/getEmployeeAddForm' style='float:left;'>");
pw.println("You Want To Add More");
pw.println("<button type='submit'>Yes</button>");
pw.println("</form>");
pw.println("<form action='/styleone/employeesView'>");
pw.println("<button type='submit'>No!!!</button>");
pw.println("</form>");
pw.println("</div>");
pw.println("<!-- Right Pannel Ends Here -->");
pw.println("</div>");
pw.println("<!-- Content-Section Ends Here -->");
pw.println("<!-- Footer Start Here-->");
pw.println("<div style='width:90hw;height:auto;margin:5px;text-align:center;border:1px solid black'>");
pw.println("&copy Thinking Machines 2023");
pw.println("</div>");
pw.println("<!-- Footer Ends Here -->");
pw.println("</div>");
pw.println("<!-- Main Container ends here");
pw.println("</body>");
pw.println("</html>");





}catch(DAOException daoException)
{
// return html which consist of repective fields
}

}catch(Exception exception)
{
System.out.println("Problem: "+exception.getMessage()); // remove after testing
}
}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}
