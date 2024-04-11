package com.thinking.machines.hr.bl;
import java.util.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;

public class DesignationBL
{
public List<DesignationBean> getAll()
{
List<DesignationBean> list=new LinkedList<>();
try
{
DesignationDAO designationDAO=new DesignationDAO();
List<DesignationDTO> designationDLList=designationDAO.getAll();
DesignationBean designationBean;
for(DesignationDTO designation: designationDLList)
{
designationBean=new DesignationBean();
designationBean.setCode(designation.getCode());
designationBean.setTitle(designation.getTitle());
list.add(designationBean);
}
}catch(DAOException daoException)
{
// later on it will put into some log file
System.out.println("Problem in DesignationBL: "+daoException.getMessage());
}
return list;
}
}
