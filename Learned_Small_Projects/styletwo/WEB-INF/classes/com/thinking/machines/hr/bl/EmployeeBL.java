package com.thinking.machines.hr.bl;
import java.util.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import java.text.*;


public class EmployeeBL
{
public List<EmployeeBean> getAll()
{
List<EmployeeBean> list=new LinkedList<>();
try
{
EmployeeDAO employeeDAO=new EmployeeDAO();
List<EmployeeDTO> employeeDLList=employeeDAO.getAll();
EmployeeBean employeeBean;
for(EmployeeDTO employee: employeeDLList)
{
employeeBean=new EmployeeBean();
employeeBean.setEmployeeId(employee.getEmployeeId());
employeeBean.setName(employee.getName());
employeeBean.setDesignationCode(employee.getDesignationCode());
employeeBean.setDesignation(employee.getDesignation());
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
String dateOfBirthAsString=simpleDateFormat.format(employee.getDateOfBirth());
employeeBean.setDateOfBirth(dateOfBirthAsString);


employeeBean.setIsIndian(employee.getIsIndian());
employeeBean.setGender(employee.getGender());
employeeBean.setBasicSalary(employee.getBasicSalary().toString());
employeeBean.setPanNumber(employee.getPANNumber());
employeeBean.setAadharCardNumber(employee.getAadharCardNumber());
list.add(employeeBean);
}
}catch(DAOException daoException)
{
// later on it will put into some log file
System.out.println("Problem in EmployeeBL: "+daoException.getMessage());
}
return list;
}
}
