import java.util.*;
import java.lang.*;

class TreeNode{
	public TreeNode left;
	public TreeNode right;
	public char val;
	public TreeNode(char val){
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			char front[] = sc.next().toCharArray();
			char mid[] = sc.next().toCharArray();
			TreeNode root = build(0, front.length - 1, 0, mid.length - 1, front, mid);
			display(root);
			System.out.println();
		}
		sc.close();
	}
	
	public static TreeNode build(int L1, int R1, int L2, int R2, char[] front, char[] mid){
		if(L2 > R2){
			return null;
		}
		TreeNode root = new TreeNode(front[L1]);
		int p = L2;
		while(mid[p] != root.val && p <= R2) p++;
		int cnt = p - L2;
		root.left = build(L1 + 1, L1 + cnt, L2, p - 1, front, mid);
		root.right = build(L1 + cnt + 1, R1, p + 1, R2, front, mid);
		return root;
	}
	
	public static void display(TreeNode root){
		if(root != null){
			display(root.left);
			display(root.right);
			System.out.print(root.val);
		}
	}
}

/* http://bailian.openjudge.cn/practice/2255/ */