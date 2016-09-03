import java.util.*;
import java.lang.*;

class T{
	public int x;
	public int y;
	public T(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Stack<T> stack = new Stack<T>();
		int count = sc.nextInt();
		T[] list= new T[count];
		for(int i = 0; i < count; i++){
			sc.next();
			list[i] = new T(sc.nextInt(), sc.nextInt());
		}
		sc.nextLine();
		while(sc.hasNextLine()){
			String s = sc.nextLine();
			if(s.length() == 1){
				System.out.println("0");
			}
			else{
				int res = 0;
				boolean error = false;
				for(int i = 0; i < s.length(); i++){
					if(Character.isAlphabetic(s.charAt(i))){
						stack.push(list[s.charAt(i) - 'A']);
					}
					else if(s.charAt(i) == ')'){
						T b = stack.pop();
						T a = stack.pop();
						if(a.y != b.x){
							error = true;
							break;
						}
						else{
							res += a.x * a.y * b.y;
							stack.push(new T(a.x, b.y));
						}
					}
				}
				if(error){
					System.out.println("error");
				}
				else{
					System.out.println(String.valueOf(res));
				}
				stack.clear();
			}
		}
	}
}