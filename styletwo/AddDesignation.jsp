<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Authenticate />
<tm:Module name='DESIGNATION' />
<tm:FormResubmitted>
<jsp:forward page='/notifyFormResubmission' />
</tm:FormResubmitted>
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean' />
<jsp:setProperty name='designationBean' property='*' />
<jsp:forward page='/addDesignation' />
