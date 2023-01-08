package practice2023_1;

import java.util.Scanner;

public class PC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入金字塔層數");
		
		int n=sc.nextInt();		
	  for(int i=1;i<=n;i++) 
	    {
		  for(int j=1;j<=n-i;j++)//根據外層行號,輸出星號左邊空格數
		  {			  
			System.out.print(" ");
		  }		 
		  for(int k=1;k<=2*i-1;k++)//根據外層行數,輸出星號個數 
		  {
			System.out.print("*");
		  }
		  System.out.println();
	    }
    }
}
