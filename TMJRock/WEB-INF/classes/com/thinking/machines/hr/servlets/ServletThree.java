package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.thinking.machines.hr.dl.*;
import com.google.gson.*;


public class ServletThree extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
System.out.println("Servlet Three is not configured for GET Type Request");
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
/*
BufferedReader bufferedReader=request.getReader();
StringBuffer stringBuffer=new StringBuffer();
String str;
while(true)
{
str=bufferedReader.readLine();
if(str==null) break;
stringBuffer.append(str);
}
String rawData=stringBuffer.toString();
Gson gson=new Gson();
Customer customer=gson.fromJson(rawData,Customer.class);
PrintWriter pw=response.getWriter();
response.setContentType("application/json");
System.out.println(customer.getFirstName()+","+customer.getLastName()+","+customer.getAge());
pw.print(gson.toJson(customer));
*/

// When Request contains non-json
String firstName=request.getParameter("firstName");
String lastName=request.getParameter("lastName");
int age=Integer.parseInt(request.getParameter("age"));
System.out.println(firstName+","+lastName+","+age);
PrintWriter pw=response.getWriter();
response.setContentType("application/json");
Gson gson=new Gson();
Customer customer=new Customer();
customer.setFirstName(firstName);
customer.setLastName(lastName);
customer.setAge(age);
pw.print(gson.toJson(customer));
}catch(Exception exception)
{
System.out.println("Problem At Server Side: "+exception.getMessage());
}
}
}
