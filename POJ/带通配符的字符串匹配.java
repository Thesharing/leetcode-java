import java.util.*;
import java.lang.*;
import java.util.regex.*;

public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String str = sc.nextLine();
			str = str.replace("*", ".*");
			str = str.replace("?", ".");
			String s = sc.nextLine();
			Pattern p = Pattern.compile(str);
			Matcher m = p.matcher(s);
			if(m.matches()){
				System.out.println("matched");
			}
			else{
				System.out.println("not matched");
			}
		}
		sc.close();
	}
}