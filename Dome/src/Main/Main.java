package Main;

import java.util.Scanner;

public class Main {
    static int[][]  Board=null;
	static int tile=1;
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner n=new Scanner(System.in);
		int k=n.nextInt();
		int x=n.nextInt(),y=n.nextInt();
		int i,j;int m=0;
		m=fun(k);
		Board=new int[m+1][m+1];
		Board[x][y]=0;
		ChessBoard(1,1,x,y,m);
		for(i=1;i<=m;i++) {
			for(j=1;j<=m;j++)
			        System.out.print(Board[i][j]+"\t");
			System.out.println();
		}
	}
public static int fun(int k) {
		if(k==1)return 2;
		else
			return 2*fun(k-1);
}
public static void ChessBoard(int tr,int tc,int dr,int dc,int size) {
	if(size==1)return;
	int t=tile++,s=size/2;
	if(dr<tr+s&&dc<tc+s)
		ChessBoard(tr,tc,dr,dc,s);
	else {
		Board[tr+s-1][tc+s-1]=t;
		ChessBoard(tr,tc,tr+s-1,tc+s-1,s);
	}
	if(dr<tr+s&&dc>=tc+s) {
		ChessBoard(tr,tc+s,dr,dc,s);
	}
	else
	{
		Board[tr+s-1][tc+s]=t;
		ChessBoard(tr,tc+s,tr+s-1,tc+s,s);
	}
	if(dr>=tr+s&&dc<tc+s)
		ChessBoard(tr+s,tc,dr,dc,s);
	else {
		Board[tr+s][tc+s-1]=t;
		ChessBoard(tr+s,tc,tr+s,tr+s-1,s);
	}
	if(dr>=tr+s&&dc>=tc+s)
		ChessBoard(tr+s,tc+s,dr,dc,s);
	else {
		Board[tr+s][tc+s]=t;
		ChessBoard(tr+s,tc+s,tr+s,tc+s,s);
	}
}
}
