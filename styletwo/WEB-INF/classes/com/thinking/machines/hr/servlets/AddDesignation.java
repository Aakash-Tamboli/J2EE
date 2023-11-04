package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddDesignation extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
String formId=request.getParameter("formId");
String vFormId="";
HttpSession httpSession=request.getSession();
vFormId=(String)httpSession.getAttribute("uniqueId");
System.out.println("Form Id: "+formId);
System.out.println("Session Object: "+vFormId);
if(vFormId==null || formId.equalsIgnoreCase(vFormId)==false)
{
RequestDispatcher requestDispatcher;
MessageBean messageBean=new MessageBean();
messageBean.setHeading("Attention");
messageBean.setMessage("Don't hit refresh");
messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("Ok");
messageBean.setButtonOneAction("Designations.jsp");
request.setAttribute("messageBean",messageBean);
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
return;
}
httpSession.removeAttribute("uniqueId");
DesignationBean designationBean;
designationBean=(DesignationBean)request.getAttribute("designationBean");
String title=designationBean.getTitle();
DesignationDTO designation;
designation=new DesignationDTO();
designation.setTitle(title);
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
try
{
designationDAO.add(designation);
designationBean.setCode(designation.getCode());
MessageBean messageBean;
messageBean=new MessageBean();
messageBean.setHeading("Designation (Add Module)"); // heading data will be given by project lead we are just programer.
messageBean.setMessage("Designation added, add more ?");
messageBean.setGenerateButtons(true);
messageBean.setGenerateTwoButtons(true);
messageBean.setButtonOneText("Yes");
messageBean.setButtonTwoText("No");
messageBean.setButtonOneAction("DesignationAddForm.jsp");
messageBean.setButtonTwoAction("Designation.jsp");
request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/DesignationAddForm.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
System.out.println(exception.getMessage());
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("Error.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
// not yet decieded
}
}
}
}
