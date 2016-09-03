import java.lang.*;
import java.util.*;

class Node{
	public int value;
	public boolean given;
	public Node left;
	public Node right;
	
	Node(){
		this.value = 0;
		this.given = false;
		this.left = null;
		this.right = null;
	}
	Node(int value){
		this.value = value;
		this.given = true;
		this.left = null;
		this.right = null;
	}
}

class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Node root = new Node();
		boolean wrong = false;
		String input;
		while(sc.hasNext()){
			input = sc.next();
			if(input.length() > 2){
				int pos = input.indexOf(',');
				int value = Integer.parseInt(input.substring(1, pos));
				String str = "";
				if(pos < input.length() - 2){
					str = input.substring(pos + 1, input.length() - 1);
				}
				Node now = root;
				for(int i = 0; i < str.length(); i++){
					if(str.charAt(i) == 'L'){
						if(now.left == null){
							now.left = new Node();
						}
						now = now.left;
					}
					else{
						if(now.right == null){
							now.right = new Node();
						}
						now = now.right;
					}
				}
				if(now.given == false){
					now.value = value;
					now.given = true;
				}
				else{
					if(now.value != value)
						wrong = true;
				}
			}
			else{
				String res = "";
				if(!wrong){
					LinkedList<Node> list = new LinkedList<Node>();
					list.addLast(root);
					while(!list.isEmpty()){
						Node now = list.removeFirst();
						if(now.given == false){
							wrong = true;
							break;
						}
						res = res + String.valueOf(now.value) + " ";
						if(now.left != null){
							list.addLast(now.left);
						}
						if(now.right != null){
							list.addLast(now.right);
						}
					}
				}
				if(wrong){
					System.out.println("not complete");
				}
				else{
					System.out.println(res.substring(0, res.length() - 1));
				}
				root = new Node();
				wrong = false;
			}
		}
		sc.close();
	}
}