function designationEditEventHandler(code)
{
var designationsTable=document.getElementById('designationsTable');
var moduleName=document.getElementById('moduleName');
moduleName.innerHTML="Designation (Edit Module)";
designationsTable.remove();
var boldTitle=document.createElement('b');
boldTitle.innerHTML="Designation: "
var input=document.createElement('input');
input.type='text';
input.id='newDesignation';
for(var i=0;i<designations.length;i++)
{
if(designations[i].code==code) input.value=designations[i].title;
}
var l1b=document.createElement('br');
var l2b=document.createElement('br');
var saveButton=document.createElement('button');
saveButton.innerHTML="Save";
saveButton.onclick=function(){
var inputBox=document.getElementById('newDesignation');
var newTitle=inputBox.value;
newTitle=newTitle.trim();
if(newTitle.length==0)
{
alert('Please enter valid designation');
return;
}
var dataToSend='code='+encodeURI(code);
dataToSend=dataToSend+"&title="+encodeURI(newTitle);
var xmlHttpRequest=new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function(){
if(this.readyState==4)
{
if(this.status==200)
{
var responseData=this.responseText;
if(responseData=="UPDATED")
{
var formObj=document.createElement('form');
document.body.appendChild(formObj);
formObj.method='POST';
formObj.action='/stylethree/Designations.jsp';
formObj.submit();
}
else
{
alert("Not Updated");
}
}
else
{
alert("Some Problem");
}
}
};
xmlHttpRequest.open('POST','updateDesignation',true);
xmlHttpRequest.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
xmlHttpRequest.send(dataToSend);
};
var span=document.createElement('span');
span.innerHTML="&emsp;";
var cancelButton=document.createElement('button');
cancelButton.innerHTML='Cancel';
cancelButton.onclick=function(){
var formObj=document.createElement('form');
document.body.appendChild(formObj);
formObj.method='POST';
formObj.action='/stylethree/Designations.jsp';
formObj.submit();
};

var rightPanel=document.getElementById('right-panel');
rightPanel.appendChild(boldTitle);
rightPanel.appendChild(input);
rightPanel.appendChild(l1b);
rightPanel.appendChild(l2b);
rightPanel.appendChild(saveButton);
rightPanel.appendChild(span);
rightPanel.appendChild(cancelButton);
}

function designationDeleteEventHandler(code)
{
var designationsTable=document.getElementById('designationsTable');
var moduleName=document.getElementById('moduleName');
moduleName.innerHTML="Designation (Delete Module)";
designationsTable.remove();
var heading=document.createElement('h3');
for(var i=0;i<designations.length;i++)
{
if(designations[i].code==code) heading.innerHTML="Designation: "+designations[i].title+" to be deleted"
}
var deleteButton=document.createElement('button');
deleteButton.innerHTML='Delete';
deleteButton.onclick=function(){
var dataToSend='code='+encodeURI(code);
var xmlHttpRequest=new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function(){
if(this.readyState==4)
{
if(this.status==200)
{
var responseData=this.responseText;
if(responseData=='DELETED')
{
var formObj=document.createElement('form');
document.body.appendChild(formObj);
formObj.method='POST';
formObj.action='/stylethree/Designations.jsp'
formObj.submit();
}
else
{
alert(responseData);
}
}
else
{
alert("Some problem");
}
}
};
xmlHttpRequest.open('POST','deleteDesignation',true);
xmlHttpRequest.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
xmlHttpRequest.send(dataToSend);
};
var span=document.createElement('span');
span.innerHTML="&emsp;";
var cancelButton=document.createElement('button');
cancelButton.innerHTML='Cancel';
cancelButton.onclick=function(){
var formObj=document.createElement('form');
document.body.appendChild(formObj);
formObj.method='POST';
formObj.action='/stylethree/Designations.jsp';
formObj.submit();
};
var rightPanel=document.getElementById('right-panel');
rightPanel.appendChild(heading);
rightPanel.appendChild(deleteButton);
rightPanel.appendChild(span);
rightPanel.appendChild(cancelButton);
}

