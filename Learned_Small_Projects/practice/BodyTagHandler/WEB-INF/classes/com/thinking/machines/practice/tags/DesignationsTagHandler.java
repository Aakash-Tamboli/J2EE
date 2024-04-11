package com.thinking.machines.practice.tags;
import com.thinking.machines.practice.beans.*;
import com.thinking.machines.practice.dl.*;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class DesignationsTagHandler extends BodyTagSupport
{
private List<DesignationBean> designations;
private int index;

public DesignationsTagHandler()
{
System.out.println("------------------------------------------------");
reset();
}

private void reset()
{
index=0;
if(designations!=null)
{
designations=null;
}
}

public int doStartTag()
{
List<DesignationDTO> dlDesignations=null;
try
{
dlDesignations=new DesignationDAO().getAll();
}catch(DAOException daoException)
{
System.out.println("Problem in Designation Tag Handler: "+daoException.getMessage()); // remove after testing
return super.SKIP_BODY;
}
designations=new ArrayList<>();
DesignationBean designationBean;
for(DesignationDTO designation: dlDesignations)
{
designationBean=new DesignationBean();
designationBean.setTitle(designation.getTitle());
designationBean.setCode(designation.getCode());
designations.add(designationBean);
}
index=0;
designationBean=designations.get(index);
pageContext.setAttribute("designationBean",designationBean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",new Integer(index+1),PageContext.REQUEST_SCOPE);
return super.EVAL_PAGE;
}
public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
public int doAfterBody()
{
index++;
if(designations.size()==index) return super.SKIP_BODY;
DesignationBean designationBean;
designationBean=designations.get(index);
pageContext.setAttribute("designationBean",designationBean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",index+1,PageContext.REQUEST_SCOPE);
return super.EVAL_BODY_AGAIN;
}
};
