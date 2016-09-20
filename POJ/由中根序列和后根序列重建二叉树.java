import java.util.*;
import java.lang.*;

class TreeNode{
	public TreeNode left;
	public TreeNode right;
	public int val;
	public TreeNode(int val){
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String a = sc.nextLine();
			String b = sc.nextLine();
			String as[] = a.split("\\s+");
			String bs[] = b.split("\\s+");
			int mid[] = new int[as.length];
			int after[] = new int[bs.length];
			for(int i = 0; i < as.length; i++){
				mid[i] = Integer.parseInt(as[i]);
				after[i] = Integer.parseInt(bs[i]);
			}
			TreeNode root = build(0, mid.length - 1, 0, after.length - 1, mid, after);
			display(root);
		}
		sc.close();
	}
	
	public static TreeNode build(int L1, int R1, int L2, int R2, int[] mid, int[] after){
		if(L1 > R1){
			return null;
		}
		TreeNode root = new TreeNode(after[R2]);
		int p = L1;
		while(mid[p] != root.val && p <= R1) p++;
		int cnt = p - L1;
		root.left = build(L1, p - 1, L2, L2 + cnt - 1, mid, after);
		root.right = build(p + 1, R1, L2 + cnt, R2 - 1, mid, after);
		return root;
	}
	
	public static void display(TreeNode root){
		if(root != null){
			System.out.print(root.val);
			System.out.print(' ');
			display(root.left);
			display(root.right);
		}
	}
}

/* http://qdacm.openjudge.cn/dsweeks/34/ */