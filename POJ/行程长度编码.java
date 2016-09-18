import java.lang.*;
import java.util.*;

public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str = str.toUpperCase();
		int len = str.length();
		char temp = str.charAt(0);
		int count = 1;
		for(int i = 1; i < len; i++){
			if(str.charAt(i) != temp){
				System.out.print("("+String.valueOf(temp)+","+String.valueOf(count)+")");
				temp = str.charAt(i);
				count = 1;
			}
			else{
				count ++;
			}
		}
		System.out.println("("+String.valueOf(temp)+","+String.valueOf(count)+")");
		sc.close();
	}
}