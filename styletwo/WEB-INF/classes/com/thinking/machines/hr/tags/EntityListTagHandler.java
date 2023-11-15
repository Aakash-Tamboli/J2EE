package com.thinking.machines.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.lang.reflect.*;

public class EntityListTagHandler extends BodyTagSupport
{
private int index;
private List list;
private String populatorClass;
private String populatorMethod;
private String name;

private void reset()
{
list=null;
populatorClass="";
populatorMethod="";
name="";
}

public EntityListTagHandler()
{
reset();
}

public void setPopulatorClass(String populatorClass)
{
this.populatorClass=populatorClass;
}

public String getPopulatorClass()
{
return this.populatorClass;
}

public void setPopulatorMethod(String populatorMethod)
{
this.populatorMethod=populatorMethod;
}

public String getPopulatorMethod()
{
return this.populatorMethod;
}

public void setName(String name)
{
this.name=name;
}

public String getName()
{
return this.name;
}

public int doStartTag()
{
try
{
Class c=Class.forName(populatorClass);
Object obj=c.newInstance();
Class[] parameter=new Class[0];
Method method=c.getMethod(populatorMethod,parameter);
list=(List)method.invoke(obj);
if(list==null || list.size()==0) return super.SKIP_BODY;
index=0;
Object bean=list.get(index);
pageContext.setAttribute(name,bean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",index+1,PageContext.REQUEST_SCOPE);
return super.EVAL_BODY_INCLUDE;
}catch(Throwable t)
{
// later this will put in logging mechanism
System.out.println(t);
return super.SKIP_BODY;
}
}

public int doAfterBody()
{
index++;
if(index==list.size()) return super.SKIP_BODY;
Object bean=list.get(index);
pageContext.setAttribute(name,bean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",index+1,PageContext.REQUEST_SCOPE);
return super.EVAL_BODY_AGAIN;
}

public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
}
