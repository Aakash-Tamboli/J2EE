package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.beans.*;
import com.thinking.machines.hr.dl.*;

public class DeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
DesignationBean designationBean=(DesignationBean)request.getAttribute("designationBean");
int code=designationBean.getCode();
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
try
{
designationDAO.delete(code);
MessageBean messageBean;
messageBean=new MessageBean();
messageBean.setMessage("Designation Deleted");
messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("Ok");
messageBean.setButtonOneAction("Designations.jsp");
request.setAttribute("messageBean",messageBean);
try
{
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
// not yet learned
}
}catch(DAOException daoException)
{
System.out.println("Problem: "+daoException.getMessage());
}
}
};
