package com.thinking.machines.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.io.*;
public class FormIDTagHandler extends TagSupport
{
public FormIDTagHandler()
{
// do nothing but written for the sake of consistency
reset();
}
private void reset()
{
// do nothing but written for the sake of consistency
}

public int doStartTag()
{
String uuid=UUID.randomUUID().toString();
pageContext.setAttribute(uuid,uuid,PageContext.SESSION_SCOPE);
JspWriter jspWriterOut=pageContext.getOut();
try
{
jspWriterOut.print("<input type='hidden'  id='formId' name='formId' value='"+uuid+"'>");
}catch(IOException ioException)
{
// do nothing
}
return super.SKIP_PAGE;
}

public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
}
