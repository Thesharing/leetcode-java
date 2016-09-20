public class Solution {
    public int integerReplacement(int n) {
		if(n == Integer.MAX_VALUE){
			return func(n - 1);
		}
		else{
			return func(n);
		}
    }
	
	public int func(int n){
		if(n == 1){
			return 0;
		}
		else if(n % 2 == 0){
			return func(n / 2) + 1;
		}
		else{
			return Math.min(func(n + 1) + 1, func(n - 1) + 1);
		}
	}
}