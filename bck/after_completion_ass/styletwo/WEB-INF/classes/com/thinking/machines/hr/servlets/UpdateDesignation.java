package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateDesignation extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
boolean isLoggedIn=Authenticate.isLoggedIn(request,response);
if(isLoggedIn==false) return;
try
{
int code=Integer.parseInt(request.getParameter("code"));
String title=request.getParameter("title");
DesignationDTO designation;
DesignationDAO designationDAO=new DesignationDAO();
designation=new DesignationDTO();
designation.setCode(code);
designation.setTitle(title);
try
{
designationDAO.update(designation);
MessageBean messageBean;
messageBean=new MessageBean();
messageBean.setHeading("Designation Updated");
messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("Yes");
messageBean.setButtonOneAction("/Designations.jsp"); // later On action will be /designations
request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean;
DesignationBean designationBean;
errorBean=new ErrorBean();
designationBean=new DesignationBean();
designationBean.setCode(code);
designationBean.setTitle(title);
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
request.setAttribute("designationBean",designationBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/DesignationEditForm.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
System.out.println("Problem: "+exception); // after testing remove
}
}
};
