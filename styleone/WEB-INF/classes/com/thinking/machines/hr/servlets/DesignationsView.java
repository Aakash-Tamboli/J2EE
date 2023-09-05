package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class DesignationsView extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{

try
{
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
List<DesignationDTO> designations;
designations=designationDAO.getAll();

PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/html");

pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>HR Application</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- Main Container Start here-->");
pw.println("<div style='width:90hw;height:auto;border:1px solid black'>");
pw.println("<!-- Header Starts Here-->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");
pw.println("<img src='/styleone/images/tm.png' style='float:left;width:40px;height:40px'>");
pw.println("<div style='margin-top:9px;margin-bottom:9px;font-size:20pt'>");
pw.println("Thinking Machines");
pw.println("</div>");
pw.println("</div>");
pw.println("<!-- Header Ends Here-->");
pw.println("<!-- Content-Section Starts here-->");
pw.println("<div style='width:90hw;height:70vh;margin:5px;border:1px solid white'>");
pw.println("<!-- Left Pannel Starts Here -->");
pw.println("<div style='height:60vh;margin:5px;float:left;padding:5px;border:1px solid black'>");
pw.println("<b href='/styleone/designationView'>Designations</b> <br>");
pw.println("<a href='/styleone/employeesView'>Employees</a>");
pw.println("</div>");
pw.println("<!-- left Pannel Ends Here-->");
pw.println("<!-- Right Pannel Starts Here -->");
pw.println("<div style='height:60vh;margin-left:140px;margin-right:5px;margin-bottom:px;margin-top:5px;padding:5px;overflow:scroll;border:1px solid black'>");
pw.println("<h2>Designations</h2>");
pw.println("<table border='1'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th colspan='4' style='text-align:right;padding:5px'><a href='/styleone/addDesignation.html'>Add New Designation</a></th>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<th style='width:60px;text-align:center'>S.No</th>");
pw.println("<th style='width:200px;text-align:center'>Designation</th>");
pw.println("<th style='width:100px;text-align:center'>Edit</th>");
pw.println("<th style='width:100px;text-align:center'>Delete</th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");
int code;
int sno=0;
String title;
DesignationDTO designationDTO;

for(int i=0;i<designations.size();i++)
{
sno++;
designationDTO=designations.get(i);
code=designationDTO.getCode();
title=designationDTO.getTitle();
pw.println("<tr>");
pw.println("<td style='text-align:right'>"+sno+"</td>");
pw.println("<td >"+title+"</td>");
pw.println("<td style='text-align:center'><a href='/styleone/editDesignation?code="+code+"'>Edit</a></td>");
pw.println("<td style='text-align:center'><a href='/styleone/confirmDesignation?code="+code+"'>Delete</a></td>");
pw.println("</tr>");
}

pw.println("</tbody>");
pw.println("</table>");
pw.println("</div>");
pw.println("<!-- Right Pannel Ends Here -->");
pw.println("</div>");
pw.println("<!-- Content-Section Ends Here -->");
pw.println("<!-- Footer Start Here-->");
pw.println("<div style='width:90hw;height:auto;margin:5px;text-align:center;border:1px solid black'>");
pw.println("&copy; Thinking Machines 2023");
pw.println("</div>");
pw.println("<!-- Footer Ends Here -->");
pw.println("</div>");
pw.println("<!-- Main Container ends here");
pw.println("</body>");
pw.println("</html>");

}catch(Exception e)
{
System.out.println(e.getMessage());
}

}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}
