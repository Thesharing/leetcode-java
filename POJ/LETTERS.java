import java.util.*;
import java.lang.*;

public class Main{
	public static int max;
	public static char [][] array;
	public static int [][] index;
	public static int m;
	public static int n;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		sc.nextLine();
		array = new char[m][n];
		index = new int[m][n];
		for(int i = 0; i < m; i++){
			array[i] = sc.nextLine().toCharArray();
		}
		max = 1;
		List<Character> list = new ArrayList<Character>();
		dfs(0, 0, list, 1);
		System.out.println(max);
		sc.close();
	}
	
	public static void dfs(int x, int y, List<Character> list, int count){
		if(list.contains(array[x][y])){
			max = Math.max(max, count - 1);
		}
		else{
			index[x][y] = 1;
			list.add(array[x][y]);
			max = Math.max(max, count);
			if(x > 0 && index[x - 1][y] == 0) dfs(x - 1, y, list, count + 1);
			if(x + 1 < m && index[x + 1][y] == 0) dfs(x + 1, y, list, count + 1);
			if(y > 0 && index[x][y - 1] == 0) dfs(x, y - 1, list, count + 1);
			if(y + 1 < n && index[x][y + 1] == 0) dfs(x, y + 1, list, count + 1);
			index[x][y] = 0;
			list.remove(list.size() - 1);
		}
	}
}

/* http://bailian.openjudge.cn/practice/1154/ 
 * 图染色算法 这里使用的是基于递归的DFS深度优先搜索
 * 只要判断好位置就行
 * Flood Fill https://zh.wikipedia.org/zh/Flood_fill
 */