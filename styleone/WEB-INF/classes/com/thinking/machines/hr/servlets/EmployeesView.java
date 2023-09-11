package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.thinking.machines.hr.dl.*;
import java.util.*;
import java.text.*;

public class EmployeesView extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/html");

pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>HR Application</title>");
pw.println("</head>");
pw.println("<script>");
pw.println("function Employee()");
pw.println("{");
pw.println("this.employeeId=\"\";");
pw.println("this.name=\"\";");
pw.println("this.designationCode=0;");
pw.println("this.designation=\"\";");
pw.println("this.dateOfBirth=\"\";");
pw.println("this.gender=\"\";");
pw.println("this.isIndian=true;");
pw.println("this.basicSalary=0;");
pw.println("this.panNumber=\"\";");
pw.println("this.addharCardNumber=\"\";");
pw.println("}");
pw.println("var selectedRow=null;");
pw.println("var employees=[];");
EmployeeDAO employeeDAO=new EmployeeDAO();
List<EmployeeDTO> employees=employeeDAO.getAll();

SimpleDateFormat simpleDateFormat=new SimpleDateFormat();

int i=0;
for(EmployeeDTO employee: employees)
{
pw.println("var employee=new Employee();");
pw.println("employee.employeeId=\""+employee.getEmployeeId()+"\";");
pw.println("employee.name=\""+employee.getName()+"\";");
pw.println("employee.designationCode="+employee.getDesignationCode()+";");
pw.println("employee.designation=\""+employee.getDesignation()+"\";");
pw.println("employee.dateOfBirth=\""+simpleDateFormat.format(employee.getDateOfBirth())+"\";");
pw.println("employee.gender=\""+employee.getGender()+"\";");
pw.println("employee.isIndian="+employee.getIsIndian()+";");
pw.println("employee.basicSalary="+employee.getBasicSalary()+";");
pw.println("employee.panNumber=\""+employee.getPANNumber()+"\";");
pw.println("employee.aadharCardNumber=\""+employee.getAadharCardNumber()+"\";");
pw.println("employees["+i+"]=employee;");
i++;
}

pw.println("function selectEmployee(row,employeeId)");
pw.println("{");
pw.println("if(row==selectedRow) return;");
pw.println("if(selectedRow!=null)");
pw.println("{");
pw.println("selectedRow.style.background=\"white\";");
pw.println("selectedRow.style.color=\"black\";");
pw.println("}");
pw.println("row.style.background=\"#7C7B7B\";");
pw.println("row.style.color=\"white\";");
pw.println("selectedRow=row;");
pw.println("var i;");
pw.println("for(i=0;i<employees.length;i++)");
pw.println("{");
pw.println("if(employees[i].employeeId==employeeId)");
pw.println("{");
pw.println("break;");
pw.println("}");
pw.println("}");
pw.println("var emp=employees[i];");
pw.println("");
pw.println("document.getElementById(\"detailPanel_employeeId\").innerHTML=emp.employeeId;");
pw.println("document.getElementById(\"detailPanel_name\").innerHTML=emp.name;");
pw.println("document.getElementById(\"detailPanel_designation\").innerHTML=emp.designation;");
pw.println("document.getElementById(\"detailPanel_dateOfBirth\").innerHTML=emp.employeeId;");
pw.println("document.getElementById(\"detailPanel_gender\").innerHTML=emp.gender;");
pw.println("document.getElementById(\"detailPanel_isIndian\").innerHTML=emp.isIndian;");
pw.println("document.getElementById(\"detailPanel_basicSalary\").innerHTML=emp.basicSalary;");
pw.println("document.getElementById(\"detailPanel_panNumber\").innerHTML=emp.panNumber;");
pw.println("document.getElementById(\"detailPanel_aadharCardNumber\").innerHTML=emp.aadharCardNumber;");
pw.println("}");
pw.println("</script>");
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
pw.println("<b>Employees</b> <br><br>");
pw.println("<a href='/styleone/index.html'>HOME</a>");
pw.println("</div>");
pw.println("<!-- left Pannel Ends Here-->");
pw.println("<!-- Right Pannel Starts Here -->");
pw.println("<div style='height:60vh;margin-left:140px;margin-right:5px;margin-bottom:px;margin-top:5px;padding:5px;border:1px solid black'>");
pw.println("<h2>Employees</h2>");
pw.println("");
pw.println("<div style='height:25vh;margin-left:30px;margin-right:30px;margin-top:5px;padding:5px;border:1px solid white;overflow:scroll'>");
pw.println("<table border='1'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th colspan='6' style='text-align:right;padding:5px'><a href='/styleone/getEmployeeAddForm'>Add Employee</a></th>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<th style='width:60px;text-align:center'>S.No</th>");
pw.println("<th style='width:200px;text-align:center'>Id</th>");
pw.println("<th style='width:200px;text-align:center'>Name</th>");
pw.println("<th style='width:200px;text-align:center'>Designation</th>");
pw.println("<th style='width:100px;text-align:center'>Edit</th>");
pw.println("<th style='width:100px;text-align:center'>Delete</th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");

