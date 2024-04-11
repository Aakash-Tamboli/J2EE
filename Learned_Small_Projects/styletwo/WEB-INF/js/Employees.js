console.log("HIIIIIIIIIIIIIIIIIIIIII");

function Employee()
{
this.employeeId="";
this.name="";
this.designationCode=0;
this.designation="";
this.dateOfBirth="";
this.gender="";
this.isIndian=true;
this.basicSalary=0;
this.panNumber="";
this.addharCardNumber="";
}
var selectedRow=null;
var employees=[];
function selectEmployee(row,employeeId)
{
if(row==selectedRow) return;
if(selectedRow!=null)
{
selectedRow.style.background="white";
selectedRow.style.color="black";
}
row.style.background="#7C7B7B";
row.style.color="white";
selectedRow=row;
var i;
for(i=0;i<employees.length;i++)
{
if(employees[i].employeeId==employeeId)
{
break;
}
}
var emp=employees[i];
document.getElementById("detailPanel_employeeId").innerHTML=emp.employeeId;
document.getElementById("detailPanel_name").innerHTML=emp.name;
document.getElementById("detailPanel_designation").innerHTML=emp.designation;
document.getElementById("detailPanel_dateOfBirth").innerHTML=emp.employeeId;
document.getElementById("detailPanel_gender").innerHTML=emp.gender;
document.getElementById("detailPanel_isIndian").innerHTML=emp.isIndian;
document.getElementById("detailPanel_basicSalary").innerHTML=emp.basicSalary;
document.getElementById("detailPanel_panNumber").innerHTML=emp.panNumber;
document.getElementById("detailPanel_aadharCardNumber").innerHTML=emp.aadharCardNumber;
}

function createDynamicRowClickHandler(rowAddress,employeeId)
{
return function(){
selectEmployee(rowAddress,employeeId);
};
}

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
dynamicRow.onclick=createDynamicRowClickHandler(dynamicRow,employees[i].employeeId);
} // outer loop ends
}
window.addEventListener('load',populateEmployeesGridTable);

