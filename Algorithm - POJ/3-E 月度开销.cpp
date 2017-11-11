#include <iostream>
#include <cstdio>

using namespace std;

int num[100000];
int m, n;

long long solve(long long left, long long right){
    if(left == right){
        return left;
    }
    else{
        long long mid = (left + right) / 2;
        int month = 0;
        long long cost = 0;
        for(int i = 0; i < n; i++){
            if(cost + (long long)num[i] <= mid){
                cost += (long long)num[i];
            }
            else if((long long)num[i] <= mid){
                month += 1;
                cost = (long long)num[i];
                if(month > m){
                    break;
                }
            }
            else{
                break;
            }
        }
        if(month < m){
            return solve(left, mid);
        }
        else{
            return solve(mid + 1, right);
        }
    }
}


int main(void){
    long long left = 0;
    long long right = 0;
    scanf("%d %d", &n, &m);
    for(int i = 0; i < n; i++){
        scanf("%d", &num[i]);
        if(left < num[i]){
            left = (long long)num[i];
        }
        right += (long long)num[i];
    }
    printf("%lld", solve(left, right));
    return 0;
}