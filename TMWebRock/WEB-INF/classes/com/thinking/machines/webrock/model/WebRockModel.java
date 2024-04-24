package com.thinking.machines.webrock.model;
import javax.servlet.*;
import java.util.*;
import com.thinking.machines.webrock.pojo.*;

public class WebRockModel
{
public Map<String,Service> dataStructure;
public WebRockModel(boolean usedInServiceDoc)
{
System.out.println("WebRockModel Constructor in action");
if(usedInServiceDoc)
{
System.out.println("WebRockModel created for use of Service Doc");
this.dataStructure=new LinkedHashMap<>();
}
else
{
System.out.println("WebRockModel created for use of TMWebRock Framework");
this.dataStructure=new HashMap<>();
}
}
}
