import java.util.*;
import java.lang.*;

public class Main{
	public static char [][] array;
	public static int [][] index;
	public static int m, n;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		sc.nextLine();
		while(m != 0){
			array = new char[m][n];
			index = new int[m][n];
			int count = 0;
			for(int i = 0; i < m; i++){
				array[i] = sc.nextLine().toCharArray();
			}
			for(int i = 0; i < m; i++)
				for(int j = 0; j < n; j++){
					if(index[i][j] == 0 && array[i][j] == '@'){
						dfs(i, j, ++count);
					}
				}
			System.out.println(count);
			m = sc.nextInt();
			n = sc.nextInt();
			sc.nextLine();
		}
	}	
	
	public static void dfs(int x, int y, int count){
		if(x < 0 || x >= m || y < 0 || y >= n) return ;
		if(index[x][y] > 0 || array[x][y] != '@') return;
		index[x][y] = count;
		for(int i = -1; i <= 1; i++)
			for(int j = -1; j <= 1; j++)
				if(i != 0 || j != 0){
					//System.out.println("(" + String.valueOf(i) + "," + String.valueOf(j) + ")");
					dfs(x + i, y + j, count);
				}
	}
}