import java.lang.*;
import java.util.*;

public class Main{
	public static int[] res = new int[21];
	public static int[][] square = new int[43][22];
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		walk(21, 0, 0, n);
		System.out.println(res[n]);
	}
	
	public static void walk(int x, int y, int num, int n){
		if(num > n){
			return;
		}
		square[x][y] = 1;
		res[num] ++;
		if(square[x+1][y] != 1)walk(x+1, y, num + 1, n);
		if(square[x-1][y] != 1)walk(x-1, y, num + 1, n);
		if(square[x][y+1] != 1)walk(x, y+1, num + 1, n);
		square[x][y] = 0;
	}
}

/* http://bailian.openjudge.cn/practice/4103/ */