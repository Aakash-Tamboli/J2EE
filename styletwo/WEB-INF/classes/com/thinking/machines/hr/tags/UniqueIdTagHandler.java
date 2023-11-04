package com.thinking.machines.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;

public class UniqueIdTagHandler extends TagSupport
{
public UniqueIdTagHandler()
{
// nothing
}
public int doStartTag()
{
String uuid=UUID.randomUUID().toString();
pageContext.setAttribute("uniqueId",uuid,PageContext.SESSION_SCOPE);
return super.SKIP_PAGE;
}
public int doEndTag()
{
return super.EVAL_PAGE;
}
}
