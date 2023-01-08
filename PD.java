package practice2023_1;

import java.util.Scanner;

public class PD {
	//得到巴斯卡三角方法
private static int[][] getTriangle(int num)//num為列數
{
	int[][] ary=new int[num][num];//用二維陣列儲存
	
	for(int i=0;i<ary.length;i++)//直邊,斜邊設定為1 
	{
		ary[i][0]=1;//直邊項目
		ary[i][i]=1;//斜邊項目
	}
	for(int i=1;i<ary.length;i++)//外迴圈控制行數 
	{
		for(int j=1;j<=i;j++)//內迴圈控制列 
		{
			ary[i][j]=ary[i-1][j-1]+ary[i-1][j];//目前位置的正上方與左上方的和
		}
	}
	return ary;
}
//列印巴斯卡三角方法
private static void print(int[][] ary)//注入產生的巴斯卡三角二位陣列物件 
{
	for(int i=0;i<ary.length;i++)//外迴圈控制行 
	{
		for(int j=0;j<=i;j++)//內迴圈控制列 
		{
			System.out.print(ary[i][j]);//輸出內容
		}
		System.out.println();//換行
	}
}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("請輸入行數");//鍵盤接收行數
		int num=sc.nextInt();
		
		int[][] ary=getTriangle(num);//使用撰寫好的方法-->得到巴斯卡三角
		print(ary);//使用列印輸出巴斯卡三角的方法
			
	}

}
