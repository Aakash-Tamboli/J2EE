package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.text.*;
import com.thinking.machines.hr.dl.*;

public class EditEmployeeForm extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/html");
String id=request.getParameter("id");
EmployeeDAO employeeDAO;
employeeDAO=new EmployeeDAO();
EmployeeDTO employee=null;
try
{
employee=employeeDAO.getByEmployeeId(id);
}catch(DAOException daoException)
{
sendBackView(response);
}

pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>HR Application</title>");
pw.println("<script>");
pw.println("function validateForm(frm)");
pw.println("{");
pw.println("var firstInvalidComponent=null;");
pw.println("var valid=true;");
pw.println("var name=frm.name.value.trim();");
pw.println("var nameErrorSection=document.getElementById('nameErrorSection');");
pw.println("nameErrorSection.innerHTML='';");
pw.println("if(name.length==0)");
pw.println("{");
pw.println("nameErrorSection.innerHTML='Name Required';");
pw.println("valid=false;");
pw.println("firstInvalidComponent=frm.name;");
pw.println("}");
pw.println("var designationCode=frm.designationCode.value;");
pw.println("var designationCodeErrorSection=document.getElementById('designationCodeErrorSection');");
pw.println("designationCodeErrorSection.innerHTML='';");
pw.println("if(designationCode==-1)");
pw.println("{");
pw.println("designationCodeErrorSection.innerHTML='Desigantion Required';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.designationCode;");
pw.println("}");
pw.println("");
pw.println("");
pw.println("var dateOfBirth=frm.dateOfBirth.value;");
pw.println("var dateOfBirthErrorSection=document.getElementById('dateOfBirthErrorSection');");
pw.println("dateOfBirthErrorSection.innerHTML='';");
pw.println("if(dateOfBirth.length==0)");
pw.println("{");
pw.println("dateOfBirthErrorSection.innerHTML='Select date of birth';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.dateOfBirth;");
pw.println("}");
pw.println("");
pw.println("");
pw.println("var genderErrorSection=document.getElementById('genderErrorSection');");
pw.println("genderErrorSection.innerHTML='';");
pw.println("if(frm.gender[0].checked==false && frm.gender[1].checked==false)");
pw.println("{");
pw.println("genderErrorSection.innerHTML='Select gender';");
pw.println("valid=false;");
pw.println("}");
pw.println("");
pw.println("");
pw.println("var basicSalary=frm.basicSalary.value.trim();");
pw.println("var basicSalaryErrorSection=document.getElementById('basicSalaryErrorSection');");
pw.println("basicSalaryErrorSection.innerHTML='';");
pw.println("if(basicSalary.length==0)");
pw.println("{");
pw.println("basicSalaryErrorSection.innerHTML='Basic Salary required';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;");
pw.println("}");
pw.println("else");
pw.println("{");
pw.println("var v='0123456789';");
pw.println("var e=0;");
pw.println("var isBasicSalaryValid=true;");
pw.println("while(e<basicSalary.length)");
pw.println("{");
pw.println("if(v.indexOf(basicSalary.charAt(e))==-1)");
pw.println("{");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;");
pw.println("isBasicSalaryValid=false;");
pw.println("break;");
pw.println("}");
pw.println("e++;");
pw.println("}");
pw.println("if(isBasicSalaryValid)");
pw.println("{");
pw.println("var dot=basicSalary.indexOf('.');");
pw.println("if(dot!=-1)");
pw.println("{");
pw.println("var numberOfFractions=basicSalary.length-(dot+1);");
pw.println("if(numberOfFractions>2)");
pw.println("{");
pw.println("basicSalaryErrorSection.innerHTML='Invalid basic salary';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;");
pw.println("}");
pw.println("}");
pw.println("}");
pw.println("}");
pw.println("var panNumber=frm.panNumber.value.trim();");
pw.println("var panNumberErrorSection=document.getElementById('panNumberErrorSection');");
pw.println("panNumberErrorSection.innerHTML='';");
pw.println("if(panNumber.length==0)");
pw.println("{");
pw.println("panNumberErrorSection.innerHTML='PAN number required';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.panNumber;");
pw.println("}");
pw.println("var aadharCardNumber=frm.aadharCardNumber.value.trim();");
pw.println("var aadharCardNumberErrorSection=document.getElementById('aadharCardNumberErrorSection');");
pw.println("aadharCardNumberErrorSection.innerHTML='';");
pw.println("if(aadharCardNumber.length==0)");
pw.println("{");
pw.println("aadharCardNumberErrorSection.innerHTML='Aadhar Card number required';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.aadharCardNumber;");
pw.println("}");
pw.println("if(!valid) firstInvalidComponent.focus();");
pw.println("return valid");
pw.println("}");
pw.println("");
pw.println("function cancelUpdation()");
pw.println("{");
pw.println("document.getElementById('cancelUpdation').submit();");
pw.println("}");
pw.println("</script>");
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
pw.println("<a href='/styleone/designationsView'>Designations</a><br>");
pw.println("<b>Employees</b><br><br>");
pw.println("<a href='/styleone/index.html'> HOME </a>");
pw.println("</div>");
pw.println("<!-- left Pannel Ends Here-->");
pw.println("<!-- Right Pannel Starts Here -->");
pw.println("<div style='height:60vh;margin-left:140px;margin-right:5px;margin-bottom:px;margin-top:5px;padding:5px;border:1px solid black'>");
pw.println("<h2>Employee (Add Module)</h2>");
pw.println("<form method='post' action='/styleone/editEmployee' onsubmit='return validateForm(this)'>");
pw.println("<table>");
pw.println("<tr>");
pw.println("<td>Name: </td>");
pw.println("<td><input type='text' id='name' name='name' maxlength='50' size='51' value='"+employee.getName()+"'>");
pw.println("<span id='nameErrorSection' style='color:red'></span></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Designation: </td>");
pw.println("<td><select id='designationCode' name='designationCode'>");
pw.println("<option value='-1'>&lt;Select Designation&gt;</option>");

