function login()
{
var username=document.getElementById('username').value;
var password=document.getElementById('password').value;
var errorMessage=document.getElementById('errorMessage');
errorMessage.innerHTML='';
if(username.length==0 || password.length==0)
{
errorMessage.innerHTML='Username or Password Incorrect';
return;
}
var dataToSend='username='+encodeURI(username);
dataToSend=dataToSend+'&password='+encodeURI(password);
var xmlHttpRequest=new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function(){
if(this.readyState==4)
{
if(this.status==200)
{
var responseData=this.responseText;
if(responseData=="INVALID")
{
errorMessage.innerHTML='Username or Password Incorrect';
}
else
{
var formObj=document.createElement('form');
formObj.method='POST';
formObj.action='/stylethree/index.jsp';
document.body.appendChild(formObj);
formObj.submit();
}
}
else
{
errorMessage.innerHTML='Username or Password Incorrect';
}
}
};
xmlHttpRequest.open('POST','login',true);
xmlHttpRequest.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
xmlHttpRequest.send(dataToSend);
}
