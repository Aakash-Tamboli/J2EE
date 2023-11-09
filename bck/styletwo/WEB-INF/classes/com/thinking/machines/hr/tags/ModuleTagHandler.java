package com.thinking.machines.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class ModuleTagHandler extends TagSupport
{
private String name;
private final String designation="DESIGNATION";
private final String home="HOME";
private final String employee="EMPLOYEE";
public ModuleTagHandler()
{
reset();
}
private void reset()
{
this.name="";
}
public void setName(String name)
{
this.name=name;
pageContext.setAttribute("module",name,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("HOME",home,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("DESIGNATION",designation,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("EMPLOYEE",employee,PageContext.REQUEST_SCOPE);
}
public String getName()
{
return this.name;
}

public int doStartTag()
{
return super.SKIP_BODY;
}
public int doEndTag()
{
return super.EVAL_PAGE;
}
};
//<tm:module name=''></tm:module>
