package com.thinking.machines.practice.beans;
import java.io.Serializable;

public class ErrorBean implements Serializable
{
private String error;
public ErrorBean()
{
this.error="";
}
public void setError(String error)
{
this.error=error;
}
public String getError()
{
return this.error;
}
}
