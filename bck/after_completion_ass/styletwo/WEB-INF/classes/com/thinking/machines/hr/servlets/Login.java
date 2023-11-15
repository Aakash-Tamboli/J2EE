package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.beans.*;
import com.thinking.machines.hr.dl.*;

public class Login extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
AdministratorBean administratorBean=(AdministratorBean)request.getAttribute("administratorBean");
String username=administratorBean.getUsername();
try
{
AdministratorDAO administratorDAO=new AdministratorDAO();
Administrator administrator=administratorDAO.getByUsername(username);
if(administratorBean.getPassword().equalsIgnoreCase(administrator.getPassword())==false)
{
throw new DAOException("Invalid Password");
}
HttpSession httpSession=request.getSession();
httpSession.setAttribute("username",username);

RequestDispatcher requestDispatcher=request.getRequestDispatcher("/index.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
System.out.println(exception); // remove after testing
}

}catch(DAOException daoException)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
System.out.println(exception); // remove after testing
}
}
}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}
