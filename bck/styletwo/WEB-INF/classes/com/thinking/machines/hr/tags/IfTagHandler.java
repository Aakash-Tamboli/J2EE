package com.thinking.machines.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class IfTagHandler extends TagSupport
{
private boolean condition;
public IfTagHandler()
{
reset();
}
private void reset()
{
this.condition=false;
}
public void setCondition(boolean condition)
{
this.condition=condition;
}
public boolean getCondition()
{
return this.condition;
}
public int doStartTag()
{
if(condition)
{
pageContext.setAttribute("HOME","HOME",PageContext.REQUEST_SCOPE);
pageContext.setAttribute("DESIGNATION","DESIGNATION",PageContext.REQUEST_SCOPE);
pageContext.setAttribute("EMPLOYEE","EMPLOYEE",PageContext.REQUEST_SCOPE);
return super.EVAL_BODY_INCLUDE;
}
else
{
return super.SKIP_BODY;
}
}
public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
};
