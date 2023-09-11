package com.thinking.machines.hr.tools;
import java.io.*;
public class PWPrintln
{
public static void main(String []args)
{
try
{
String fileName=args[0];
File file=new File(fileName);
if(file.exists()==false)
{
System.out.println("File: "+fileName+" not found");
return;
}
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(file,"rw");
File tmpFile=new File("tmp.tmp");
if(tmpFile.exists()) tmpFile.delete();
RandomAccessFile tmpRandomAccessFile;
tmpRandomAccessFile=new RandomAccessFile(tmpFile,"rw");
String line;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
line=randomAccessFile.readLine();
line=line.replaceAll("\"","\\\\\"");
tmpRandomAccessFile.writeBytes("pw.println(\""+line+"\");\r\n");
}
System.out.println("tmp.tmp generated");
randomAccessFile.close();
tmpRandomAccessFile.close();
}catch(Exception exception)
{
System.out.println("Problem: "+exception.getMessage());
}
}
}