function populateDesignations()
{
var designationsTable=document.getElementById('designationsTable');
var designationsTableBody=designationsTable.getElementsByTagName('tbody')[0];
var designationsTableBodyRow=designationsTableBody.getElementsByTagName('tr')[0];
designationsTableBodyRow.remove();
var data=designationsTableBodyRow.getElementsByTagName('td');
var dynamicRow;
var dynamicRowData;
var cell;
for(var i=0;i<designations.length;i++)
{
dynamicRow=designationsTableBodyRow.cloneNode(true);
designationsTable.appendChild(dynamicRow);
dynamicRowData=dynamicRow.getElementsByTagName('td');
for(var j=0;j<dynamicRowData.length;j++)
{
cell=dynamicRowData[j].getAttribute("placeHolder") 
if(cell=="serialNumber") dynamicRowData[j].innerHTML=i+1;
else if(cell=='designationName') dynamicRowData[j].innerHTML=designations[i].title;
else if(cell=='editOption') dynamicRowData[j].innerHTML="<a href='javascript: designationEditEventHandler("+designations[i].code+")' >Edit</a>";
else if(cell=='deleteOption') dynamicRowData[j].innerHTML="<a href='javascript: designationDeleteEventHandler("+designations[i].code+")' >Delete</a>";
}
}
}
window.addEventListener('load',populateDesignations);

function addDesignation()
{
var rightPanel=document.getElementById('right-panel');
var designationsTable=document.getElementById('designationsTable');
designationsTable.remove();
var moduleName=document.getElementById('moduleName');
moduleName.innerHTML='Designation (Add Module)'
var errorSpan=document.createElement('span');
errorSpan.classList.add('error');
var bold=document.createElement('b');
bold.appendChild(errorSpan);
var labelSpan=document.createElement('span');
labelSpan.innerHTML='Designation: &emsp;';
labelSpan.id='label';
var inputDesignation=document.createElement('input');
var a1Span=document.createElement('span');
a1Span.innerHTML="&emsp; &emsp; &emsp; &emsp; &emsp; &emsp;";
var addButton=document.createElement('button');
addButton.innerHTML="Add";
var a2Span=document.createElement('span');
a2Span.innerHTML="&emsp; &emsp;";
var cancelButton=document.createElement('button');
cancelButton.innerHTML='Cancel';
var errorMessage=errorSpan;
errorMessage.innerHTML="";
addButton.onclick=function(){
var title=inputDesignation.value;
title=title.trim();
if(title.length==0)
{
errorMessage.innerHTML="Empty Box";
return
}
var dataToSend="title="+encodeURI(title);
var xmlHttpRequest=new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function(){
if(this.readyState==4)
{
if(this.status==200)
{
if(this.responseText=="ADDED")
{
alert("Designation Added");
var formObj=document.createElement('form');
document.body.appendChild(formObj);
formObj.method='POST';
formObj.action='/stylethree/Designations.jsp';
formObj.submit();
}
else
{
errorMessage.innerHTML=title+" already exists";
}
}
else
{
alert("Some problem");
}
}
};
xmlHttpRequest.open('POST','addDesignation',true);
xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
xmlHttpRequest.send(dataToSend);
};
cancelButton.onclick=function(){
var formObj=document.createElement('form');
document.body.appendChild(formObj);
formObj.method='POST';
formObj.action='/stylethree/Designations.jsp';
formObj.submit();
};
rightPanel.appendChild(bold);
rightPanel.appendChild(document.createElement('br'));
rightPanel.appendChild(labelSpan);
rightPanel.appendChild(inputDesignation);
rightPanel.appendChild(document.createElement('br'));
rightPanel.appendChild(document.createElement('br'));
rightPanel.appendChild(a1Span);
rightPanel.appendChild(addButton);
rightPanel.appendChild(a2Span);
rightPanel.appendChild(cancelButton);
}
