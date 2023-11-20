<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Authenticate />
<tm:Module name='EMPLOYEE' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/Employees.js'></script>
<script>
function populateEmployeesGridTable()
{
var employeesGridTable=document.getElementById('employeesGridTable');
// alert(employeesGridTable);
var employeesGridTableBody=employeesGridTable.getElementsByTagName('tbody')[0];
// alert(employeesGridTableBody);
// alert(employeesGridTableBody.innerHTML);
var employeesGridTableBodyRow=employeesGridTableBody.getElementsByTagName('tr')[0];
// alert(employeesGridTableBodyRow.innerHTML);
employeesGridTableBodyRow.remove(); // remove the ROW from DOM means Page the Row structure still exists in Memory
var cell;
var dynamicRow;
var dynamicRowCells;
var placeHolderFor;
alert(employees.length);
for(var i=0;i<employees.length;i++)
{
dynamicRow=employeesGridTableBodyRow.cloneNode(true); // true for deep cloning
employeesGridTableBody.appendChild(dynamicRow);
dynamicRowCells=dynamicRow.getElementsByTagName("td");
for(var j=0;j<dynamicRowCells.length;j++)
{
cell=dynamicRowCells[j];
placeHolderFor=cell.getAttribute('placeHolderId');
if(placeHolderFor==null) continue;
if(placeHolderFor=="serialNumber") cell.innerHTML=(i+1)+".";
else if(placeHolderFor=="name") cell.innerHTML=employees[i].name;
else if(placeHolderFor=="employeeId") cell.innerHTML=employees[i].employeeId;
else if(placeHolderFor=="designationCode") cell.innerHTML=employees[i].designationCode;
else if(placeHolderFor=="designation") cell.innerHTML=employees[i].designation;
else if(placeHolderFor=="dateOfBirth") cell.innerHTML=employees[i].dateOfBirth;
else if(placeHolderFor=="gender") cell.innerHTML=employees[i].gender;
else if(placeHolderFor=="isIndian") cell.innerHTML=employees[i].isIndian;
else if(placeHolderFor=="basicSalary") cell.innerHTML=employees[i].basicSalary;
else if(placeHolderFor=="panNumber") cell.innerHTML=employees[i].panNumber;
else if(placeHolderFor=="aadharCardNumber") cell.innerHTML=employees[i].aadharCardNumber;
else if(placeHolderFor=="editOption") cell.innerHTML="<td style='text-align:center'><a href='/styletwo/editEmployee?id="+employees[i].employeeId+"'>Edit</a></td>";
else if(placeHolderFor=="deleteOption") cell.innerHTML="<td style='text-align:center'><a href='/styletwo/confirmEmployeeDeletion?id="+employees[i].employeeId+"'>Delete</a></td>";
} // inner loop ends
// add click event on Dynmaic Row
// onClick='selectEmployees(this,employees[i].employeeId);
dynamicRow.addEventListener('click',function(){
var tdCollection=this.getElementsByTagName('td');
for(var k=0;k<tdCollection.length;k++) if(tdCollection[k].getAttribute('placeHolderId')=='employeeId') break;
selectEmployee(this,tdCollection[k].innerHTML);
});
} // outer loop ends


}
window.addEventListener('load',populateEmployeesGridTable);
</script>
<!-- Right Pannel Starts Here -->
<div style='height:60vh;margin-left:140px;margin-right:5px;margin-bottom:px;margin-top:5px;padding:5px;border:1px solid black'>
<h2>Employees</h2>
<div style='height:25vh;margin-left:30px;margin-right:30px;margin-top:5px;padding:5px;border:1px solid white;overflow:scroll'>
<table border='1' id='employeesGridTable' >
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
<tr style='cursor:pointer'>
<td style='text-align:right' placeHolderId='serialNumber'></td>
<td placeHolderId='employeeId'></td>
<td placeHolderId='name' ></td>
<td placeHolderId='designation' ></td>
<td placeHolderId='editOption' style='text-align:center'></td>
<td placeHolderId='deleteOption' style='text-align:center'></td>
</tr>
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
