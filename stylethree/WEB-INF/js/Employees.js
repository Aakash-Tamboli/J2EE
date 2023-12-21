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
document.getElementById("detailPanel_dateOfBirth").innerHTML=emp.dateOfBirth;
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
else if(placeHolderFor=="editOption") cell.innerHTML=`<a href="javascript:editEmployee('${employees[i].employeeId}')">Edit</a>`;
else if(placeHolderFor=="deleteOption") cell.innerHTML=`<a href="javascript:deleteEmployee('${employees[i].employeeId}')">Delete</a>`;
} // inner loop ends
// add click event on Dynmaic Row
// onClick='selectEmployees(this,employees[i].employeeId);
dynamicRow.onclick=createDynamicRowClickHandler(dynamicRow,employees[i].employeeId);
} // outer loop ends
}
window.addEventListener('load',populateEmployeesGridTable);
function editEmployee(employeeId)
{
var employeeListDivision=document.getElementById('employeeListDivision');
var infoBox=document.getElementById('infoBox');
var moduleHeading=document.getElementById('moduleHeading');
employeeListDivision.remove();
infoBox.remove();
moduleHeading.innerHTML="Employee (Edit Module)";
var employee=null;
for(var i=0;i<employees.length;i++)
{
if(employees[i].employeeId==employeeId)
{
employee=employees[i];
break;
}
}

var nameSpan=document.createElement('span');
nameSpan.innerHTML="Name: &emsp;";
var inputName=document.createElement('input');
inputName.id='inputName';
inputName.size=51
inputName.maxLength=50
inputName.value=employee.name;

var errorNameSpan=document.createElement('span');
errorNameSpan.classList.add('error');
var l1b=document.createElement('br');
var l2b=document.createElement('br');
var l3b=document.createElement('br');
var l4b=document.createElement('br');
var l5b=document.createElement('br');
var l6b=document.createElement('br');
var l7b=document.createElement('br');
var l8b=document.createElement('br');
var designationSpan=document.createElement('span');
designationSpan.innerHTML='Designation: &emsp;';
var designationsOptions=document.createElement('select');
designationsOptions.name='designationCode';
designationsOptions.id='designationCode';
var options=document.createElement('option');
options.value=-1;
options.innerHTML="Select Designation";
designationsOptions.appendChild(options);
for(var i=0;i<designations.length;i++)
{
options=document.createElement('option');
options.value=designations[i].code;
options.innerHTML=designations[i].title;
if(employee.designationCode==designations[i].code) options.setAttribute('selected','selected');
designationsOptions.appendChild(options);
}
var designationsOptionsErrorSpan=document.createElement('span');
designationsOptionsErrorSpan.classList.add('error');

var dateOfBirthSpan=document.createElement('span');
dateOfBirthSpan.innerHTML='Date Of Birth: &emsp;';
var inputDOB=document.createElement('input');
inputDOB.type='date';
inputDOB.id='dateOfBirth';
inputDOB.value=employee.dateOfBirth;

var dateOfBirthErrorSpan=document.createElement('span');
dateOfBirthErrorSpan.classList.add('error');

var genderSpan=document.createElement('span');
genderSpan.innerHTML="Gender: &emsp;";
var inputGenderForMale=document.createElement('input')
;
inputGenderForMale.id='inputGender';
inputGenderForMale.type='radio';
inputGenderForMale.name='gender';
inputGenderForMale.value='M';
var genderMaleSpan=document.createElement('span');
genderMaleSpan.innerHTML='Male &emsp;';

var inputGenderForFemale=document.createElement('input');
inputGenderForFemale.id='inputGender';
inputGenderForFemale.type='radio';
inputGenderForFemale.name='gender';
inputGenderForFemale.value='F';
var genderFemaleSpan=document.createElement('span');
genderFemaleSpan.innerHTML='Female';
var genderErrorSpan=document.createElement('span');
genderErrorSpan.classList.add('error');

if(employee.gender=='M') inputGenderForMale.setAttribute('checked','checked');
else inputGenderForFemale.setAttribute('checked','checked');


var basicSalarySpan=document.createElement('span');
basicSalarySpan.innerHTML='Basic Salary: &emsp;';
var basicSalaryInputBox=document.createElement('input');
basicSalaryInputBox.type='text';
basicSalaryInputBox.name='basicSalary';
basicSalaryInputBox.maxlength=12;
basicSalaryInputBox.size=13;
basicSalaryInputBox.style='text-align:right';
basicSalaryInputBox.value=employee.basicSalary;

var basicSalaryError=document.createElement('span');
basicSalaryError.classList.add('error');

var isIndianSpan=document.createElement('span');
isIndianSpan.innerHTML='IsIndian: &emsp;';
var isIndianCheckbox=document.createElement('input');
isIndianCheckbox.type='checkbox';
isIndianCheckbox.name='isIndian';
isIndianCheckbox.value='Y';
if(employee.isIndian) isIndianCheckbox.setAttribute('checked','checked');


var panNumberSpan=document.createElement('span');
panNumberSpan.innerHTML='PAN Number: &emsp;';
var panNumberInput=document.createElement('input');
panNumberInput.type='text';
panNumberInput.maxlength=15;
panNumberInput.length=16;
panNumberInput.value=employee.panNumber;
var panNumberErrorSpan=document.createElement('span');
panNumberErrorSpan.classList.add('error');

var aadharCardNumberSpan=document.createElement('span');
aadharCardNumberSpan.innerHTML='Aadhar Card Number: &emsp;';
var aadharCardNumberInput=document.createElement('input');
aadharCardNumberInput.type='text';
aadharCardNumberInput.maxlength=15;
aadharCardNumberInput.size=16;
aadharCardNumberInput.value=employee.aadharCardNumber;
var aadharCardNumberErrorSpan=document.createElement('span');
aadharCardNumberErrorSpan.classList.add('error');


var saveButton=document.createElement('button');
saveButton.innerHTML='Update';
saveButton.onclick=function(){
var name=inputName.value;
var designationCode=designationsOptions.value;
var dateOfBirth=inputDOB.value;
var genders=document.getElementsByName('gender');
var gender='M';
var isIndian='N';
var panNumber=panNumberInput.value;
var aadharCardNumber=aadharCardNumberInput.value;
if(isIndianCheckbox.checked) isIndian='Y';
for(var i=0;i<genders.length;i++)
{
if(genders[i].checked) gender=genders[i].value;
}
var basicSalary=basicSalaryInputBox.value;
basicSalary=basicSalary.trim();
//
var firstInvalidComponent=null;
var valid=true;
var nameErrorSection=errorNameSpan;
nameErrorSection.innerHTML='';
if(name.length==0)
{
nameErrorSection.innerHTML='Name Required';
valid=false;
firstInvalidComponent=inputName;
}

var designationCodeErrorSection=designationsOptionsErrorSpan;
designationCodeErrorSection.innerHTML='';
if(designationCode==-1)
{
designationCodeErrorSection.innerHTML='Desigantion Required';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=designationsOptions;
}

var dateOfBirthErrorSection=dateOfBirthErrorSpan;
dateOfBirthErrorSection.innerHTML='';
if(dateOfBirth.length==0)
{
dateOfBirthErrorSection.innerHTML='Select date of birth';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=inputDOB;
}

var genderErrorSection=genderErrorSpan;
genderErrorSection.innerHTML='';
if(genders[0].checked==false && genders[1].checked==false)
{
genderErrorSection.innerHTML='Select gender';
valid=false;
}


var basicSalaryErrorSection=basicSalaryError;
basicSalaryErrorSection.innerHTML='';
if(basicSalary.length==0)
{
basicSalaryErrorSection.innerHTML='Basic Salary required';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=basicSalaryInputBox;
}
else
{
var v='0123456789.';
var e=0;
var isBasicSalaryValid=true;
while(e<basicSalary.length)
{
if(v.indexOf(basicSalary.charAt(e))==-1)
{
valid=false;
basicSalaryErrorSection.innerHTML='Invalid basic salary';
if(firstInvalidComponent==null) firstInvalidComponent=basicSalaryInputBox;
isBasicSalaryValid=false;
break;
}
e++;
}
if(isBasicSalaryValid)
{
var dot=basicSalary.indexOf('.');
if(dot!=-1)
{
var numberOfFractions=basicSalary.length-(dot+1);
if(numberOfFractions>2)
{
basicSalaryErrorSection.innerHTML='Invalid basic salary';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=basicSalaryInputBox;
}
}
}
}

var panNumberErrorSection=panNumberErrorSpan;
panNumberErrorSection.innerHTML='';
if(panNumber.length==0)
{
panNumberErrorSection.innerHTML='PAN number required';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=panNumberInput;
}

var aadharCardNumberErrorSection=aadharCardNumberErrorSpan;
aadharCardNumberErrorSection.innerHTML='';
if(aadharCardNumber.length==0)
{
aadharCardNumberErrorSection.innerHTML='Aadhar Card number required';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=aadharCardNumberInput;
}
if(!valid) firstInvalidComponent.focus();
if(valid==false) return;

var dataToSend='id='+employee.employeeId;
dataToSend=dataToSend+'&name='+encodeURI(name);
dataToSend=dataToSend+'&designationCode='+encodeURI(designationCode);
dataToSend=dataToSend+'&dateOfBirth='+encodeURI(dateOfBirth);
dataToSend=dataToSend+'&gender='+encodeURI(gender);
dataToSend=dataToSend+'&isIndian='+encodeURI(isIndian);
dataToSend=dataToSend+'&basicSalary='+encodeURI(basicSalary);
dataToSend=dataToSend+'&panNumber='+encodeURI(panNumber);
dataToSend=dataToSend+'&aadharCardNumber='+encodeURI(aadharCardNumber);
var xmlHttpRequest=new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function(){
if(this.readyState==4)
{
if(this.status==200)
{
var responseData=this.responseText;
if(responseData=='EMPLOYEE UPDATED')
{
var formObj=document.createElement('form');
document.body.appendChild(formObj);
formObj.method='POST';
formObj.action='/stylethree/Employees.jsp';
formObj.submit();
}
else
{
alert(responseData);
}
}
else
{
alert('some problem');
}
}
};
xmlHttpRequest.open('POST','updateEmployee',true);
xmlHttpRequest.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
xmlHttpRequest.send(dataToSend);
};

var span=document.createElement('span');
span.innerHTML='&emsp;';

var cancelButton=document.createElement('button');
cancelButton.innerHTML='Cancel';
cancelButton.onclick=function(){
var formObj=document.createElement('form');
document.body.appendChild(formObj);
formObj.method='POST';
formObj.action='/stylethree/Employees.jsp';
formObj.submit();
};

var rightPanel=document.getElementById('right-panel');
rightPanel.appendChild(nameSpan);
rightPanel.appendChild(inputName);
rightPanel.appendChild(errorNameSpan);
rightPanel.appendChild(l1b);
rightPanel.appendChild(designationSpan);
rightPanel.appendChild(designationsOptions);
rightPanel.appendChild(designationsOptionsErrorSpan);
rightPanel.appendChild(l2b);
rightPanel.appendChild(dateOfBirthSpan);
rightPanel.appendChild(inputDOB);
rightPanel.appendChild(dateOfBirthErrorSpan);
rightPanel.appendChild(l3b);
rightPanel.appendChild(genderSpan);
rightPanel.appendChild(inputGenderForMale);
rightPanel.appendChild(genderMaleSpan);
rightPanel.appendChild(inputGenderForFemale);
rightPanel.appendChild(genderFemaleSpan);
rightPanel.appendChild(genderErrorSpan);
rightPanel.appendChild(l4b);
rightPanel.appendChild(basicSalarySpan);
rightPanel.appendChild(basicSalaryInputBox);
rightPanel.appendChild(basicSalaryError);
rightPanel.appendChild(l5b);
rightPanel.appendChild(isIndianSpan);
rightPanel.appendChild(isIndianCheckbox);
rightPanel.appendChild(l6b);
rightPanel.appendChild(panNumberSpan);
rightPanel.appendChild(panNumberInput);
rightPanel.appendChild(panNumberErrorSpan);
rightPanel.appendChild(l7b);
rightPanel.appendChild(aadharCardNumberSpan);
rightPanel.appendChild(aadharCardNumberInput);
rightPanel.appendChild(aadharCardNumberErrorSpan);
rightPanel.appendChild(l8b);
rightPanel.appendChild(saveButton);
rightPanel.appendChild(span);
rightPanel.appendChild(cancelButton);
}

