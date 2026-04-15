package javaProgram;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MJavaCode {
	
	public static void main(String[] args) {
		
		// HCF of number 
		 int a= 15;
		 int b = 126;
		 int min;
		 
		 if (a>b) {
			 min =a;
		 }else {
			 min = b;
		 }
		 
		 
		while (true) {
			if (a%min==0 && b%min==0) {
				System.out.println(min);
				break;
			}
			min--;
		}
	
	
	//LCM of number
	int x=20;
	int y = 15;
	int max= 20; 
	
	while (true){
		
		if (max%x==0 && max%y==0) {
			System.out.println(max);
			break;
		}
		max++;
	}
	
 // prime number
	int p=175;
	int countFactors=0;
	
	for(int i = 1; i<=p; i++) {
		if (p%i==0) {
			countFactors++;
		}
	}
	if (countFactors>2) {
		System.out.println(p+" is not prime");
	}else {
		System.out.println(p+" is prime");
	}
	
// armstrong number
	
	for (int i=1;i<=1000;i++) {
		int sum=0;
	int num = i;
	 while(num>0) {
		 sum=sum+ (num%10)*(num%10)*(num%10);
		 num=num/10;
	 }
	if (sum==i) {
		System.out.println(i + " is Armstrong Number");
	}
  }
	
	//Palindrome number
	int num = 1221;
	int original=num;
	int reverse = 0;
	while (num>0) {
		int digit=num%10;
		reverse=reverse*10+digit;
		num=num/10;
	}
	if (reverse==original) {
		System.out.println(original + " is Palindrome number");
	}
	
	// palindrome string
	String d="hahah";
	String reVerse="";
	for (int i=d.length()-1; i>=0; i--) {
		
		reVerse=reVerse+d.charAt(i);
	}
	if (d.equals(reVerse)) {
		System.out.println(reVerse+ " is a Palindrome String");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 ArrayList arrlist = new ArrayList(); 
 System.out.println( arrlist.add(12));
 arrlist.add(" String 13");
 arrlist.add(14);
 //System.out.println(arrlist);

 String str="";
 
 String str2= "abbdcadcbefggh";
 int count=1;
Set set= new HashSet();
 for(int i=0; i<=str2.length()-1;i++) {
	 for(int j=i+1; j<=str2.length()-1;j++) {
		if(str2.charAt(i) == str2.charAt(j)) {
			count=count+1;
			set.add(str2.charAt(i));
			
		}
		
	 }
 }
 System.out.println(set);
 
 

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
  }	
}
