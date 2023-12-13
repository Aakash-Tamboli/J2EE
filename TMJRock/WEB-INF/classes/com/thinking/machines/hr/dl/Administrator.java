package com.thinking.machines.hr.dl;

public class Administrator implements java.io.Serializable,Comparable<Administrator>
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
public boolean equals(Object other)
{
if(!(other instanceof Administrator)) return false;
Administrator administrator=(Administrator)other;
return this.username.equalsIgnoreCase(administrator.username);
}
public int compareTo(Administrator administrator)
{
return this.username.compareTo(administrator.username);
}
public int hashCode()
{
return this.username.hashCode();
}
}
