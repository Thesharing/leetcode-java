import java.lang.*;
import java.util.*;

class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for(int i = 0; i < count; i++){
			int d = sc.nextInt();
			int k = sc.nextInt();
			int n = 1;
			for(int j = 0; j < d - 1; j++){
				if(k % 2 == 0){
					k = k / 2;
					n = n * 2 + 1;
				}
				else {
					k = (k + 1) / 2;
					n = n * 2;
				}
			}
			System.out.println(n);
		}
	}
}