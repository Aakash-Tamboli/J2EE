package com.thinking.machines.hr.tags;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.thinking.machines.hr.beans.*;
import com.thinking.machines.hr.dl.*;

public class DesignationsTagHandler extends BodyTagSupport
{
private List<DesignationBean> designations;
private int index;
public DesignationsTagHandler()
{
reset();
}
private void reset()
{
index=0;
if(designations==null) return;
designations.clear();
designations=null;
}
public int doStartTag()
{
List<DesignationDTO> dlDesignations;
try
{
dlDesignations=new DesignationDAO().getAll();
}catch(DAOException daoException)
{
System.out.println("Problem in Tag Handler: "+daoException);
return super.SKIP_BODY;
}
if(dlDesignations.size()==0) return super.SKIP_BODY;
designations=new ArrayList<>();
DesignationBean designationBean;
for(DesignationDTO designationDTO: dlDesignations)
{
designationBean=new DesignationBean();
designationBean.setCode(designationDTO.getCode());
designationBean.setTitle(designationDTO.getTitle());
designations.add(designationBean);
}
index=0;
designationBean=designations.get(index);
pageContext.setAttribute("designationBean",designationBean,pageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",new Integer(index+1),pageContext.REQUEST_SCOPE);
return super.EVAL_BODY_INCLUDE;
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
pageContext.setAttribute("designationBean",designationBean,pageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",index+1,pageContext.REQUEST_SCOPE);
return super.EVAL_BODY_AGAIN;
}
};