i=1;
for(EmployeeDTO employee: employees)
{
pw.println("<tr style='cursor:pointer' onclick='selectEmployee(this,\""+employee.getEmployeeId()+"\")'>");
pw.println("<td style='text-align:right' onclick='selectEmployee(this,\""+employee.getEmployeeId()+"\")'>"+i+"</td>");
pw.println("<td>"+employee.getEmployeeId()+"</td>");
pw.println("<td>"+employee.getName()+"</td>");
pw.println("<td>"+employee.getDesignation()+"</td>");
pw.println("<td style='text-align:center'><a href='/styleone/editEmployee?id="+employee.getEmployeeId()+"'>Edit</a></td>");
pw.println("<td style='text-align:center'><a href='/styleone/confirmEmployeeDeletion?code="+employee.getEmployeeId()+"'>Delete</a></td>");
pw.println("</tr>");
i++;
}


pw.println("</tbody>");
pw.println("</table>");
pw.println("</div>");
pw.println("<div style='height:auto;width:15hw;margin-left:30px;margin-right:30px;padding:5px;border:1px solid black;'>");
pw.println("<span style='color:red;background-color:black' >Detail</span> <br>");
pw.println("<div style='padding:10px'>");
pw.println("Id: <span id='detailPanel_employeeId'></span> &nbsp;");
pw.println("Name: <span id='detailPanel_name' ></span> &nbsp;");
pw.println("Designation: <span id='detailPanel_designation'></span> &nbsp;");
pw.println("dateOfBirth: <span id='detailPanel_dateOfBirth'></span> &nbsp;");
pw.println("Gender: <span id='detailPanel_gender'></span> <br>");
pw.println("isIndian: <span id='detailPanel_isIndian'></span> &nbsp;");
pw.println("Salary: <span id='detailPanel_basicSalary'></span> &nbsp;");
pw.println("PAN Number: <span id='detailPanel_panNumber'></span> &nbsp;");
pw.println("Aadhar Card Number: <span id='detailPanel_aadharCardNumber'></span> <br>");
pw.println("</div>");
pw.println("");
pw.println("</div>");
pw.println("<!-- Right Pannel Ends Here -->");
pw.println("</div>");
pw.println("<!-- Content-Section Ends Here -->");
pw.println("<!-- Footer Start Here-->");
pw.println("<div style='width:90hw;height:auto;margin:5px;text-align:center;border:1px solid black'>");
pw.println("&copy; Thinking Machines 2023");
pw.println("</div>");
pw.println("<!-- Footer Ends Here -->");
pw.println("</div>");
pw.println("<!-- Main Container ends here");
pw.println("</body>");
pw.println("</html>");





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
