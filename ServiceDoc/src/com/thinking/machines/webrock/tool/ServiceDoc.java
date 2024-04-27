package com.thinking.machines.webrock.tool;
import com.thinking.machines.webrock.util.*;
import com.thinking.machines.webrock.model.*;
import com.thinking.machines.webrock.pojo.*;
import java.util.*;
import java.io.*;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;
import com.itextpdf.layout.element.*;
import com.itextpdf.kernel.font.*;
import com.itextpdf.io.font.constants.*;
import com.itextpdf.layout.property.*;


public class ServiceDoc
{
private static byte numberOfAttributesOfService=2*16+1;
private static Cell createCell(Service service,int i)
{
Paragraph cellParagraph=null;
Cell cell=null;
try
{
PdfFont keyFont=PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);

if(i==0)
{
cellParagraph=new Paragraph(service.getServiceClass().getName());
cellParagraph.setFont(keyFont);
cellParagraph.setFontSize(14);
cell=new Cell(1,2);
cell.add(cellParagraph);
}
else if(i==1)
{
cell=new Cell();
cell.add(new Paragraph("Path: "));
}
else if(i==2)
{
cell=new Cell();
cell.add(new Paragraph(service.getPath()));
cell.setTextAlignment(TextAlignment.CENTER);
}
else if(i==3)
{
cell=new Cell();
cell.add(new Paragraph("Class: "));
}
else if(i==4)
{
cell=new Cell();
cell.add(new Paragraph(service.getServiceClass().getSimpleName()));
cell.setTextAlignment(TextAlignment.CENTER);
}
else if(i==5)
{
cell=new Cell();
cell.add(new Paragraph("Method Name: "));
}
else if(i==6)
{
cell=new Cell();
cell.add(new Paragraph(service.getService().getName()));
cell.setTextAlignment(TextAlignment.CENTER);
}
else if(i==7)
{
cell=new Cell();
cell.add(new Paragraph("Parameters: "));
}
else if(i==8)
{
cell=new Cell();
cell.add(new Paragraph("later on"));
cell.setTextAlignment(TextAlignment.CENTER);
}
else if(i==9)
{
cell=new Cell();
cell.add(new Paragraph("Return Type: "));
}
else if(i==10)
{
cell=new Cell();
cell.add(new Paragraph("later on"));
cell.setTextAlignment(TextAlignment.CENTER);
}
else if(i==11)
{
cell=new Cell();
cell.add(new Paragraph("GET Type Request Allowed: "));
}
else if(i==12)
{
cell=new Cell();
if(service.getIsGetAllowed()) cell.add(new Paragraph("Yes"));
else cell.add(new Paragraph("No"));
cell.setTextAlignment(TextAlignment.CENTER);
}
else if(i==13)
{
cell=new Cell();
cell.add(new Paragraph("POST Type Request Allowed: "));
}
else if(i==14)
{
cell=new Cell();
if(service.getIsPostAllowed()) cell.add(new Paragraph("Yes"));
else cell.add(new Paragraph("No"));
cell.setTextAlignment(TextAlignment.CENTER);
}
else if(i==15)
{
cell=new Cell();
cell.add(new Paragraph("Startup Service: "));
}
else if(i==16)
{
cell=new Cell();
if(service.getRunOnStartup()) cell.add(new Paragraph("Yes and its priority: "+service.getPriority()));
else cell.add(new Paragraph("No"));
cell.setTextAlignment(TextAlignment.CENTER);
}
else if(i==17)
{
cell=new Cell();
cell.add(new Paragraph("Application Directory Inject: "));
}
else if(i==18)
{
cell=new Cell();
if(service.getInjectApplicationDirectory()) cell.add(new Paragraph("Yes"));
else cell.add(new Paragraph("No"));
cell.setTextAlignment(TextAlignment.CENTER);
}
else if(i==19)
{
cell=new Cell();
cell.add(new Paragraph("Application Scope Inject: "));
}
else if(i==20)
{
cell=new Cell();
if(service.getInjectApplicationScope()) cell.add(new Paragraph("Yes"));
else cell.add(new Paragraph("No"));
cell.setTextAlignment(TextAlignment.CENTER);
}
else if(i==21)
{
cell=new Cell();
cell.add(new Paragraph("Session Scope Inject: "));
}
else if(i==22)
{
cell=new Cell();
if(service.getInjectSessionScope()) cell.add(new Paragraph("Yes"));
else cell.add(new Paragraph("No"));
cell.setTextAlignment(TextAlignment.CENTER);
}
else if(i==23)
{
cell=new Cell();
cell.add(new Paragraph("Request Scope Inject: "));
}
else if(i==24)
{
cell=new Cell();
if(service.getInjectRequestScope()) cell.add(new Paragraph("Yes"));
else cell.add(new Paragraph("No"));
cell.setTextAlignment(TextAlignment.CENTER);
}
else if(i==25)
{
cell=new Cell();
cell.add(new Paragraph("Auto Wired Property: "));
}
else if(i==26)
{
cell=new Cell();
if(service.getAutoWired()==null) cell.add(new Paragraph("later on"));
else cell.add(new Paragraph("No"));
cell.setTextAlignment(TextAlignment.CENTER);
}
else if(i==27)
{
cell=new Cell();
cell.add(new Paragraph("Request Parameters: "));
}
else if(i==28)
{
cell=new Cell();
if(service.getRequestedParameterList()==null) cell.add(new Paragraph("later on"));
else cell.add(new Paragraph("No"));
cell.setTextAlignment(TextAlignment.CENTER);
}
else if(i==29)
{
cell=new Cell();
cell.add(new Paragraph("JSON come from Client: "));
}
else if(i==30)
{
cell=new Cell();
if(service.getIsJSONRequired()) cell.add(new Paragraph("JSON might come from Client,So Reffer Docs: Yes"));
else cell.add(new Paragraph("No"));
cell.setTextAlignment(TextAlignment.CENTER);
}
else if(i==31)
{
cell=new Cell();
cell.add(new Paragraph("Guard Applied: "));
}
else if(i==32)
{
cell=new Cell();
if(service.getGuard()!=null) cell.add(new Paragraph("later on"));
else cell.add(new Paragraph("No"));
cell.setTextAlignment(TextAlignment.CENTER);
}


}catch(IOException ioException)
{
// do nothing;
}
return cell;
}

