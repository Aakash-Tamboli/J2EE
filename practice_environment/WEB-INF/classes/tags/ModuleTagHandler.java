package tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class ModuleTagHandler extends TagSupport
{
private String module;
public ModuleTagHandler()
{
reset();
}
private void reset()
{
this.module="";
}
public void setModule(String module)
{
this.module=module;
pageContext.setAttribute("module",module,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("HOME","HOME",PageContext.REQUEST_SCOPE);
pageContext.setAttribute("DESIGNATION","DESIGNATION",PageContext.REQUEST_SCOPE);
pageContext.setAttribute("EMPLOYEE","EMPLOYEE",PageContext.REQUEST_SCOPE);
}
public String getModule()
{
return this.module;
}
public int doStartTag()
{
return super.SKIP_BODY;
}
public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
};
