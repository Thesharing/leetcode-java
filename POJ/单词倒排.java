import java.lang.*;
import java.util.*;

public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String str[] = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for(int i = str.length - 1; i > 0; i--){
			sb.append(str[i]);
			sb.append(' ');
		}
		sb.append(str[0]);
		System.out.println(sb.toString());
		sc.close();
	}
}