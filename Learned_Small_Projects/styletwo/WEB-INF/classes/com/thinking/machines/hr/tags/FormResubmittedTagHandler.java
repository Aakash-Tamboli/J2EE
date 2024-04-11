package com.thinking.machines.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class FormResubmittedTagHandler extends TagSupport
{
public FormResubmittedTagHandler()
{
// do nothing, just written for the sake of consistency
reset();
}
private void reset()
{
// do nothing, just written for the sake of consistency
}

public int doStartTag()
{
HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
String uuid=request.getParameter("formId");
if(uuid==null)
{
return super.EVAL_BODY_INCLUDE;
}
String sessionUUID=(String)pageContext.getAttribute(uuid,PageContext.SESSION_SCOPE);
if(sessionUUID==null)
{
return super.EVAL_BODY_INCLUDE;
}
pageContext.removeAttribute(uuid,PageContext.SESSION_SCOPE);
if(uuid.equals(sessionUUID))
{
return super.SKIP_BODY;
}
else
{
return super.EVAL_BODY_INCLUDE;
}
}

public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
}