function deleteEmployee(employeeId)
{
var rightPanel=document.getElementById('right-panel');
var employeeListDivision=document.getElementById('employeeListDivision');
var infoBox=document.getElementById('infoBox');
var moduleHeading=document.getElementById('moduleHeading');
employeeListDivision.remove();
infoBox.remove();
moduleHeading.innerHTML="Employee (Delete Module)";
var employee=null;
for(var i=0;i<employees.length;i++)
{
if(employees[i].employeeId==employeeId)
{
employee=employees[i];
break;
}
}
var name=document.createElement('b');
name.innerHTML="Name: "+employee.name;
var designation=document.createElement('b');
designation.innerHTML="Designation: "+employee.designation;
var gender=document.createElement('b');
if(employee.gender=='M') gender.innerHTML='Gender: M';
else gender.innerHTML='Gender: F';
var basicSalary=document.createElement('b');
basicSalary.innerHTML='Basic Salary: '+employee.basicSalary;
var isIndian=document.createElement('b');
if(employee.isIndian) isIndian.innerHTML='Indian';
else isIndian.innerHTML='Foriegner';
var panNumber=document.createElement('b');
panNumber.innerHTML='PAN Number: '+employee.panNumber;
var aadharCardNumber=document.createElement('b');
aadharCardNumber.innerHTML='Aadhar Card Number: '+employee.aadharCardNumber;
var deleteButton=document.createElement('button');
deleteButton.onclick=function(){
var dataToSend='id='+employeeId;
var xmlHttpRequest=new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function(){
if(this.readyState==4)
{
if(this.status==200)
{
var responseData=this.responseText;
if(responseData=='EMPLOYEE DELETED')
{
var formObj=document.createElement('form');
document.body.appendChild(formObj);
formObj.method='POST';
formObj.action='/stylethree/Employees.jsp';
formObj.submit();
}
else
{
alert(responseData);
}
}
else
{
alert("Some Problem");
}
}
};
xmlHttpRequest.open('POST','deleteEmployee',true);
xmlHttpRequest.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
xmlHttpRequest.send(dataToSend);
};

deleteButton.innerHTML='Delete';
var cancelButton=document.createElement('button');
cancelButton.innerHTML='Cancel';
cancelButton.onclick=function(){
var formObj=document.createElement('form');
document.body.appendChild(formObj);
formObj.method='POST';
formObj.action='/stylethree/Employees.jsp';
formObj.submit();
};
var l1b=document.createElement('br');
var l2b=document.createElement('br');
var l3b=document.createElement('br');
var l4b=document.createElement('br');
var l5b=document.createElement('br');
var l6b=document.createElement('br');
var l7b=document.createElement('br');
var l8b=document.createElement('br');

rightPanel.appendChild(name);
rightPanel.appendChild(l1b);
rightPanel.appendChild(designation);
rightPanel.appendChild(l2b);
rightPanel.appendChild(gender);
rightPanel.appendChild(l3b);
rightPanel.appendChild(basicSalary);
rightPanel.appendChild(l4b);
rightPanel.appendChild(isIndian);
rightPanel.appendChild(l5b);
rightPanel.appendChild(panNumber);
rightPanel.appendChild(l6b);
rightPanel.appendChild(aadharCardNumber);
rightPanel.appendChild(l7b);
rightPanel.appendChild(l8b);
rightPanel.appendChild(deleteButton);
rightPanel.appendChild(cancelButton);
}


