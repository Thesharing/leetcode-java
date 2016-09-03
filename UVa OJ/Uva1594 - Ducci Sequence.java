import java.lang.*;
import java.util.*;
import java.math.*;

class Main{
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for(int i = 0; i < count; i++){
			int num = sc.nextInt();
			int nums[] = new int[num];
			for(int j = 0; j < num; j++){
				nums[j] = sc.nextInt();
			}
			if(nums.length <= 1){
				System.out.println("LOOP");
				continue;
			}
			boolean zero = checkZero(nums);
			int k = 1000;
			while(zero == false && k-- > 0){
				calcDucci(nums);
				zero = checkZero(nums);
			}
			if(zero){
				System.out.println("ZERO");
			}
			else{
				System.out.println("LOOP");
			}
		}
		sc.close();
	}
	
	public static boolean checkZero(int nums[]){
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != 0)
				return false;
		}
		return true;
	}
	
	public static void calcDucci(int nums[]){
		int temp = Math.abs(nums[nums.length - 1] - nums[0]);
		for(int i = 1; i < nums.length; i++){
			nums[i - 1] = Math.abs(nums [i - 1] - nums[i]);
		}
		nums[nums.length - 1] = temp;
	}
}