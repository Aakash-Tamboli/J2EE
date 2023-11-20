<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Authenticate />
<tm:Module name='EMPLOYEE' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/Employees.js'></script>
<!-- Right Pannel Starts Here -->
<div style='height:60vh;margin-left:140px;margin-right:5px;margin-bottom:px;margin-top:5px;padding:5px;border:1px solid black'>
<h2>Employees</h2>
<div style='height:25vh;margin-left:30px;margin-right:30px;margin-top:5px;padding:5px;border:1px solid white;overflow:scroll'>
<table border='1'>
<thead>
<tr>
<th colspan='6' style='text-align:right;padding:5px'><a href='/styletwo/EmployeeAddForm.jsp'>Add Employee</a></th>
</tr>
<tr>
<th style='width:60px;text-align:center'>S.No</th>
<th style='width:200px;text-align:center'>Id</th>
<th style='width:200px;text-align:center'>Name</th>
<th style='width:200px;text-align:center'>Designation</th>
<th style='width:100px;text-align:center'>Edit</th>
<th style='width:100px;text-align:center'>Delete</th>
</tr>
</thead>
<tbody>
<tm:EntityList populatorClass='com.thinking.machines.hr.bl.EmployeeBL' populatorMethod='getAll' name='employeeBean'>
<tr style='cursor:pointer' onclick='selectEmployee(this,"${employeeBean.employeeId}")'>
<td style='text-align:right' onclick='selectEmployee(this,"${employeeBean.employeeId}")'>${serialNumber}</td>
<td>${employeeBean.employeeId}</td>
<td>${employeeBean.name}</td>
<td>${employeeBean.designation}</td>
<td style='text-align:center'><a href='/styletwo/editEmployee?id=${employeeBean.employeeId}'>Edit</a></td>
<td style='text-align:center'><a href='/styletwo/confirmEmployeeDeletion?id=${employeeBean.employeeId}'>Delete</a></td>
</tr>
</tm:EntityList>
</tbody>
</table>
</div>
<div style='height:auto;width:15hw;margin-left:30px;margin-right:30px;padding:5px;border:1px solid black;'>
<span style='color:red;background-color:black' >Detail</span> <br>
<div style='padding:10px'>
Id: <span id='detailPanel_employeeId'></span> &nbsp;
Name: <span id='detailPanel_name' ></span> &nbsp;
Designation: <span id='detailPanel_designation'></span> &nbsp;
dateOfBirth: <span id='detailPanel_dateOfBirth'></span> &nbsp;
Gender: <span id='detailPanel_gender'></span> <br>
isIndian: <span id='detailPanel_isIndian'></span> &nbsp;
Salary: <span id='detailPanel_basicSalary'></span> &nbsp;
PAN Number: <span id='detailPanel_panNumber'></span> &nbsp;
Aadhar Card Number: <span id='detailPanel_aadharCardNumber'></span> <br>
</div>
</div>
<!-- Right Pannel Ends Here -->
<jsp:include page='MasterPageBottomSection.jsp' />
