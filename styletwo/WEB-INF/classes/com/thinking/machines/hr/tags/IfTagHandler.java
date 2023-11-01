package com.thinking.machines.hr.tags;
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
if(condition) return 1;
else return 0;
}
public int doEndTag()
{
reset();
return 6;
}
};