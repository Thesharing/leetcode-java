import java.lang.*;
import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<Integer>();
        while(sc.hasNextInt()){
            int count = sc.nextInt();
            for(int i = 0; i < count; i++){
                set.add(sc.nextInt());
            }
            Iterator<Integer> it = set.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
            set.clear();
        }
        sc.close();
    }
}