import java.util.*;
import java.lang.*;
import java.math.*;

class Node{
	int value;
	Node left;
	Node right;
	
	public Node(int value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

public class Main{
	public static int minLeaf = Integer.MAX_VALUE;
	public static int minWeight = Integer.MAX_VALUE;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String midStr = sc.nextLine();
			String afterStr = sc.nextLine();
			String mids[] = midStr.split("\\s");
			String afters[] = afterStr.split("\\s");
			int n = mids.length;
			int mid[] = new int[n];
			int after[] = new int[n];
			for(int i = 0; i < n; i++){
				mid[i] = Integer.parseInt(mids[i]);
				after[i] = Integer.parseInt(afters[i]);
			}
			Node start = build(0, n-1, 0, n-1, after, mid);		
			calWeight(start, 0);
			System.out.println(minLeaf);
			minLeaf = Integer.MAX_VALUE;
			minWeight = Integer.MAX_VALUE;
		}
	}
	
	public static Node build(int L1, int R1, int L2, int R2, int[] after, int[] mid){
		if(L1 > R1) return null;
		Node root = new Node(after[R2]);
		int p = L1;
		while(mid[p] != root.value)p++;
		int cnt = p - L1;
		root.left = build(L1, p-1, L2, L2+cnt-1, after, mid);
		root.right = build(p+1, R1, L2+cnt, R2 - 1, after, mid);
		return root;
	}
	
	public static void calWeight(Node node, int weight){
		if(node.left == null && node.right == null){
			if(node.value + weight < minWeight){
				minWeight = node.value + weight;
				minLeaf = node.value;
			}
		}
		else {
			if(node.left != null){
				calWeight(node.left, weight + node.value);
				
			}
			if(node.right != null){
				calWeight(node.right, weight + node.value);
			}
		}
	}
}