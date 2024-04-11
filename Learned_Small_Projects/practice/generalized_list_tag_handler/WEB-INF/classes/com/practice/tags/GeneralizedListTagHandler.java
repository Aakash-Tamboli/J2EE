package com.practice.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.lang.reflect.*;
import java.util.*;

public class GeneralizedListTagHandler extends BodyTagSupport
{
private String populatorClass;
private String populatorMethod;
private String name;

private void reset()
{
this.populatorClass="";
this.populatorMethod="";
this.name="";
}

public GeneralizedListTagHandler()
{
reset();
}

public void setPopulatorClass(String populatorClass)
{
this.populatorClass=populatorClass;
}

public void setPopulatorMethod(String populatorMethod)
{
this.populatorMethod=populatorMethod;
}

public void setName(String name)
{
this.name=name;
}

public int doStartTag()
{
try
{
Class classLoaded=Class.forName(populatorClass);
Method methodLoaded=classLoaded.getDeclaredMethod(populatorMethod);
Object object=classLoaded.newInstance();
List lst=(List)methodLoaded.invoke(object);
if(lst.size()==0) return super.SKIP_BODY;
// remove code in actual place
for(Object o:lst)
{
Integer i=(Integer)o;
System.out.println(i);
}
// remove code in actual place
return super.EVAL_BODY_INCLUDE;
}catch(Exception exception)
{
System.out.println(exception); // remove after testing
return super.SKIP_BODY;
}
}

public int doAfterBody()
{
// return super.EVAL_BODY_AGAIN;
return super.SKIP_BODY;
}

public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
}