function addEmployee()
{
var employeeListDivision=document.getElementById('employeeListDivision');
var infoBox=document.getElementById('infoBox');
var moduleHeading=document.getElementById('moduleHeading');
employeeListDivision.remove();
infoBox.remove();
moduleHeading.innerHTML="Employee (Add Module)";
var nameSpan=document.createElement('span');
nameSpan.innerHTML="Name: &emsp;";
var inputName=document.createElement('input');
inputName.id='inputName';
inputName.size=51
inputName.maxLength=50

var errorNameSpan=document.createElement('span');
errorNameSpan.classList.add('error');
var l1b=document.createElement('br');
var l2b=document.createElement('br');
var l3b=document.createElement('br');
var l4b=document.createElement('br');
var l5b=document.createElement('br');
var l6b=document.createElement('br');
var l7b=document.createElement('br');
var l8b=document.createElement('br');
var designationSpan=document.createElement('span');
designationSpan.innerHTML='Designation: &emsp;';
var designationsOptions=document.createElement('select');
designationsOptions.name='designationCode';
designationsOptions.id='designationCode';
var options=document.createElement('option');
options.value=-1;
options.innerHTML="Select Designation";
designationsOptions.appendChild(options);
for(var i=0;i<designations.length;i++)
{
options=document.createElement('option');
options.value=designations[i].code;
options.innerHTML=designations[i].title;
designationsOptions.appendChild(options);
}
var designationsOptionsErrorSpan=document.createElement('span');
designationsOptionsErrorSpan.classList.add('error');

var dateOfBirthSpan=document.createElement('span');
dateOfBirthSpan.innerHTML='Date Of Birth: &emsp;';
var inputDOB=document.createElement('input');
inputDOB.type='date';
inputDOB.id='dateOfBirth';
var dateOfBirthErrorSpan=document.createElement('span');
dateOfBirthErrorSpan.classList.add('error');

var genderSpan=document.createElement('span');
genderSpan.innerHTML="Gender: &emsp;";
var inputGenderForMale=document.createElement('input')
;
inputGenderForMale.id='inputGender';
inputGenderForMale.type='radio';
inputGenderForMale.name='gender';
inputGenderForMale.value='M';
var genderMaleSpan=document.createElement('span');
genderMaleSpan.innerHTML='Male &emsp;';

var inputGenderForFemale=document.createElement('input');
inputGenderForFemale.id='inputGender';
inputGenderForFemale.type='radio';
inputGenderForFemale.name='gender';
inputGenderForFemale.value='F';
var genderFemaleSpan=document.createElement('span');
genderFemaleSpan.innerHTML='Female';

var genderErrorSpan=document.createElement('span');
genderErrorSpan.classList.add('error');

var basicSalarySpan=document.createElement('span');
basicSalarySpan.innerHTML='Basic Salary: &emsp;';
var basicSalaryInputBox=document.createElement('input');
basicSalaryInputBox.type='text';
basicSalaryInputBox.name='basicSalary';
basicSalaryInputBox.maxlength=12;
basicSalaryInputBox.size=13;
basicSalaryInputBox.style='text-align:right';
var basicSalaryError=document.createElement('span');
basicSalaryError.classList.add('error');

var isIndianSpan=document.createElement('span');
isIndianSpan.innerHTML='IsIndian: &emsp;';
var isIndianCheckbox=document.createElement('input');
isIndianCheckbox.type='checkbox';
isIndianCheckbox.name='isIndian';
isIndianCheckbox.value='Y';
var panNumberSpan=document.createElement('span');
panNumberSpan.innerHTML='PAN Number: &emsp;';
var panNumberInput=document.createElement('input');
panNumberInput.type='text';
panNumberInput.maxlength=15;
panNumberInput.length=16;
var panNumberErrorSpan=document.createElement('span');
panNumberErrorSpan.classList.add('error');

var aadharCardNumberSpan=document.createElement('span');
aadharCardNumberSpan.innerHTML='Aadhar Card Number: &emsp;';
var aadharCardNumberInput=document.createElement('input');
aadharCardNumberInput.type='text';
aadharCardNumberInput.maxlength=15;
aadharCardNumberInput.size=16;
var aadharCardNumberErrorSpan=document.createElement('span');
aadharCardNumberErrorSpan.classList.add('error');


var saveButton=document.createElement('button');
saveButton.innerHTML='Save';
saveButton.onclick=function(){
var name=inputName.value;
var designationCode=designationsOptions.value;
var dateOfBirth=inputDOB.value;
var genders=document.getElementsByName('gender');
var gender='M';
var isIndian='N';
var panNumber=panNumberInput.value;
var aadharCardNumber=aadharCardNumberInput.value;
if(isIndianCheckbox.checked) isIndian='Y';
for(var i=0;i<genders.length;i++)
{
if(genders[i].checked) gender=genders[i].value;
}
var basicSalary=basicSalaryInputBox.value;
basicSalary=basicSalary.trim();
//
var firstInvalidComponent=null;
var valid=true;
var nameErrorSection=errorNameSpan;
nameErrorSection.innerHTML='';
if(name.length==0)
{
nameErrorSection.innerHTML='Name Required';
valid=false;
firstInvalidComponent=inputName;
}

var designationCodeErrorSection=designationsOptionsErrorSpan;
designationCodeErrorSection.innerHTML='';
if(designationCode==-1)
{
designationCodeErrorSection.innerHTML='Desigantion Required';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=designationsOptions;
}

var dateOfBirthErrorSection=dateOfBirthErrorSpan;
dateOfBirthErrorSection.innerHTML='';
if(dateOfBirth.length==0)
{
dateOfBirthErrorSection.innerHTML='Select date of birth';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=inputDOB;
}

var genderErrorSection=genderErrorSpan;
genderErrorSection.innerHTML='';
if(genders[0].checked==false && genders[1].checked==false)
{
genderErrorSection.innerHTML='Select gender';
valid=false;
}


var basicSalaryErrorSection=basicSalaryError;
basicSalaryErrorSection.innerHTML='';
if(basicSalary.length==0)
{
basicSalaryErrorSection.innerHTML='Basic Salary required';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=basicSalaryInputBox;
}
else
{
var v='0123456789.';
var e=0;
var isBasicSalaryValid=true;
while(e<basicSalary.length)
{
if(v.indexOf(basicSalary.charAt(e))==-1)
{
valid=false;
basicSalaryErrorSection.innerHTML='Invalid basic salary';
if(firstInvalidComponent==null) firstInvalidComponent=basicSalaryInputBox;
isBasicSalaryValid=false;
break;
}
e++;
}
if(isBasicSalaryValid)
{
var dot=basicSalary.indexOf('.');
if(dot!=-1)
{
var numberOfFractions=basicSalary.length-(dot+1);
if(numberOfFractions>2)
{
basicSalaryErrorSection.innerHTML='Invalid basic salary';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=basicSalaryInputBox;
}
}
}
}

var panNumberErrorSection=panNumberErrorSpan;
panNumberErrorSection.innerHTML='';
if(panNumber.length==0)
{
panNumberErrorSection.innerHTML='PAN number required';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=panNumberInput;
}

var aadharCardNumberErrorSection=aadharCardNumberErrorSpan;
aadharCardNumberErrorSection.innerHTML='';
if(aadharCardNumber.length==0)
{
aadharCardNumberErrorSection.innerHTML='Aadhar Card number required';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=aadharCardNumberInput;
}
if(!valid) firstInvalidComponent.focus();
if(valid==false) return;

var dataToSend='name='+encodeURI(name);
dataToSend=dataToSend+'&designationCode='+encodeURI(designationCode);
dataToSend=dataToSend+'&dateOfBirth='+encodeURI(dateOfBirth);
dataToSend=dataToSend+'&gender='+encodeURI(gender);
dataToSend=dataToSend+'&isIndian='+encodeURI(isIndian);
dataToSend=dataToSend+'&basicSalary='+encodeURI(basicSalary);
dataToSend=dataToSend+'&panNumber='+encodeURI(panNumber);
dataToSend=dataToSend+'&aadharCardNumber='+encodeURI(aadharCardNumber);
var xmlHttpRequest=new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function(){
if(this.readyState==4)
{
if(this.status==200)
{
var responseData=this.responseText;
if(responseData=='EMPLOYEE ADDED')
{
var formObj=document.createElement('form');
document.body.appendChild(formObj);
formObj.method='POST';
formObj.action='/stylethree/Employees.jsp';
formObj.submit();
}
else
{
var data=responseData.split(",");
for(var i=0;i<data.length;i++)
{
if(data[i]=='PAN Exists') panNumberErrorSection.innerHTML="PAN Number Alredy Exists"
else if(data[i]=='Aadhar Exists') aadharCardNumberErrorSection.innerHTML='Aadhar Card Number Already Exists';
else if(data[i]=='Invalid Designation') designationCodeErrorSection.innerHTML='Invalid Designation';
}
}
}
else
{
alert('some problem');
}
}
};
xmlHttpRequest.open('POST','addEmployee',true);
xmlHttpRequest.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
xmlHttpRequest.send(dataToSend);
};

var span=document.createElement('span');
span.innerHTML='&emsp;';

var cancelButton=document.createElement('button');
cancelButton.innerHTML='Cancel';
cancelButton.onclick=function(){
var formObj=document.createElement('form');
document.body.appendChild(formObj);
formObj.method='POST';
formObj.action='/stylethree/Employees.jsp';
formObj.submit();
};

var rightPanel=document.getElementById('right-panel');
rightPanel.appendChild(nameSpan);
rightPanel.appendChild(inputName);
rightPanel.appendChild(errorNameSpan);
rightPanel.appendChild(l1b);
rightPanel.appendChild(designationSpan);
rightPanel.appendChild(designationsOptions);
rightPanel.appendChild(designationsOptionsErrorSpan);
rightPanel.appendChild(l2b);
rightPanel.appendChild(dateOfBirthSpan);
rightPanel.appendChild(inputDOB);
rightPanel.appendChild(dateOfBirthErrorSpan);
rightPanel.appendChild(l3b);
rightPanel.appendChild(genderSpan);
rightPanel.appendChild(inputGenderForMale);
rightPanel.appendChild(genderMaleSpan);
rightPanel.appendChild(inputGenderForFemale);
rightPanel.appendChild(genderFemaleSpan);
rightPanel.appendChild(genderErrorSpan);
rightPanel.appendChild(l4b);
rightPanel.appendChild(basicSalarySpan);
rightPanel.appendChild(basicSalaryInputBox);
rightPanel.appendChild(basicSalaryError);
rightPanel.appendChild(l5b);
rightPanel.appendChild(isIndianSpan);
rightPanel.appendChild(isIndianCheckbox);
rightPanel.appendChild(l6b);
rightPanel.appendChild(panNumberSpan);
rightPanel.appendChild(panNumberInput);
rightPanel.appendChild(panNumberErrorSpan);
rightPanel.appendChild(l7b);
rightPanel.appendChild(aadharCardNumberSpan);
rightPanel.appendChild(aadharCardNumberInput);
rightPanel.appendChild(aadharCardNumberErrorSpan);
rightPanel.appendChild(l8b);
rightPanel.appendChild(saveButton);
rightPanel.appendChild(span);
rightPanel.appendChild(cancelButton);
}
