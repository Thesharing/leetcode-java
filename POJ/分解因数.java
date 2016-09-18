import java.lang.*;
import java.util.*;

public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for(int i = 0; i < count; i++){
			int num = sc.nextInt();
			System.out.println(divide(num, 2));
		}
		sc.close();
	}
	
	public static int divide(int num, int from){
		if(num == 1){
			return 1;
		}
		else{
			int count = 1;
			int limit = (int)Math.sqrt(num);
			for(int i = from; i <= limit; i++){
				if(num % i ==0){
					count += divide(num/i, i);
				}
			}
			return count;
		}
	}
}

/* http://bailian.openjudge.cn/practice/2749 
 * 思路：按照题意来分解
 * 从小开始分解
 * 以40为例 首先拿到2*2*2*5
 * 然后是2*2*10
 * 2*4*5
 * 2*20
 * 4*10
 * 5*8
 * 40
 * 也就是说 从2开始遍历因数，是因数就继续分解下一个因数
 * 为了保证不重复，因此下一个因数的分解必须不小于上一个因数
 * 也就是说2*2*10不能再分解成2*2*5*2，因为2<5
 * 这样就能保证不重复
 * 通过sqrt可以减少计算量，不过要记住原数本身就是一个分解
 * */
