<jsp:useBean id='administratorBean' class='com.thinking.machines.hr.beans.AdministratorBean' scope='request' />
<jsp:setProperty name='administratorBean' property='*' />
<jsp:forward page='/login' />
