import java.util.*;
import java.lang.*;
import java.math.*;

public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int loccount = sc.nextInt();
		sc.nextLine();
		List<String> loclist = new ArrayList<String>();
		for(int i = 0; i < loccount; i++){
			loclist.add(sc.nextLine());
		}
		int pathcount = sc.nextInt();
		sc.nextLine();
		int [][]path = new int[loccount][loccount];
		for(int i = 0; i < loccount; i++)
			for(int j = 0; j < loccount; j++)
				path[i][j] = 100000;
		for(int i = 0; i < pathcount; i++){
			String aS = sc.next();
			String bS = sc.next();
			int a = loclist.indexOf(aS);
			int b = loclist.indexOf(bS);
			if(a != b){
				int len = sc.nextInt();
				path[b][a] = Math.max(len, path[b][a]);
				path[a][b] = Math.max(len, path[a][b]);
			}
			sc.nextLine();
		}
		int targetcount = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < targetcount; i++){
			String aS = sc.next();
			String bS = sc.next();
			int a = loclist.indexOf(aS);
			int b = loclist.indexOf(bS);
			List<Integer> respath = new ArrayList<Integer>();
			sp(path, respath, a, b);
			for(int j = 0; j < respath.size() - 1; j++){
				System.out.print(loclist.get(respath.get(j))+"->("+String.valueOf(path[respath.get(j)][respath.get(j + 1)])+")->");
			}
			System.out.println(loclist.get(b));
		}
	}
	
	public static void sp(int[][] g, List<Integer> path, int a, int b){
		boolean find[] = new boolean[g.length];
		int d[] = new int[g.length];
		int previous[] = new int[g.length];
		for(int i = 0; i < g.length; i++){
			d[i] = g[a][i];
			if(g[a][i] != 100000){
				previous[i] = a;
			}
		}
		d[a] = 0;
		find[a] = true;
		previous[a] = a;
		int findcount = 1;
		while(findcount < g.length){
			int min = 100000;
			int v = a;
			for(int i = 0; i < g.length; i++){
				if(!find[i]){
					if(d[i] < min){
						v = i;
						min = d[i];
					}
				}
			}
			find[v] = true;
			findcount++;
			for(int i = 0; i < g.length; i++){
				if(!find[i] && (min + g[v][i] < d[i])){
					d[i] = min + g[v][i];
					previous[i] = v;
				}
			}
		}
		int now = b;
		path.clear();
		while(now != a){
			path.add(0, now);
			now = previous[now];
		}
		path.add(0, now);
	}
}

/* http://dsalgo.openjudge.cn/graph/1/ */