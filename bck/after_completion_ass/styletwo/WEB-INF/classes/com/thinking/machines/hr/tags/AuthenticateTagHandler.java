package com.thinking.machines.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AuthenticateTagHandler extends TagSupport
{
public AuthenticateTagHandler()
{
// written just for sake of consistency
}
public int doStartTag()
{
return super.SKIP_BODY;
}
public int doEndTag()
{
String username=(String)pageContext.getAttribute("username",PageContext.SESSION_SCOPE);
if(username==null || username.length()==0)
{
HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
HttpServletResponse response=(HttpServletResponse)pageContext.getResponse();
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
System.out.println(exception); // remove after testing
}
return super.SKIP_PAGE;
}
return super.EVAL_PAGE;
}
}
