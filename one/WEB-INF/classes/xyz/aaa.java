package xyz;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class aaa extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
System.out.println("Data Arrived");

}catch(Exception e)
{
System.out.println(e); // remove after testing
}
}

}
