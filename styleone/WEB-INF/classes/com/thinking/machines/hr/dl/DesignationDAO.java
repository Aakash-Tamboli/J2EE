package com.thinking.machines.hr.dl;
import java.util.*;
import java.sql.*;
public class DesignationDAO
{
public List<DesignationDTO> getAll() throws DAOException
{
List<DesignationDTO> designations;
designations=new LinkedList<>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from designations;");
int code;
String title;
DesignationDTO designationDTO;
while(resultSet.next())
{
code=resultSet.getInt("code");
title=resultSet.getString("title").trim();
designationDTO=new DesignationDTO();
designationDTO.setCode(code);
designationDTO.setTitle(title);
designations.add(designationDTO);
}
resultSet.close();
statement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return designations;
}
}
