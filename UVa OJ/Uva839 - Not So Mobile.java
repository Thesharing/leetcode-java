import java.util.*;
import java.lang.*;

class INT{
	public int value;
	public INT(int value){
		this.value = value;
	}
}

public class Main{
	public static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){	
		int count = sc.nextInt();
		for(int i = 0; i < count; i++){
			boolean res = solve(new INT(0));
			if(res){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
			if(i != count - 1){
				System.out.println();
			}
		}
	}
	
	public static boolean solve(INT w){
		INT w1 = new INT(sc.nextInt());
		INT l1= new INT(sc.nextInt());
		INT w2 = new INT(sc.nextInt());
		INT l2 = new INT(sc.nextInt());
		boolean b1 = true;
		if(w1.value == 0)
			b1= solve(w1);
		boolean b2 = true;
		if(w2.value == 0)
			b2 = solve(w2);
		w.value = w1.value + w2.value;
		return b1 & b2 & (w1.value * l1.value == w2.value * l2.value);
	}
}