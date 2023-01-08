package practice2023_1;

public class PA {

    public static void main (String args[]){
  	  java.util.Scanner sc = new java.util.Scanner(System.in);
  	  System.out.println("請輸入列數");
  	  int n=sc.nextInt();
  	  System.out.println("請輸入行數");
  	  int m=sc.nextInt();
  	  for(int i=2;i<=n;i++)//決定列數  		  
  	  {
  		  for(int j=1;j<=m;j++)//決定行數 
  		  {
  			  System.out.print(i+"*"+j+"="+(i*j)+"\t");  
  		  }
  		  System.out.println();
  	  }
  	  
    }
}
