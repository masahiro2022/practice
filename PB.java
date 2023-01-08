package practice2023_1;

import java.util.Scanner;

public class PB {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("請輸入列數");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++)//外迴圈控制行數 
		{
			for(int j=1;j<=i;j++)//內迴圈控制每行運算式個數 
			{
				System.out.print(i+"*"+j+"="+(i*j)+"\t");//輸出結果運算式
			}
			System.out.println();//換行
		}
	}

}
