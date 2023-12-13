package com.thinking.machines.hr.dl;
import java.sql.*;

public class AdministratorDAO
{
public AdministratorDAO()
{
// do nothing
}
public Administrator getByUsername(String username) throws DAOException
{
if(username==null || username.length()==0) throw new DAOException("Username: "+username+" not found");
username=username.trim();
Connection connection=DAOConnection.getConnection();
String usrname="";
String pwd="";
try
{
connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from administrator where uname=?;");
preparedStatement.setString(1,username);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Username: "+username+" not found");
}
usrname=resultSet.getString("uname").trim();
pwd=resultSet.getString("pwd").trim();
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
Administrator administrator=new Administrator();
administrator.setUsername(usrname);
administrator.setPassword(pwd);
return administrator;
}
}
