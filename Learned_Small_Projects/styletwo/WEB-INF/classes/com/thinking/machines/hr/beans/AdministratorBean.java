package com.thinking.machines.hr.beans;

public class AdministratorBean implements java.io.Serializable,Comparable<AdministratorBean>
{
private String username;
private String password;
public AdministratorBean()
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
public boolean equals(Object other)
{
if(!(other instanceof AdministratorBean)) return false;
AdministratorBean administratorBean=(AdministratorBean)other;
return this.username.equalsIgnoreCase(administratorBean.username);
}
public int compareTo(AdministratorBean administratorBean)
{
return this.username.compareTo(administratorBean.username);
}
public int hashCode()
{
return this.username.hashCode();
}
}
