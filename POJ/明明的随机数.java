import java.lang.*;
import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<Integer>();
            int count = sc.nextInt();
            for(int i = 0; i < count; i++){
                set.add(sc.nextInt());
            }
            int size = set.size();
            System.out.println(size);
            Iterator<Integer> it = set.iterator();
            if(size == 1){
            	System.out.println(it.next());
            }
            else if(size > 1){
            	int temp = it.next();
	            while(it.hasNext()){
	                System.out.print(temp);
	                System.out.print(' ');
	                temp = it.next();
	            }
	            System.out.println(temp);
            }
        sc.close();
    }
}