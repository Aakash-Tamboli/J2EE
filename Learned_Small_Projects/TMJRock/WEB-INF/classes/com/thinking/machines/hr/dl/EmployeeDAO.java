package com.thinking.machines.hr.dl;
import java.util.*;
import java.sql.*;
import java.math.*;
import java.text.*;

public class EmployeeDAO
{
public List<EmployeeDTO> getAll() throws DAOException
{
List<EmployeeDTO> employees;
employees=new LinkedList<>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement=connection.createStatement();
ResultSet resultSet=statement.executeQuery("select employee.id,employee.name,employee.designation_code,designation.title,employee.date_of_birth,employee.gender,employee.is_indian,employee.basic_salary,employee.pan_number,employee.aadhar_card_number from employee inner join designation on employee.designation_code=designation.code");
int id;
String name;
int designationCode;
String designation;
java.util.Date dateOfBirth;
String gender;
boolean isIndian;
BigDecimal basicSalary;
String panNumber;
String aadharCardNumber;
EmployeeDTO employee;

while(resultSet.next())
{
id=resultSet.getInt("id");
name=resultSet.getString("name").trim();
designationCode=resultSet.getInt("designation_code");
designation=resultSet.getString("title").trim();
dateOfBirth=resultSet.getDate("date_of_birth");
gender=resultSet.getString("gender");
isIndian=resultSet.getBoolean("is_indian");
basicSalary=resultSet.getBigDecimal("basic_salary");
panNumber=resultSet.getString("pan_number").trim();
aadharCardNumber=resultSet.getString("aadhar_card_number").trim();
employee=new EmployeeDTO();
employee.setEmployeeId("A"+id);
employee.setName(name);
employee.setDesignationCode(designationCode);
employee.setDesignation(designation);
employee.setDateOfBirth(dateOfBirth);
employee.setGender(gender);
employee.setIsIndian(isIndian);
employee.setBasicSalary(basicSalary);
employee.setPANNumber(panNumber);
employee.setAadharCardNumber(aadharCardNumber);
employees.add(employee);
}
statement.close();
resultSet.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
return employees;
}
public void add(EmployeeDTO employee) throws DAOException
{
try
{
String name=employee.getName();
int designationCode=employee.getDesignationCode();
java.util.Date dateOfBirth=employee.getDateOfBirth();
java.sql.Date sqlDate= new java.sql.Date(dateOfBirth.getYear(),dateOfBirth.getMonth(),dateOfBirth.getDate());
String gender=employee.getGender();
BigDecimal basicSalary=employee.getBasicSalary();
boolean isIndian=employee.getIsIndian();
String panNumber=employee.getPANNumber();
String aadharCardNumber=employee.getAadharCardNumber();

Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select id from employee where pan_number=?;");
preparedStatement.setString(1,panNumber);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Pan Number: "+panNumber+" exist");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select id from employee where aadhar_card_number=?;");
preparedStatement.setString(1,aadharCardNumber);
resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Aadhar Card Number: "+aadharCardNumber+" exist");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("insert into employee (name,designation_code,date_of_birth,gender,is_indian,basic_salary,pan_number,aadhar_card_number) values(?,?,?,?,?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setString(1,name);
preparedStatement.setInt(2,designationCode);
preparedStatement.setDate(3,sqlDate);
preparedStatement.setString(4,gender);
preparedStatement.setBoolean(5,isIndian);
preparedStatement.setBigDecimal(6,basicSalary);
preparedStatement.setString(7,panNumber);
preparedStatement.setString(8,aadharCardNumber);
preparedStatement.executeUpdate();
resultSet=preparedStatement.getGeneratedKeys();
resultSet.next(); // fetch for id
int id=resultSet.getInt(1);
employee.setEmployeeId("A"+id);
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}

public boolean panNumberExists(String panNumber) throws DAOException
{
boolean answer=false;
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select id from employee where pan_number=?;");
preparedStatement.setString(1,panNumber);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
answer=resultSet.next(); // if record fetch it means pan number exists then it returns true otherwise false
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
return answer;
}
public boolean aadharCardNumberExists(String aadharCardNumber) throws DAOException
{
boolean answer=false;
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select id from employee where aadhar_card_number=?;");
preparedStatement.setString(1,aadharCardNumber);
ResultSet resultSet=preparedStatement.executeQuery();
answer=resultSet.next();
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
return answer;
}
public void delete(String employeeId) throws DAOException
{
try
{
String vEmployeeId;
vEmployeeId=employeeId.substring(1);
int actualEmployeeId=Integer.parseInt(vEmployeeId);
actualEmployeeId=actualEmployeeId;
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select gender from employee where id=?;");
preparedStatement.setInt(1,actualEmployeeId);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException(employeeId+" does not exist");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("delete from employee where id=?;");
preparedStatement.setInt(1,actualEmployeeId);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException("Problem: "+sqlException.getMessage());
}
}
public EmployeeDTO getByEmployeeId(String employeeId) throws DAOException
{
EmployeeDTO employee;
employee=new EmployeeDTO();
try
{
String vEmployeeId=employeeId.substring(1);
int actualEmployeeId=Integer.parseInt(vEmployeeId);

Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from employee where id=?;");
preparedStatement.setInt(1,actualEmployeeId);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException(employeeId+" does not exist");
}
String name=resultSet.getString("name").trim();
int designationCode=resultSet.getInt("designation_code");
PreparedStatement vPreparedStatement;
vPreparedStatement=connection.prepareStatement("select title from designation where code=?;");
vPreparedStatement.setInt(1,designationCode);
ResultSet vResultSet=vPreparedStatement.executeQuery();
vResultSet.next();
String designation=vResultSet.getString("title").trim();
vResultSet.close();
vPreparedStatement.close();
java.util.Date dateOfBirth=resultSet.getDate("date_of_birth");
boolean isIndian=resultSet.getBoolean("is_indian");
BigDecimal basicSalary=resultSet.getBigDecimal("basic_salary");
String gender=resultSet.getString("gender").trim();
String panNumber=resultSet.getString("pan_number").trim();
String aadharCardNumber=resultSet.getString("aadhar_card_number").trim();
employee.setEmployeeId(employeeId);
employee.setName(name);
employee.setDesignationCode(designationCode);
employee.setDesignation(designation);
employee.setDateOfBirth(dateOfBirth);
employee.setIsIndian(isIndian);
employee.setGender(gender);
employee.setBasicSalary(basicSalary);
employee.setPANNumber(panNumber);
employee.setAadharCardNumber(aadharCardNumber);
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException("Problem: "+sqlException.getMessage());
}
return employee;
}

public void update(EmployeeDTO employee) throws DAOException
{
try
{
String employeeId=employee.getEmployeeId();
String vEmployeeId=employeeId.substring(1);
int id=0;
try
{
id=Integer.parseInt(vEmployeeId);
}catch(NumberFormatException numberFormatException)
{
throw new DAOException("Invalid EmployeeId: "+employeeId);
}
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select gender from employee where id=?;");
preparedStatement.setInt(1,id);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid EmployeeId: "+employeeId);
}
resultSet.close();
preparedStatement.close();
int designationCode=employee.getDesignationCode();
preparedStatement=connection.prepareStatement("select code from designation where code=?;");
preparedStatement.setInt(1,designationCode);
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid Designation");
}
resultSet.close();
preparedStatement.close();
String panNumber=employee.getPANNumber();
String aadharCardNumber=employee.getAadharCardNumber();

preparedStatement=connection.prepareStatement("select gender from employee where pan_number=? and id!=?;");
preparedStatement.setString(1,panNumber);
preparedStatement.setInt(2,id);
resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("PAN Number: "+panNumber+" exists against another employee");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select gender from employee where aadhar_card_number=? and id!=?;");
preparedStatement.setString(1,aadharCardNumber);
preparedStatement.setInt(2,id);

resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Aadhar Card Number: "+aadharCardNumber+" exists another employee");
}
resultSet.close();
preparedStatement.close();

preparedStatement=connection.prepareStatement("update employee set name=?,designation_code=?,date_of_birth=?,gender=?,is_indian=?,basic_salary=?,pan_number=?,aadhar_card_number=? where id=?;");
preparedStatement.setString(1,employee.getName());
preparedStatement.setInt(2,designationCode);
java.util.Date dateOfBirth=employee.getDateOfBirth();
java.sql.Date sqlDate=new java.sql.Date(dateOfBirth.getYear(),dateOfBirth.getMonth(),dateOfBirth.getDate());
preparedStatement.setDate(3,sqlDate);
preparedStatement.setString(4,employee.getGender());
preparedStatement.setBoolean(5,employee.getIsIndian());
preparedStatement.setBigDecimal(6,employee.getBasicSalary());
preparedStatement.setString(7,panNumber);
preparedStatement.setString(8,aadharCardNumber);
preparedStatement.setInt(9,id);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();

}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}
}
