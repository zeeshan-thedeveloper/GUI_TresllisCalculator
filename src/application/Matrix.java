package application;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;

public  class Matrix {
	
public static Meta_Data_Holder meta_Data_Holder;
public static void main(String args[]) {

}
//**************************** Writing on a File ***********************************
static void Printing_All_Data_on_File(String Name_Of_File,Meta_Data_Holder Accessing_Data) {

 
// zone constructor string

String Zone_contruct_Data="ZoneConstructible;"+0.5+";"+4.0+";"+(-5.0)+";"+1.0+"\n";


// Triangle type string
String Triangle_Data="";

int no_of_triangle=Accessing_Data.getPoint_Data().length;
no_of_triangle= no_of_triangle/3;

for(int i=0;i<no_of_triangle;i++) {
Triangle_Data+="Triangle;"+i+1;
for(int j=0;j<3;j++) {
Triangle_Data+=";("+Accessing_Data.point_Data[j].i+","+Accessing_Data.point_Data[j].j+");";
}
}

// bar type string
float cost=0, min_length=0,max_length=0,max_tensile_strength=0,resistence=0;

String BarType= "TypeBarre;"+cost+";"+min_length+";"+max_length+";"+max_tensile_strength+";"+resistence;


//Double Support
int support_no=0;
//String Double_Support="AppuiDouble;"+(support_no+1)+";"+1+";";




try{
FileWriter fwr=new FileWriter(Name_Of_File+".txt",false);
   fwr.write("");
   fwr.close();
}catch(Exception ex){}
}




static void Reading_Data_from_File(Meta_Data_Holder data_Holder) {
JFileChooser fileChooser=new JFileChooser();
int response1=fileChooser.showOpenDialog(null);
if(response1==fileChooser.APPROVE_OPTION)
{
File fileCreate=fileChooser.getSelectedFile();
File file=new File(fileCreate.getAbsolutePath());
try{
Scanner reader=new Scanner(file);
String data="";
while(reader.hasNextLine()){
data +=(reader.nextLine())+"\n";
}
Extract_Data(data,data_Holder);
}
catch(Exception ex){
System.out.println("Exception_Error");
}
}
else if(response1==fileChooser.CANCEL_OPTION)
{
System.out.print("Cancel");
}
else if(response1==fileChooser.ERROR_OPTION){
System.out.print("Error ");
}
}

static void Extract_Data(String Data,Meta_Data_Holder Accessing_Data) {

String Store_EachLine[] = Data.split("\n");
for(int i=0;i<Store_EachLine.length;i++)
{  
String Each_line_data[]= Store_EachLine[i].split(";");
        if(Each_line_data[0].equals("ZoneConstructible")) {
        Zone_contruct(Each_line_data,Accessing_Data);
        }
        else if(Each_line_data[0].equals("Triangle")) {
        Triangle(Each_line_data,Accessing_Data);
        }
        else if(Each_line_data[0].equals("TypeBarre")) {
        Type_Bar(Each_line_data,Accessing_Data);
       
        }
        else if(Each_line_data[0].equals("AppuiDouble")) {
        Double_Support(Each_line_data,Accessing_Data);
       
        }
        else if(Each_line_data[0].equals("AppuiSimple")) {
        Simple_Support(Each_line_data,Accessing_Data);
        }
         else if(Each_line_data[0].equals("NoeudSimple")) {
        Simple_Node(Each_line_data,Accessing_Data);
        }
         else if(Each_line_data[0].equals("Barre")) {
        Bar(Each_line_data,Accessing_Data);
         }
       
}
}
static void Zone_contruct(String Data[],Meta_Data_Holder Ac) {
System.out.println("Zone Data");
for(int i=0;i<Data.length;i++) {
System.out.println(Data[i]);
}

}
static void Triangle(String Data[],Meta_Data_Holder Ac) {
try {
Points p1 = new Points();
Points p2 = new Points();
Points p3 = new Points();



p2.setI(-4.0F);
p2.setJ(-2.0F);

p2.setI(0.0F);
p2.setJ(-5.0F);

System.out.println("Triangle Data");
float pointX=0,pointY=0;
for(int i=2;i<Data.length;i++) {
if(i==2) {
String points_Data[]=Data[i].split(",");

for(int j=0;j<=points_Data.length-1;j++)
{   String result = points_Data[j].replaceAll("[(){}]","");
 try {
   if(j==0) {
pointX=Float.parseFloat(result);
System.out.println("X is:"+pointX);
p1.setI(pointX);

   }
   else if(j==1) {
    pointY=Float.parseFloat(result);
    System.out.println("Y is:"+pointY);
    p1.setJ(pointY);
   }
   Ac.point_Data[0]=p1;
 }catch(Exception ex) {
 System.out.println(ex);
 }
}
}else if(i==3) {
String points_Data[]=Data[i].split(",");

for(int j=0;j<=points_Data.length-1;j++)
{   String result = points_Data[j].replaceAll("[(){}]","");
 try {
   if(j==0) {
pointX=Float.parseFloat(result);
System.out.println("X is:"+pointX);
p2.setJ(pointX);
   }
   else if(j==1) {
    pointY=Float.parseFloat(result);
    System.out.println("Y is:"+pointY);
    p2.setJ(pointY);
   }
   Ac.point_Data[1]=p2;
 }catch(Exception ex) {
 System.out.println(ex);
 }
}
}else if(i==4) {

String points_Data[]=Data[i].split(",");

for(int j=0;j<=points_Data.length-1;j++)
{   String result = points_Data[j].replaceAll("[(){}]","");
 try {
   if(j==0) {
pointX=Float.parseFloat(result);
System.out.println("X is:"+pointX);
p3.setJ(pointX);
   }
   else if(j==1) {
    pointY=Float.parseFloat(result);
    System.out.println("Y is:"+pointY);
    p3.setJ(pointY);
   }
   Ac.point_Data[2]=p3;
 }catch(Exception ex) {
 System.out.println(ex);
 }
}
}




}
}catch(Exception ex) {}
}

    static void Type_Bar(String Data[],Meta_Data_Holder Ac) {
    System.out.println("Type bar Data");
    String cost=Data[2], min_length=Data[3],max_length=Data[4],max_tensile_strength=Data[5],resistence=Data[6];
   
}
   
    static void Double_Support(String Data[],Meta_Data_Holder Ac) {
    System.out.println("Double support Data");
for(int i=0;i<Data.length;i++) {
System.out.println(Data[i]);
}
}
    static void Simple_Support(String Data[],Meta_Data_Holder Ac) {
    System.out.println("simple support Data");
for(int i=0;i<Data.length;i++) {
System.out.println(Data[i]);
}
}
    static void Simple_Node(String Data[],Meta_Data_Holder Ac) {
    System.out.println("simple Node Data");
for(int i=0;i<Data.length;i++) {
System.out.println(Data[i]);
}
}
     static void Bar(String Data[],Meta_Data_Holder Ac) {
    System.out.println("Bar  Data");
  for(int i=0;i<Data.length;i++) {
  System.out.println(Data[i]);
  }
}








}