public static void main(String []args)
{
if(args.length==0)
{
System.out.println("Path to classes folder required at 0th argument");
System.out.println("Path to pdf file required at 1st argument");
return;
}
else if(args.length==1)
{
System.out.println("Path to pdf file required at 1st argument");
return;
}

String pathToClassesFolder=args[0];
String pathToPdfFile=args[1];

System.out.println("Path To Classes Folder: "+pathToClassesFolder);

System.out.println("Path To Pdf File: "+pathToPdfFile);


String prefix=pathToClassesFolder.substring(pathToClassesFolder.lastIndexOf(File.separator)+1);

System.out.println("Prefix will be: "+prefix);

System.out.println("-------------------------------------------");

java.util.List<String> list=TMAnalyze.processToFindAllClassesName(pathToClassesFolder,"bobby");

for(String classes: list) System.out.println("-------: "+classes);

java.util.List<Service> startupList=new ArrayList<>();

WebRockModel model=TMAnalyze.processToPopulateDataStructures(list,startupList,"","",true);

System.out.println("Total Services in WebRockModel is: "+model.dataStructure.size());



try
{

File file=new File(pathToPdfFile);
if(file.exists())
{
System.out.println("PDF found, I deleted the old pdf");
file.exists();
}
PdfWriter pdfWriter=new PdfWriter(file);
PdfDocument pdfDocument=new PdfDocument(pdfWriter);
Document document=new Document(pdfDocument);
document.setMargins(20,20,20,20);
float []columnWidth={5,5}; // may be these number represents the width of column

Table table=new Table(UnitValue.createPercentArray(columnWidth));


Cell headingCell=new Cell(1,3).add(new Paragraph("Provided by Service Doc"));
table.addHeaderCell(headingCell);

PdfFont titleFont=PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);




model.dataStructure.forEach((key,service)->{
for(int i=0;i<numberOfAttributesOfService;i++)
{
table.addCell(createCell(service,i));
}

});

document.add(table);
document.close();

}catch(Exception exception)
{
System.out.println("Problem: "+exception.getMessage());
}


}
}
