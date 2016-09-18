import java.util.*;
import java.math.*;
import java.lang.*;

class FolderNode{
	public String name;
	public FolderNode parent;
	public Set<String> file;
	public List<FolderNode> subfolder;
	public FolderNode(String name, FolderNode parent){
		this.name = name;
		this.parent = parent;
		this.file = new TreeSet<String>();
		this.subfolder = new ArrayList<FolderNode>();
	}
}

public class Main{
	public static String place = "|     ";
	public static void main(String args[]){
		FolderNode root = new FolderNode("ROOT", null);
		FolderNode now = root;
		int count = 1;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String input = sc.nextLine();
			if(input.equals("#")){
				break;
			}
			else if(input.equals("*")){
				displayRoot(root, 0, count);
				System.out.println();
				root = new FolderNode("ROOT", null);
				now = root;
				count++;
				 
			}
			else{
				if(input.charAt(0) == ']'){
					now = now.parent;
				}
				else if(input.charAt(0) == 'd'){
					FolderNode temp = new FolderNode(input, now);
					now.subfolder.add(temp);
					now = temp;
				}
				else if(input.charAt(0) == 'f'){
					now.file.add(input);
				}
			}
		}
		sc.close();
	}
	
	public static void displayRoot(FolderNode root, int num, int count){
		System.out.println("DATA SET "+String.valueOf(count) + ":");
		display(root, 0);
	}
	
	public static void display(FolderNode root, int num){
		output(root.name, num);
		for(int i = 0; i < root.subfolder.size(); i++){
			display(root.subfolder.get(i), num + 1);
		}
		Iterator<String> it = root.file.iterator();
		while(it.hasNext()){
			output(it.next(), num);
		}
	}
	
	public static void output(String s, int num){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < num; i++){
			sb.append(place);
		}
		sb.append(s);
		System.out.println(sb.toString());
	}
}