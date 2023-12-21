function checkUserStatus()
{
if(isLoggedIn==false)
{
var formObj=document.createElement('form');
document.body.appendChild(formObj);
formObj.action='/stylethree/LoginForm.jsp';
formObj.method='POST';
formObj.submit();
}
}
window.addEventListener('load',checkUserStatus);
