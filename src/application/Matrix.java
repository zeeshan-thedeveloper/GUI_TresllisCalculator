package application;
import java.util.Scanner;

public class Matrix {

	public static Meta_Data_Holder meta_Data_Holder;
	
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
		System.out.print("Enter a Type of Support: ");
		System.out.print("Enter 1 for (1) simple (tangential tranlation): ");
		System.out.print("Enter 2  double (blocked in translation): ");
		System.out.print("Enter 3  without support: ");
		int supportType= sc.nextInt(); //reads string.
		Check_for_Support_Type(supportType);
		
	}
	
	static void Check_for_Support_Type(int supportType) {
		 if(supportType==1) { 
			
		 }else if(supportType==2) {
			 
		 }
		 else if(supportType==3) {
			 
		 }
		 else {
			 System.out.print("WRONG INPUT ");
		 }
	}

}
