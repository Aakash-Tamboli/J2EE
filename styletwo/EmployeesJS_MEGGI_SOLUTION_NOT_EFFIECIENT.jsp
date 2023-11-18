<!-- (MEGGI SOLUTION) THIS IS NOT WRITTEN BY DESIGNER ITS WRITTEN AS PROGRAMER SO DESGIN INVOLDED -->
<%@taglib uri='/WEB-INF/mytags/tmtags.tld'  prefix='tm' %>
<script>
var employee=null;
<tm:EntityList populatorClass='com.thinking.machines.hr.bl.EmployeeBL' populatorMethod='getAll' name='employeeBean'>
employee=new Employee();
employee.employeeId="${employeeBean.employeeId}";
employee.name="${employeeBean.name}";
employee.designationCode=${employeeBean.designationCode};
employee.designation="${employeeBean.designation}";
employee.dateOfBirth="${employeeBean.dateOfBirth}";
employee.gender="${employeeBean.gender}";
employee.isIndian=${employeeBean.isIndian};
employee.basicSalary=${employeeBean.basicSalary};
employee.panNumber="${employeeBean.panNumber}";
employee.aadharCardNumber="${employeeBean.aadharCardNumber}";
employees[${serialNumber-1}]=employee;
</tm:EntityList>
</script>
