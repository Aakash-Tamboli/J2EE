package com.thinking.machines.practice.beans;
import java.io.Serializable;

public class DesignationBean implements Serializable
{
private int code;
private String title;

public DesignationBean()
{
this.code=0;
this.title="";
}
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setTitle(String title)
{
this.title=title;
}
public String getTitle()
{
return this.title;
}
}
