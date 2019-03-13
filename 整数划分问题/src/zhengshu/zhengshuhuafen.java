package zhengshu;

import java.util.Scanner;

public class zhengshuhuafen {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=q(a,a);
        System.out.println(b);

	}
static int q(int n,int m)
{
	if((n<1)||(m<1))
		return 0;
	if((n==1)||(m==1))
		return 1;
	if(n<m)
		return q(n,n);
	if(n==m)
		return q(n,m-1)+1;
	return q(n,m-1)+q(n-m,m);
}
}
