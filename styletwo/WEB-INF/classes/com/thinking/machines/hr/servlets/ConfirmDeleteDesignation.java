package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
public class ConfirmDeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
boolean isLoggedIn=Authenticate.isLoggedIn(request,response);
if(isLoggedIn==false) return;
int code=0;
try
{
code=Integer.parseInt(request.getParameter("code"));
DesignationDAO designationDAO=new DesignationDAO();
DesignationDTO designation=null;
try
{
designation=designationDAO.getByCode(code);
}catch(DAOException daoException)
{
// not yet completed
return;
}
DesignationBean designationBean;
designationBean=new DesignationBean();
designationBean.setCode(designation.getCode());
designationBean.setTitle(designation.getTitle());
request.setAttribute("designationBean",designationBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/ConfirmDeleteDesignation.jsp");
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
// not yet completed
}
}
};
