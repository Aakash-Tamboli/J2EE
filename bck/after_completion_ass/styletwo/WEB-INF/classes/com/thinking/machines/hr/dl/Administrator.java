package com.thinking.machines.hr.dl;

public class Administrator implements java.io.Serializable
{
private String username;
private String password;
public Administrator()
{
this.username="";
this.password="";
}
public void setUsername(String username)
{
this.username=username;
}
public String getUsername()
{
return this.username;
}
public void setPassword(String password)
{
this.password=password;
}
public String getPassword()
{
return this.password;
}
}
