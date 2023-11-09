<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Authenticate />
<tm:Module name='DESIGNATION' />
<jsp:useBean id='designationBean' class='com.thinking.machines.hr.beans.DesignationBean' scope='request' />
<jsp:setProperty name='designationBean' property='*' />
<jsp:forward page='/deleteDesignation' />
