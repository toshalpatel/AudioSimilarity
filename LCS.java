package LCS;

import java.util.Scanner;

public class LCS {
	
	String string1, string2;
	char[] sequence1, sequence2; //sequence1 is on the column side and sequence2 is on the row side
	
	void initialize(){
		getString();
		
		int m = string1.length();
		int n = string2.length();
		
		sequence1 = new char[m+1];
		sequence2 = new char[n+1];
		
		sequence1 = string1.toCharArray();
		sequence2 = string2.toCharArray();
		
		Cost[][] cost = new Cost[m+1][n+1];
		
		for(int i=0;i<=m;i++)
			for (int j=0; j<=n; j++)
				cost[i][j] = new Cost();
		
		for(int i=0;i<=m;i++)
			sequence1[i] = ' ';
		for(int i=0; i<=n; i++)
			sequence2[i] = ' ';
		
		LongestCommonSubsequence(m, n, cost);
	}
	
	void getString(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the first string:");
		string1 = in.next();
		System.out.println("Enter the second string:");
		string2 = in.next();
	}
	
	int max(int x, int y){
		return (x>y) ? x : y;
	}
	
	void LongestCommonSubsequence(int m, int n, Cost[][] cost){	
		int i=0, j=0;
		for(i=0; i<=m; i++)
			for(j=0; j<=n; j++){
				if(sequence1[i]==' ' || sequence2[j]==' ')
				{
					cost[i][j].value = 0;
					cost[i][j].direction = 'h';
				}
				else
				{
					if(sequence1[i]==sequence2[j])
					{
						cost[i][j].value = max(cost[i-1][j].value, cost[i][j-1].value);
						cost[i][j].direction = (cost[i-1][j].value >= cost[i][j-1].value) ? 'u' : 's';
					}
					else
					{
						cost[i][j].value = cost[i-1][j-1].value++;
						cost[i][j].direction = 'd';
					}
				}
			}
	}
	
	void printSequence(Cost[][] cost, int i, int j, char[] sequence1){
		if(i==0 || j==0)
			return;
		if(cost[i][j].direction=='d'){
			printSequence(cost, i-1, j, sequence1);
			System.out.print(sequence1[i]);
		}
		else
		{
			if(cost[i][j].direction == 'u') 
				printSequence(cost, i-1, j, sequence1);
			else
				printSequence(cost, i, j-1, sequence1);
		}
			
	}
	
	public static void main(String[] args){
		LCS lcs = new LCS();
		lcs.initialize();
	}
}