DesignationDAO designationDAO=new DesignationDAO();
List<DesignationDTO> designations;
designations=designationDAO.getAll();

int employeeDesignationCode=employee.getDesignationCode();
designations.forEach((designation)->{
if(employeeDesignationCode==designation.getCode())
{
pw.println("<option selected value='"+designation.getCode()+"'>"+designation.getTitle()+"</option>");
}
else
{
pw.println("<option value='"+designation.getCode()+"'>"+designation.getTitle()+"</option>");
}
});

pw.println("</select>");
pw.println("<span id='designationCodeErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Date of Birth: </td>");
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
String date=simpleDateFormat.format(employee.getDateOfBirth());
pw.println("<td><input type='date' id='dateOfBirth' name='dateOfBirth' value='"+date+"'>");
pw.println("<span id='dateOfBirthErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Gender</td>");

if(employee.getGender().equals("M"))
{
pw.println("<td><input type='radio' id='male' name='gender' value='M' checked> Male &nbsp; &nbsp; &nbsp; &nbsp;");
pw.println("<input type='radio' id='female' name='gender' value='F'>Female <span id='genderErrorSection' style='color:red'></span>");
}
else
{
pw.println("<td><input type='radio' id='male' name='gender' value='M'> Male &nbsp; &nbsp; &nbsp; &nbsp;");
pw.println("<input type='radio' id='female' name='gender' value='F' checked>Female <span id='genderErrorSection' style='color:red'></span>");
}

pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Basic Salary</td>");
pw.println("<td>");
pw.println("<input type='text' style='text-align:right' name='basicSalary' id='basicSalary' maxlength='12' size='13' value='"+employee.getBasicSalary().toPlainString()+"'>");
pw.println("<span id='basicSalaryErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");

pw.println("<tr>");
pw.println("<td>IsIndian: </td>");
pw.println("<td>");

if(employee.getIsIndian())
{
pw.println("<input type='checkbox' name='isIndian' id='isIndian' value='Y' checked>");
}
else
{
pw.println("<input type='checkbox' name='isIndian' id='isIndian' value='Y'>");
}
pw.println("<span id='isIndianErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");

pw.println("<tr>");
pw.println("<td>PAN Number</td>");
pw.println("<td>");
pw.println("<input type='text' id='panNumber' name='panNumber' maxlength='15' size='16' value='"+employee.getPANNumber()+"'>");
pw.println("<span id='panNumberErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Aadhar Card Number</td>");
pw.println("<td>");
pw.println("<input type='text' id='aadharCardNumber' name='aadharCardNumber' maxlength='15' size='16' value='"+employee.getAadharCardNumber()+"'>");
pw.println("<span id='aadharCardNumberErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<td colspan='2'><button type='submit'>Update</button> &nbsp; &nbsp; &nbsp;");
pw.println("<button type='button' onclick='cancelUpdation()'>Cancel</button>");
pw.println("</td>");
pw.println("</table>");
pw.println("</form>");
pw.println("<form id='cancelUpdation' method='post' action='/styleone/employeesView'>");
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

}catch(Exception exception)
{
System.out.println(exception.getMessage()); // remove after testing
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}

public void sendBackView(HttpServletResponse response)
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
pw.println("<td style='text-align:center'><a href='/styleone/confirmEmployeeDeletion?id="+employee.getEmployeeId()+"'>Delete</a></td>");
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
}
